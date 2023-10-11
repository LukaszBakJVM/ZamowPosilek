package com.example.zamowposilek.CreateSchool.CreateClass.Student;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServices {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServices(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    StudentDto save(StudentDto studentDto){
        Student student = studentMapper.map(studentDto);
        Student save = studentRepository.save(student);
        return studentMapper.map(save);
    }
   List<StudentDto> findAllByClassName(String className){
      return   studentRepository.findAllBySchoolClassClassName(className)
                .stream()
                .map(studentMapper::map)
                .toList();
    }
    List<StudentDto>findAllBySchoolName(String schoolName){
        return studentRepository.findStudentsBySchoolName(schoolName)
                .stream()
                .map(studentMapper::map)
                .toList();
    }
}
