package com.example.zamowposilek.CreateSchool.Repository;

import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClass;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;


public interface SchoolClassRepository extends CrudRepository<SchoolClass,Integer> {
   Set<SchoolClass> findAll();
    Optional<SchoolClass>findByClassName(String className);
    Set<SchoolClass>findByClassNameContainingIgnoreCase(String className);
}
