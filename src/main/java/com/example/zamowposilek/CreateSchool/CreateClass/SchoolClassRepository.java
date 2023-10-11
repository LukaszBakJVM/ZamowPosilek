package com.example.zamowposilek.CreateSchool.CreateClass;


import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.Set;


public interface SchoolClassRepository extends CrudRepository<SchoolClass,Integer> {
    Optional<SchoolClass>findByClassName(String className);
    Optional<SchoolClass>findByClassNameAndSchoolName(String className,String schoolName);
   Set<SchoolClass> findAll();


    Set<SchoolClass>findByClassNameContainingIgnoreCase(String className);

}
