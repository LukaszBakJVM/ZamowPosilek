package com.example.zamowposilek.School.Mapper;

import com.example.zamowposilek.School.Address;
import com.example.zamowposilek.School.School;
import com.example.zamowposilek.School.SchoolDto;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
 School map(SchoolDto dto){
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
}
