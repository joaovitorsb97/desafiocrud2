package com.desafiocrud.desafiocrud2.entities;

import com.desafiocrud.desafiocrud2.entities.enums.Sex;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_student")
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double height;
    private Double weight;
    private String nationality;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToOne
    @JoinColumn(name = "favorite_course")
    private Course favoriteCourse;

    public Student() {
    }

    public Student(Long id, String name, Double height, Double weight, String nationality, Sex sex) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.nationality = nationality;
        this.sex = sex;
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

    public Course getFavoriteCourse() {
        return favoriteCourse;
    }

    public void setFavoriteCourse(Course favoriteCourse) {
        this.favoriteCourse = favoriteCourse;
    }
}
