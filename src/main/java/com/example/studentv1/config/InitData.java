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
public class InitData implements CommandLineRunner {

  @Autowired
  StudentRepository studentRepository;
  @Autowired
  TeacherRepository teacherRepository;

  @Override
  public void run(String... args) throws Exception {
    Student s1 = new Student();
    s1.setId(1);
    s1.setName("Valdemar");
    s1.setBornDate(LocalDate.now().minusYears(15));
    s1.setBornTime(LocalTime.now());
    studentRepository.save(s1);
    System.out.println("Saved Student: " + s1.getName());
    s1.setId(2);
    s1.setName("Viggo");
    s1.setBornDate(s1.getBornDate().plusYears(10));
    studentRepository.save(s1);
    System.out.println("Saved Student: " + s1.getName());

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
