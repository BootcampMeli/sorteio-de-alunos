package com.mercadolivre.sorteio.service;

import com.mercadolivre.sorteio.entities.Student;
import com.mercadolivre.sorteio.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService{

    private final
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
         List<Student> list = studentRepository.findAll();
         return getRandomElement(list, 10);
    }

    public List<Student> getRandomElement(List<Student> list, int totalItems)
    {
        Random rand = new Random();

        List<Student> newList = new ArrayList<>();
        for (int i = 0; i < totalItems; i++) {

            int randomIndex = rand.nextInt(list.size());
            newList.add(list.get(randomIndex));
            list.remove(randomIndex);
        }
        return newList;
    }
}
