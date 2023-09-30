package com.example.zamowposilek.CreateSchool.School;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolServices schoolServices;

    public SchoolController(SchoolServices schoolServices) {
        this.schoolServices = schoolServices;
    }
    @GetMapping("/{id}")
    ResponseEntity<SchoolDto>findById(@PathVariable long id){
        return ResponseEntity.ok(schoolServices.findSchoolById(id));
    }
    @PostMapping
    ResponseEntity<SchoolDto>save(@RequestBody SchoolDto dto){
        SchoolDto save = schoolServices.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(save.getSchoolId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?>deleteById(@PathVariable long id){
        schoolServices.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
