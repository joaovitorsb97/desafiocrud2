package com.desafiocrud.desafiocrud2.services;

import com.desafiocrud.desafiocrud2.dtos.StudentDTO;
import com.desafiocrud.desafiocrud2.entities.Course;
import com.desafiocrud.desafiocrud2.entities.Student;
import com.desafiocrud.desafiocrud2.repositories.CourseRepository;
import com.desafiocrud.desafiocrud2.repositories.StudentRepository;
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
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Page<StudentDTO> findAllPaged(PageRequest pageRequest){
        Page<Student> page = studentRepository.findAll(pageRequest);
        return page.map(x -> new StudentDTO(x, x.getFavoriteCourse()));
    }

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        Optional<Student> obj = studentRepository.findById(id);
        return obj.stream().map(x -> new StudentDTO(x, x.getFavoriteCourse())).findFirst().orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public StudentDTO insert(StudentDTO studentDTO){
        Student student = new Student();
        copyDTOtoEntity(studentDTO, student);
        return new StudentDTO(studentRepository.save(student));
    }

    @Transactional
    public StudentDTO update(Long id, StudentDTO studentDTO){
        try{
            Student student = studentRepository.getReferenceById(id);
            copyDTOtoEntity(studentDTO, student);
            return new StudentDTO(studentRepository.save(student));
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Id " + id + " not found");
        }
    }

    @Transactional
    public void delete(Long id){
        try{
            studentRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id " + " not found");
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public void copyDTOtoEntity(StudentDTO studentDTO, Student entity){
        entity.setName(studentDTO.getName());
        entity.setHeight(studentDTO.getHeight());
        entity.setWeight(studentDTO.getWeight());
        entity.setNationality(studentDTO.getNationality());
        entity.setSex(studentDTO.getSex());

        Course course = courseRepository.getReferenceById(studentDTO.getCourseDTO().getId());
        entity.setFavoriteCourse(course);
    }
}
