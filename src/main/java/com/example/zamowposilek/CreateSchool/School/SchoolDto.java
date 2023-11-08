package com.example.zamowposilek.CreateSchool.School;

import java.util.Comparator;

public class SchoolDto implements Comparator<SchoolDto> {
    private long schoolId;
    private String schoolName;

    private String city;
    private String zipCode;
    private String street;
    private String houseNumber;

    public long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public int compare(SchoolDto o1, SchoolDto o2) {
        return o1.schoolName.compareTo(o2.schoolName);
    }
}
