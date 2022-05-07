package com.example.demo.service;

import com.example.demo.Student;

public interface StudentService {
    Student getById(Integer studentId);

    String addTest1(Student student);

    String addTest2(Student student);
}
