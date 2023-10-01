package com.example.zamowposilek.CreateSchool.CreateClass.Student;

import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClass;
import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClassDto;
import com.example.zamowposilek.CreateSchool.Repository.SchoolRepository;
import com.example.zamowposilek.CreateSchool.School.School;

import com.example.zamowposilek.SchoolException.SchoolNotfoundException;
import org.springframework.stereotype.Service;

@Service
public class SchoolClassMapper {
    public SchoolClassMapper(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    private final SchoolRepository schoolRepository;
    SchoolClass map(SchoolClassDto dto){
        SchoolClass schoolClass =new SchoolClass();
        schoolClass.setId(dto.getClassId());
        schoolClass.setClassName(dto.getClassName());
        School school = schoolRepository.findById(dto.getSchoolId()).orElseThrow(SchoolNotfoundException::new);
        schoolClass.setSchool(school);
        return schoolClass;
    }
    SchoolClassDto map(SchoolClass schoolClass){
        SchoolClassDto dto=new SchoolClassDto();
        dto.setClassId(schoolClass.getId());
        dto.setClassName(schoolClass.getClassName());
        dto.setSchoolId(schoolClass.getSchool().getId());
        return dto;
    }
}
