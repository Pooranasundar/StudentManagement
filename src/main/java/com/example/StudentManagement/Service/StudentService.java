package com.example.StudentManagement.Service;

import com.example.StudentManagement.Model.StudentIdAndDeptList;
import com.example.StudentManagement.Model.Students;
import com.example.StudentManagement.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public Map<String, Object> getStudentsByIdsAndDepartments(StudentIdAndDeptList idAndDeptList) {
        List<Students> students = repo.findByIdInAndDeptIn(idAndDeptList.getStudentsIds(), idAndDeptList.getStudentsDept());

        //(Students -> Students.getId(),Students -> Students.getDept())

        Map<Integer, String> studentsMap = students.stream().collect(Collectors.toMap(Students::getId, Students::getName));

        Map<Integer, String> studentsDeptMap = students.stream().collect(Collectors.toMap(Students::getId,
                Students::getDept));

        List<String> notInDepartment = new ArrayList<>();

        for (Integer id : idAndDeptList.getStudentsIds()) {
            if (!studentsMap.containsKey(id)) {
                notInDepartment.add("Student with ID " + id + " is not in the specified departments.");
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("Students ", studentsMap);
        result.put("Student Not In Department", notInDepartment);

        return result;
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


    public Students getEmployeeFromCity(String city)
        {

        }

}
