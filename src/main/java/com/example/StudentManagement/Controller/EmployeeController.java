package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Students;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    StudentService service;



}
