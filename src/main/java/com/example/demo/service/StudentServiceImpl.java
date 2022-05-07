package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getById(Integer studentId) {
        return studentDao.getById(studentId);
    }

    @Override
    public String addTest1(Student student) {
        studentDao.insertTest1(student);
        return "insert a student in test1 database";
    }

    @Override
    public String addTest2(Student student) {
        studentDao.insertTest2(student);
        return "insert a student in test2 database";
    }
}
