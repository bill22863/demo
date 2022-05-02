package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /*@PostMapping
    public String create(@RequestBody @Valid Student student){
        return "create student";
    }

    @GetMapping("/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId){
        return "read student";
    }

    @PutMapping("/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
        return "update student";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return "delete student";
    }*/

    @PostMapping
    public String insert(@RequestBody Student student){
        Map<String, Object> map = new HashMap<>();
        String sql = "INSERT INTO student(name) VALUE (:studentName)";
        map.put("studentName" , student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        // get auto generated id
        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 id 為 " + id);

        return  "insert a new student.";
    }

    @PostMapping("/batch")
    public String batchInsert(@RequestBody List<Student> studentList){
        String sql = "INSERT INTO student(name) VALUE (:studentName)";
        MapSqlParameterSource[] parameterSources = new MapSqlParameterSource[studentList.size()];
        for (int i = 0; i < studentList.size(); i++){
            Student student = studentList.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName" , student.getName());
        }        Map<String, Object> map = new HashMap<>();

        namedParameterJdbcTemplate.batchUpdate(sql, parameterSources);


        return  "batch insert students.";
    }

    @DeleteMapping("/{studentId}")
    public String delete(@PathVariable Integer studentId){
        Map<String, Object> map = new HashMap<>();
        String sql = "DELETE FROM student WHERE id = :studentId";
        map.put("studentId" , studentId);

        namedParameterJdbcTemplate.update(sql, map);
        return  "delete a new student.";
    }

    @GetMapping
    public List<Student> getStudents(){
        String sql = "SELECT id, name FROM student";
        Map<String, Object> map = new HashMap<>();
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        return list;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        String sql = "SELECT id, name FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        return list.size() > 0 ? list.get(0) : null;
    }


}
