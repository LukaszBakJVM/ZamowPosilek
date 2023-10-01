package com.example.zamowposilek.CreateSchool.CreateClass;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/school/class")
public class SchoolClassController {
    private final SchoolClassServices schoolClassServices;

    public SchoolClassController(SchoolClassServices schoolClassServices) {
        this.schoolClassServices = schoolClassServices;
    }
    @PostMapping
    ResponseEntity<SchoolClassDto>save(@RequestBody SchoolClassDto dto){
        SchoolClassDto save = schoolClassServices.save(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getClassId())
                .toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @GetMapping("")
    ResponseEntity<Set<SchoolClassDto>>findByName(@RequestParam(required = false)String name) {
        if (name != null) {
            return ResponseEntity.ok(schoolClassServices.findClassByName(name));
        } else {
            return ResponseEntity.ok(schoolClassServices.findAll());
        }
    }
        @DeleteMapping("/{id}")
                ResponseEntity<?>deleteClass(@PathVariable int id){
            schoolClassServices.deleteClass(id);
            return ResponseEntity.noContent().build();


    }
}
