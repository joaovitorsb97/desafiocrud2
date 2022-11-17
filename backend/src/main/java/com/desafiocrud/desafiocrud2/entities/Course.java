package com.desafiocrud.desafiocrud2.entities;

import com.desafiocrud.desafiocrud2.converters.YearAttributeConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

@Entity
@Table(name = "tb_course")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer hours;
    private Integer amountClass;
    private Year year;

    public Course() {
    }

    public Course(Long id, String name, String description, Integer hours, Integer amountClass, Year year) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.amountClass = amountClass;
        this.year = year;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
