package com.example.zamowposilek.School;

import jakarta.persistence.*;

import java.util.ArrayList;
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
   private List<SchoolClass> schoolClass=new ArrayList<>();

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
        return id == school.id && Objects.equals(name, school.name) && Objects.equals(address, school.address) && Objects.equals(schoolClass, school.schoolClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, schoolClass);
    }
}
