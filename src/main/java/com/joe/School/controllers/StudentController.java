package com.joe.School.controllers;

import com.joe.School.dtos.StudentDto;
import com.joe.School.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{studentId}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<StudentDto> studentDtos = studentService.getAllStudent();
        return new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<StudentDto> saveStudent(@RequestBody @Valid StudentDto studentDto) {
        studentService.createStudent(studentDto);
        return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
    }

    @PutMapping("modify/{studentId}")
    public ResponseEntity<StudentDto> modStudent(@PathVariable Long studentId, @RequestBody @Valid StudentDto studentDto) {
        studentService.updateStudent(studentId, studentDto);
        return ResponseEntity.ok().header("custom-header", "Joe").body(studentDto);
    }

    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<String> delStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }
}
