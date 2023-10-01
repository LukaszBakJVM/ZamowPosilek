package com.example.zamowposilek.CreateSchool.CreateClass;

import com.example.zamowposilek.CreateSchool.Repository.SchoolClassRepository;
import com.example.zamowposilek.CreateSchool.Repository.SchoolRepository;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SchoolClassServices {
    private final SchoolRepository schoolRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassMapper schoolClassMapper;

    public SchoolClassServices(SchoolRepository schoolRepository, SchoolClassRepository schoolClassRepository
            , SchoolClassMapper schoolClassMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.schoolClassMapper = schoolClassMapper;
    }
    SchoolClassDto save(SchoolClassDto dto){
        SchoolClass map = schoolClassMapper.map(dto);
        SchoolClass save = schoolClassRepository.save(map);
        return schoolClassMapper.map(save);
    }
    Set<SchoolClassDto> findAll(){
      return schoolClassRepository.findAll()
               .stream()
               .map(schoolClassMapper::map)
              .collect(Collectors.toSet());
    }
    Set<SchoolClassDto>findClassByName(String name){
      return   schoolClassRepository.findByClassNameContainingIgnoreCase(name)
              .stream().map(schoolClassMapper::map)
              .collect(Collectors.toSet());
    }
}
