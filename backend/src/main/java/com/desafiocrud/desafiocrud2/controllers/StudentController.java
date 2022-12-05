package com.desafiocrud.desafiocrud2.controllers;


import com.desafiocrud.desafiocrud2.dtos.StudentDTO;
import com.desafiocrud.desafiocrud2.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                    @RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
                                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAllPaged(pageRequest));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.insert(studentDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> update(@RequestBody StudentDTO studentDTO, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(id, studentDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
