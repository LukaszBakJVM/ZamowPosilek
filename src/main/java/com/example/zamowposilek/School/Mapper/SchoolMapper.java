package com.example.zamowposilek.School.Mapper;

import com.example.zamowposilek.School.Address;
import com.example.zamowposilek.School.School;
import com.example.zamowposilek.School.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
 public School map(SchoolDto dto){
    School school =new School();
    Address address =new Address();
    school.setId(dto.getSchoolId());
    school.setName(dto.getSchoolName());
    address.setId(dto.getAddressId());
    address.setCity(dto.getCity());
    address.setZipCode(dto.getZipCode());
    address.setStreet(dto.getStreet());
    address.setHouseNumber(dto.getHouseNumber());
    school.setAddress(address);
    return school;
}
public SchoolDto map(School school){
    SchoolDto dto =new SchoolDto();
    dto.setSchoolId(school.getId());
    dto.setSchoolName(school.getName());
    dto.setAddressId(school.getAddress().getId());
    dto.setCity(school.getAddress().getCity());
    dto.setZipCode(school.getAddress().getZipCode());
    dto.setStreet(school.getAddress().getStreet());
    dto.setHouseNumber(school.getAddress().getHouseNumber());
    return dto;
}
}
