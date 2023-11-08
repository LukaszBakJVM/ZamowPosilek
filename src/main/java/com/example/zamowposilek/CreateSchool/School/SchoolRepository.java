package com.example.zamowposilek.CreateSchool.School;





import org.springframework.data.repository.CrudRepository;



import java.util.Optional;
import java.util.Set;



public interface SchoolRepository extends CrudRepository<School,Long> {
   Set<School>findAll();
   Optional<School> findByName(String name);

}

