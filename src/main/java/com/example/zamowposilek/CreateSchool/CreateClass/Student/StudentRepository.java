package com.example.zamowposilek.CreateSchool.CreateClass.Student;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student>findAllBySchoolClassClassName(String name);
    List<Student>findAllBySchoolClassId(long id);



    @Query("SELECT s FROM Student s " +
            "JOIN s.schoolClass sc " +
            "JOIN sc.school sch " +
            "WHERE sch.name = :schoolName")
    List<Student> findStudentsBySchoolName(@Param("schoolName") String schoolName);


}
