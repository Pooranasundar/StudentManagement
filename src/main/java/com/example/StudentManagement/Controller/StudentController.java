package com.example.StudentManagement.Controller;

import com.example.StudentManagement.Model.Students;
import com.example.StudentManagement.Service.StudentException;
import com.example.StudentManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private StudentService service;

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Poorna ";
    }

    @GetMapping("/all/students")
    public List<Students> getAllStudents()
    {
        return service.getAllStudents();
    }

    @GetMapping("/student/{studId}")
    public Students getStudentById(@PathVariable int  studId) throws StudentException
    {
            return service.getStudentById(studId);
    }

    @GetMapping("/multipleids/ids")
    public List<Students> getMultipleStudentsById(@RequestParam List<Integer> ids)
    {
        return service.getMultipleStudentsByIds(ids);
    }

    @GetMapping("/student/age/{studAge}")
    public List<Students> getStudentByage(@PathVariable int studAge)
    {
        return service.getStudentByAge(studAge);
    }

    @GetMapping("/student/name/{studName}")
    public List<Students> getStudentByName(@PathVariable String studName)
    {
        return service.getStudentByName(studName);
    }

    @PostMapping("/add/student")
    public void addStudents(@RequestBody Students stud)
    {
        service.addStudents(stud);
    }

    @PutMapping("/update/student/{studId}")
    public void updateStudent(@PathVariable int studId,@RequestBody Students stud) throws StudentException {
        service.updateStudents(studId,stud);
    }

    @DeleteMapping("/delete/student/{studId}")
    public void deleteStudent(@PathVariable int studId)
    {
        service.deleteStudentById(studId);
    }
}
