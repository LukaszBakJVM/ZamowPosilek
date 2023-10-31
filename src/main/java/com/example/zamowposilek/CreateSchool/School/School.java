package com.example.zamowposilek.CreateSchool.School;

import com.example.zamowposilek.CreateSchool.School.Address.Address;
import com.example.zamowposilek.CreateSchool.CreateClass.SchoolClass;
import com.example.zamowposilek.Restaurant.Restaurant;
import jakarta.persistence.*;



import java.util.List;
import java.util.Objects;

@Entity
public class School implements Comparable<School>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    public String name;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "school")

    private List<SchoolClass> schoolClass;

    @ManyToOne
    private Restaurant restaurant;

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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) && Objects.equals(address, school.address);
    }

    @Override
    public String toString() {
        return name ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public int compareTo(School o) {
        return name.compareTo(o.name);
    }
}
