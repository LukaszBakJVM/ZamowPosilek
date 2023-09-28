package com.example.zamowposilek.CreateSchool.School;

import com.example.zamowposilek.CreateSchool.School.Address.Address;
import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClass;
import jakarta.persistence.*;


import java.util.List;
import java.util.Objects;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToOne
    private Address address;
    @OneToMany (mappedBy ="school" )
   private List<SchoolClass> schoolClass;

    public School() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<SchoolClass> getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(List<SchoolClass> schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) && Objects.equals(address, school.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
