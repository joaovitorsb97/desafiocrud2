package com.desafiocrud.desafiocrud2.controllers;

import com.desafiocrud.desafiocrud2.dtos.CourseDTO;
import com.desafiocrud.desafiocrud2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> findAll(@RequestParam(value = "page", defaultValue = "3") Integer page,
                                                   @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                   @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                   @RequestParam(value = "orderBy", defaultValue = "name") String orderBy){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAllPaged(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> insert(@RequestBody CourseDTO courseDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.insert(courseDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO courseDTO){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.update(id, courseDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> delete(@PathVariable Long id){
        courseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
