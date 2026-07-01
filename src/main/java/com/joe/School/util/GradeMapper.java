package com.joe.School.util;

import com.joe.School.dtos.GradeDto;
import com.joe.School.models.Grade;

public class GradeMapper {

    public static Grade mapGradeDtoToGrade(GradeDto gradeDto) {
        Grade grade = Grade.builder()
                .gradeId(gradeDto.gradeId())
                .subject(gradeDto.subject())
                .value(gradeDto.value())
                .student(gradeDto.student())
                .build();
        return grade;
    }

    public static GradeDto mapGradeToGradeDto(Grade grade) {
        GradeDto gradeDto = GradeDto.builder()
                .gradeId(grade.getGradeId())
                .subject(grade.getSubject())
                .value(grade.getValue())
                .student(grade.getStudent())
                .build();
        return gradeDto;
    }
}
