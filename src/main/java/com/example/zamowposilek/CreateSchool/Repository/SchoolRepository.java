package com.example.zamowposilek.CreateSchool.Repository;


import com.example.zamowposilek.CreateSchool.School.School;
import org.springframework.data.repository.CrudRepository;



import java.util.Set;


public interface SchoolRepository extends CrudRepository<School,Long> {
    Set<School>findAll();


}
