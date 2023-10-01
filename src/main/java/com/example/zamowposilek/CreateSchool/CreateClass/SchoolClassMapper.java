package com.example.zamowposilek.CreateSchool.CreateClass;


import com.example.zamowposilek.CreateSchool.Repository.SchoolRepository;
import com.example.zamowposilek.CreateSchool.School.School;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolClassMapper {
    private final SchoolRepository schoolRepository;
    public SchoolClassMapper(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    SchoolClass map(SchoolClassDto dto){
        SchoolClass schoolClass =new SchoolClass();
        schoolClass.setId(dto.getClassId());
        schoolClass.setClassName(dto.getClassName());

        Optional<School> byName = schoolRepository.findByName(dto.getSchoolName());
        byName.ifPresent(schoolClass::setSchool);

        return schoolClass;
    }
    SchoolClassDto map(SchoolClass schoolClass){
        SchoolClassDto dto=new SchoolClassDto();
        dto.setClassId(schoolClass.getId());
        dto.setClassName(schoolClass.getClassName());
        dto.setSchoolName(schoolClass.getSchool().getName());
        return dto;
    }
}
