package com.mercadolivre.sorteio.repositories;

import com.mercadolivre.sorteio.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
