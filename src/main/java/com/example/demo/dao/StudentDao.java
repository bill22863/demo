package com.example.demo.dao;


import com.example.demo.Student;
import org.springframework.web.bind.annotation.RequestBody;

public interface StudentDao {
     Student getById(Integer studentId);

     void insertTest1(Student student);

     void insertTest2(Student student);
}
