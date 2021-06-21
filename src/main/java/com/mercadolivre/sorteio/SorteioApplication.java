package com.mercadolivre.sorteio;

import com.github.javafaker.Faker;
import com.mercadolivre.sorteio.entities.Student;
import com.mercadolivre.sorteio.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class SorteioApplication implements CommandLineRunner{

	final
	StudentRepository studentRepository;

	public SorteioApplication(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SorteioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		studentRepository.deleteAll();

		for(int i = 0; i < 30; i++){
			Faker faker = new Faker(new Locale("pt-BR"));
			Student student = new Student();
			student.setName(faker.name().fullName());

			studentRepository.save(student);
		}
	}
}
