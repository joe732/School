package com.joe.School.services;

import com.joe.School.dtos.StudentDto;
import com.joe.School.exception.ResourceNotFoundException;
import com.joe.School.models.Student;
import com.joe.School.repositories.StudentRepository;
import com.joe.School.util.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapStudentDtoToStudent(studentDto);
        studentRepository.save(student);
        return StudentMapper.mapStudentToStudentDto(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", studentId.toString())
        );
        StudentDto studentDto = StudentMapper.mapStudentToStudentDto(student);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(StudentMapper::mapStudentToStudentDto).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(studentDto.firstName());
            student.setLastName(studentDto.lastName());
            student.setEmail(studentDto.email());
            studentRepository.save(student);
            return StudentMapper.mapStudentToStudentDto(student);
        } else {
            throw new ResourceNotFoundException("Student", "id", studentId.toString());
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            studentRepository.deleteById(studentId);
        } else {
            throw new ResourceNotFoundException("Student", "id", studentId.toString());
        }

    }
}
