package com.example.zamowposilek.School;

import com.example.zamowposilek.School.Mapper.SchoolMapper;
import com.example.zamowposilek.School.Repository.AddressRepository;
import com.example.zamowposilek.School.Repository.SchoolRepository;
import com.example.zamowposilek.SchoolException.SchoolNotfoundException;
import org.springframework.stereotype.Service;

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
    public SchoolDto save(SchoolDto dto){
        School map = schoolMapper.map(dto);
        addressRepository.save(map.getAddress());
        School save = schoolRepository.save(map);
        return schoolMapper.map(save);
    }
    SchoolDto findSchoolById(long id){
        School school = schoolRepository.findById(id).orElseThrow(SchoolNotfoundException::new);
        return schoolMapper.map(school);
    }
}
