package com.example.zamowposilek.CreateSchool.CreateClass.Student;

import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClass;
import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClassRepository;
import com.example.zamowposilek.SchoolException.ClassNotfoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    private final SchoolClassRepository repository;
    public StudentMapper(SchoolClassRepository repository) {
        this.repository = repository;
    }





    Student map(StudentDto dto){
        Student student=new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        SchoolClass schoolClass = repository.findByClassNameAndSchoolName(dto.getClassName(), dto.getSchoolName())
                .orElseThrow(ClassNotfoundException::new);
        student.setSchoolClass(schoolClass);
        return student;
    }
    StudentDto map(Student student){
        StudentDto dto=new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setSchoolName(student.getSchoolClass().getSchool().getName());
        dto.setClassName(student.getSchoolClass().getClassName());
        return dto;
    }
}
