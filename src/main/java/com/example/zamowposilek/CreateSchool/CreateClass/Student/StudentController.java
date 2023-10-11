package com.example.zamowposilek.CreateSchool.CreateClass.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
    @PostMapping
    ResponseEntity<StudentDto>save(@RequestBody StudentDto studentDto){
        StudentDto save = studentServices.save(studentDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId())
                .toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @GetMapping("/{schoolName}")
    ResponseEntity<List<StudentDto>>findAllBySchoolName( @PathVariable String schoolName){
        return ResponseEntity.ok(studentServices.findAllBySchoolName(schoolName));
    }



}
