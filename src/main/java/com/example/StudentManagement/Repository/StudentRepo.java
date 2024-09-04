package com.example.StudentManagement.Repository;

import com.example.StudentManagement.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer>
{

    List<Students> findByAge(int age);

    List<Students> findByName(String name);
}
