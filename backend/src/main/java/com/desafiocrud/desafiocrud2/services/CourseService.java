package com.desafiocrud.desafiocrud2.services;

import com.desafiocrud.desafiocrud2.dtos.CourseDTO;
import com.desafiocrud.desafiocrud2.entities.Course;
import com.desafiocrud.desafiocrud2.repositories.CourseRepository;
import com.desafiocrud.desafiocrud2.services.exceptions.DatabaseException;
import com.desafiocrud.desafiocrud2.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAllPaged(PageRequest pageRequest){
        Page<Course> page = courseRepository.findAll(pageRequest);
        return page.map(CourseDTO::new);
    }

    @Transactional(readOnly = true)
    public CourseDTO findById(Long id){
        Optional<Course> obj = courseRepository.findById(id);
        return obj.stream().map(CourseDTO::new).findFirst().orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public CourseDTO insert(CourseDTO courseDTO){
        Course course = new Course();
        copyDTOToEntity(course, courseDTO);
        return new CourseDTO(courseRepository.save(course));
    }

    @Transactional
    public CourseDTO update(Long id, CourseDTO courseDTO){
        try{
            Course course = courseRepository.getReferenceById(id);
            copyDTOToEntity(course, courseDTO);
            return new CourseDTO(courseRepository.save(course));
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id: " + id + " not found");
        }
    }

    @Transactional
    public void deleteById(Long id){
        try{
            courseRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id: " + id + " not found");
        }
    }

    public void copyDTOToEntity(Course entity, CourseDTO courseDTO){
        entity.setName(courseDTO.getName());
        entity.setDescription(courseDTO.getDescription());
        entity.setHours(courseDTO.getHours());
        entity.setAmountClass(courseDTO.getAmountClass());
        entity.setYear(courseDTO.getYear());
    }


}
