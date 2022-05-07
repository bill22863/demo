package com.example.demo.dao;

import com.example.demo.Student;
import com.example.demo.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao {
    /*@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getById(Integer studentId) {
        String sql = "SELECT id, name FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);

        List<Student> list = namedParameterJdbcTemplate.query(sql, map, new StudentRowMapper());
        return list.size() > 0 ? list.get(0) : null;
    }*/

    @Autowired
    private NamedParameterJdbcTemplate test1JdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate test2JdbcTemplate;


    @Override
    public Student getById(Integer studentId) {
        return null;
    }

    @Override
    public void insertTest1(Student student) {
        Map<String, Object> map = new HashMap<>();
        String sql = "INSERT INTO student(name) VALUE (:studentName)";
        map.put("studentName" , student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        test1JdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        // get auto generated id
        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 id 為 " + id);
    }

    @Override
    public void insertTest2(Student student) {
        Map<String, Object> map = new HashMap<>();
        String sql = "INSERT INTO student(name) VALUE (:studentName)";
        map.put("studentName" , student.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        test2JdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        // get auto generated id
        int id = keyHolder.getKey().intValue();
        System.out.println("mysql 自動生成的 id 為 " + id);
    }


}
