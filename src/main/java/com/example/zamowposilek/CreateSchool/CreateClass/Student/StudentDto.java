package com.example.zamowposilek.CreateSchool.CreateClass.Student;


import java.util.Objects;

public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
   private String schoolName;

    private String className;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto dto = (StudentDto) o;
        return Objects.equals(firstName, dto.firstName) && Objects.equals(lastName, dto.lastName) && Objects.equals(schoolName, dto.schoolName) && Objects.equals(className, dto.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, schoolName, className);
    }
}
