package com.example.zamowposilek.CreateSchool.CreateClass;

import com.example.zamowposilek.SchoolException.ClassDuplicateException;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SchoolClassServices {

    private final SchoolClassRepository schoolClassRepository;
    private final SchoolClassMapper schoolClassMapper;

    public SchoolClassServices(SchoolClassRepository schoolClassRepository, SchoolClassMapper schoolClassMapper) {
        this.schoolClassRepository = schoolClassRepository;
        this.schoolClassMapper = schoolClassMapper;
    }
    SchoolClassDto save(SchoolClassDto dto){
        Optional<SchoolClass> byClassName = schoolClassRepository
                .findByClassNameAndSchoolName(dto.getClassName(), dto.getSchoolName());
        byClassName.ifPresent(p->{throw new ClassDuplicateException();
        });

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
    void deleteClass(int id){
        schoolClassRepository.deleteById(id);
    }
}
