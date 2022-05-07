package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import com.example.demo.service.StudentService;
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
@RequestMapping
@Validated
public class StudentController {
//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private StudentService studentService;

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

    @PostMapping("/test1/students")
    public String insertTest1Db(@RequestBody Student student){
        return studentService.addTest1(student);

    }

    @PostMapping("/test2/students")
    public String insertTest2Db(@RequestBody Student student){
        return studentService.addTest2(student);
    }

    /*@PostMapping("/batch")
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
    }*/

    /*@GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return studentService.getById(studentId);
    }*/


}
