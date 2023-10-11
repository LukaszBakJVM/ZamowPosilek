package com.example.zamowposilek.CreateSchool.School;


import com.example.zamowposilek.CreateSchool.School.Address.AddressRepository;
import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClassRepository;
import com.example.zamowposilek.CreateSchool.School.Address.Address;
import com.example.zamowposilek.SchoolException.SchoolDuplicateException;
import com.example.zamowposilek.SchoolException.SchoolNotfoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class SchoolServices {
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;
    private final AddressRepository addressRepository;
    private final SchoolClassRepository schoolClassRepository;

    public SchoolServices(SchoolRepository schoolRepository, SchoolMapper schoolMapper,
                          AddressRepository addressRepository, SchoolClassRepository schoolClassRepository) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
        this.addressRepository = addressRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    SchoolDto save(SchoolDto dto) {
        School map = schoolMapper.map(dto);
        Set<School> all = schoolRepository.findAll();
        if (all.contains(map)) {
            throw new SchoolDuplicateException();
        }
        Address address = addressRepository.save(map.getAddress());
        address.setSchool(map);
        School save = schoolRepository.save(map);


        return schoolMapper.map(save);
    }

    SchoolDto findSchoolById(long id) {
        School school = schoolRepository.findById(id).orElseThrow(SchoolNotfoundException::new);
        return schoolMapper.map(school);
    }

    void delete(long id) {
        School school = schoolRepository.findById(id).orElseThrow();
        schoolClassRepository.deleteAll(school.getSchoolClass());
        addressRepository.delete(school.getAddress());
        schoolRepository.delete(school);
    }
    Set<SchoolDto>findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::map)
                .collect(Collectors.toSet());
    }

    List<String> findAllSchool() {
      return   schoolRepository.findAll()
                .stream()
                .map(School::getName)
                .toList();


    }

}
