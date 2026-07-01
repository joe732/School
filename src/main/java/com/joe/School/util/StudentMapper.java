package com.joe.School.util;

import com.joe.School.dtos.StudentDto;
import com.joe.School.models.Student;

public class StudentMapper {

    public static Student mapStudentDtoToStudent(StudentDto studentDto) {
        Student student = Student.builder()
                .studentId(studentDto.studentId())
                .firstName(studentDto.firstName())
                .lastName(studentDto.lastName())
                .email(studentDto.email())
                .build();
        return student;
    }

    public static StudentDto mapStudentToStudentDto(Student student) {
        StudentDto studentDto = StudentDto.builder()
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
        return studentDto;
    }
}
