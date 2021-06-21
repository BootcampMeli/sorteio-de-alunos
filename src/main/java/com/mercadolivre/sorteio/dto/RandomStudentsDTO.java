package com.mercadolivre.sorteio.dto;

import com.mercadolivre.sorteio.entities.Student;
import lombok.Data;

import java.util.List;

@Data
public class RandomStudentsDTO {
    private List<Student> listOfStudents;
}
