package com.desafiocrud.desafiocrud2.dtos;

import com.desafiocrud.desafiocrud2.entities.Course;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;

public class CourseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Integer hours;
    private Integer amountClass;
    private Year year;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, String description, Integer hours, Integer amountClass, Year year) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.amountClass = amountClass;
        this.year = year;
    }

    public CourseDTO(Course entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.hours = entity.getHours();
        this.amountClass = entity.getAmountClass();
        this.year = entity.getYear();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getAmountClass() {
        return amountClass;
    }

    public void setAmountClass(Integer amountClass) {
        this.amountClass = amountClass;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
}
