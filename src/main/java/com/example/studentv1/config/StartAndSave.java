package com.example.studentv1.config;

import com.example.studentv1.model.Student;
import com.example.studentv1.model.Teacher;
import com.example.studentv1.repositories.StudentRepository;
import com.example.studentv1.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class StartAndSave implements CommandLineRunner {

  StudentRepository studentRepository;
  @Autowired
  TeacherRepository teacherRepository;

  public StartAndSave(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Student std1 = new Student();
    std1.setName("Anne");
    std1.setBornDate(LocalDate.now().minusYears(15));
    std1.setBornTime(LocalTime.now());
    studentRepository.save(std1);
    System.out.println("Saved Student: " + std1.getName());

    Student std2 = new Student();
    std2.setName("Viggo");
    std2.setBornDate(std1.getBornDate().plusYears(10));
    studentRepository.save(std2);
    System.out.println("Saved Student: " + std2.getName());

    Teacher t1 = new Teacher();
    t1.setId(1);
    t1.setName("Victor");
    teacherRepository.save(t1);
    System.out.println("Saved Teacher: " + t1.getName());
    t1.setName("Viktor");
    teacherRepository.save(t1);
    System.out.println("Saved Teacher: " + t1.getName());
  }

}
