package com.desafiocrud.desafiocrud2.dtos;

import com.desafiocrud.desafiocrud2.entities.Course;
import com.desafiocrud.desafiocrud2.entities.Student;
import com.desafiocrud.desafiocrud2.entities.enums.Sex;

import java.io.Serial;
import java.io.Serializable;

public class StudentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double height;
    private Double weight;
    private String nationality;
    private Sex sex;

    private CourseDTO courseDTO;


    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, Double height, Double weight, String nationality, Sex sex) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.nationality = nationality;
        this.sex = sex;
    }

    public StudentDTO(Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.height = entity.getHeight();
        this.weight = entity.getWeight();
        this.nationality = entity.getNationality();
        this.sex = entity.getSex();
    }

    public StudentDTO(Student entity, Course course){
        this(entity);
        this.courseDTO = new CourseDTO(course);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }
}
