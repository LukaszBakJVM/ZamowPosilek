package com.example.zamowposilek.CreateSchool.Repository;

import com.example.zamowposilek.CreateSchool.CreateClass.Student.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
