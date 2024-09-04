package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.Students;
import com.example.StudentManagement.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepo repo;


    public List<Students> getAllStudents()
    {
        return repo.findAll();
    }

    public Students getStudentById(int studId) throws StudentException {
        return repo.findById(studId).orElseThrow(() -> new StudentException("User Not Found"));
    }

    public List<Students> getMultipleStudentsByIds(List<Integer> ids)
    {
        return repo.findAllById(ids);
    }

    public List<Students> getStudentByAge(int age)
    {
        return repo.findByAge(age);
    }

    public List<Students> getStudentByName(String studName)
    {
        return repo.findByName(studName);
    }

    public void addStudents(Students stud)
    {
        repo.save(stud);
    }

    public void updateStudents(int studId, Students stud) throws StudentException {
        Students student = repo.findById(studId).orElseThrow(() -> new StudentException("Id is Not in Database"));
        student.setName(stud.getName());
        student.setAge(stud.getAge());
        repo.save(stud);
    }

    public void deleteStudentById(int studId)
    {
        repo.deleteById(studId);
    }
}
