package com.example.zamowposilek.CreateSchool.CreateClass;

import com.example.zamowposilek.CreateSchool.CreateClass.Student.Student;
import com.example.zamowposilek.CreateSchool.School.School;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String className;
    @ManyToOne
    private School school;

    @OneToMany(mappedBy = "schoolClass")
    private List<Student>students;

    public SchoolClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolClass that = (SchoolClass) o;
        return id == that.id && Objects.equals(className, that.className) && Objects.equals(school, that.school) && Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className, school, students);
    }
}
