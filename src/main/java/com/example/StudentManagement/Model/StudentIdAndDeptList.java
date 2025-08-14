package com.example.StudentManagement.Model;

import java.util.ArrayList;
import java.util.List;

public class StudentIdAndDeptList
{
    private List<Integer> studentsIds =  new ArrayList<>();
    private List<String> studentsDept = new ArrayList<>();


    public List<Integer> getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(List<Integer> studentsIds) {
        this.studentsIds = studentsIds;
    }

    public List<String> getStudentsDept() {
        return studentsDept;
    }

    public void setStudentsDept(List<String> studentsDept) {
        this.studentsDept = studentsDept;
    }
}
