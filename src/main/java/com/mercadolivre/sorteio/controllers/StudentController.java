package com.mercadolivre.sorteio.controllers;

import com.mercadolivre.sorteio.dto.RandomStudentsDTO;
import com.mercadolivre.sorteio.entities.Student;
import com.mercadolivre.sorteio.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<RandomStudentsDTO> getTenRandomStudents(){

        RandomStudentsDTO studentsDTO = new RandomStudentsDTO();
        studentsDTO.setListOfStudents(studentService.getStudents());

        return new ResponseEntity<>(studentsDTO, HttpStatus.OK);
    }

}
