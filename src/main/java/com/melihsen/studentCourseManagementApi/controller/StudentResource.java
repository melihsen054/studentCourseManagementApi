package com.melihsen.studentCourseManagementApi.controller;

import com.melihsen.studentCourseManagementApi.model.Student;
import com.melihsen.studentCourseManagementApi.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "student")
public class StudentResource {
    StudentRepository studentRepository;

    @GetMapping(path = "getAll")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> students = studentRepository.getAll();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
}
