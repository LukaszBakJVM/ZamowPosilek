package com.example.zamowposilek.School.Repository;

import com.example.zamowposilek.School.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student,Integer> {
}
