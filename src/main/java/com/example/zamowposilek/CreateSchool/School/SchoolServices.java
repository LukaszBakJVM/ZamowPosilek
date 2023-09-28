package com.example.zamowposilek.CreateSchool.School;

import com.example.zamowposilek.CreateSchool.Repository.AddressRepository;
import com.example.zamowposilek.CreateSchool.Repository.SchoolRepository;
import com.example.zamowposilek.SchoolException.SchoolDuplicateException;
import com.example.zamowposilek.SchoolException.SchoolNotfoundException;
import org.springframework.stereotype.Service;


import java.util.Set;


@Service
public class SchoolServices {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    private final AddressRepository addressRepository;

    public SchoolServices(SchoolRepository schoolRepository, SchoolMapper schoolMapper, AddressRepository addressRepository) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
        this.addressRepository = addressRepository;
    }
     SchoolDto save(SchoolDto dto) {
         School map = schoolMapper.map(dto);
         Set<School> all = schoolRepository.findAll();
         if (all.contains(map)) {
         throw new SchoolDuplicateException();
     }
         addressRepository.save(map.getAddress());
        School save = schoolRepository.save(map);
        return schoolMapper.map(save);
    }
    SchoolDto findSchoolById(long id){
        School school = schoolRepository.findById(id).orElseThrow(SchoolNotfoundException::new);
        return schoolMapper.map(school);
    }
}
