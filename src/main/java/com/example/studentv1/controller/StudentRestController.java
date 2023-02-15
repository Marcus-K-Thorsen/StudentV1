package com.example.studentv1.controller;

import com.example.studentv1.model.Student;
import com.example.studentv1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestController {

  @Autowired
  StudentRepository studentRepository;

  @GetMapping("/students")
  public List<Student> students() {
    return studentRepository.findAll();
  }

  @GetMapping("/teststudents")
  public List<Student> testStudents() {
    String autoNavn = "Navn: " + (studentRepository.findAll().size() + 1);
    Student std = new Student();
    std.setName(autoNavn);
    std.setBornDate(LocalDate.now().minusYears(15));
    std.setBornTime(LocalTime.now());
    studentRepository.save(std);
    System.out.println("Saved Student: " + std.getName());
    return studentRepository.findAll();
  }

}
