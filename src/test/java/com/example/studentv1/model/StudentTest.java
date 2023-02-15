package com.example.studentv1.model;

import com.example.studentv1.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest {

  @Autowired
  StudentRepository studentRepository;

  @BeforeEach
  void setUp() {
    Student std = new Student();
    std.setName("Vibbe");
    std.setBornDate(LocalDate.now());
    std.setBornTime(LocalTime.now());
    studentRepository.save(std);
  }

  @Test
  void testViggo() {
    Optional<Student> std = studentRepository.findById(1);
    if (std.isPresent()) {
      Student s1 = std.get();
      assertEquals(1, s1.getId());
    } else {
      assertEquals("det gik skidt", "");

    }
  }

  @Test
  void testViggoOneLine() {
    assertEquals(1, studentRepository.findById(1).orElse(new Student()).getId());
  }

  @Test
  void testStudentByName() {
    assertEquals("Vibbe", studentRepository.findByName("Vibbe").orElse(new Student()).getName());
  }
}