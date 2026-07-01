package com.joe.School.services;

import com.joe.School.dtos.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    List<StudentDto> getAllStudent();

    StudentDto updateStudent(Long studentId, StudentDto studentDto);

    void deleteStudent(Long studentId);
}
