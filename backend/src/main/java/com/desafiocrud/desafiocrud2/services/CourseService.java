package com.desafiocrud.desafiocrud2.services;

import com.desafiocrud.desafiocrud2.dtos.CourseDTO;
import com.desafiocrud.desafiocrud2.entities.Course;
import com.desafiocrud.desafiocrud2.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAllPaged(PageRequest pageRequest){
        Page<Course> page = courseRepository.findAll(pageRequest);
        return page.map(CourseDTO::new);
    }


}
