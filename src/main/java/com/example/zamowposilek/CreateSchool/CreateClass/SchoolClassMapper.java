package com.example.zamowposilek.CreateSchool.CreateClass;


import com.example.zamowposilek.CreateSchool.School.SchoolRepository;
import com.example.zamowposilek.CreateSchool.School.School;


import com.example.zamowposilek.Exception.SchoolException.SchoolNotfoundException;
import org.springframework.stereotype.Service;



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
        School school = schoolRepository.findByName(dto.getSchoolName()).orElseThrow(SchoolNotfoundException::new);
        schoolClass.setSchool(school);

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
