package com.joe.School.dtos;

import com.joe.School.models.Student;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record GradeDto (
        Long gradeId,
        @NotNull(message = "The Student should not be empty or null!")
        Student student,
        @NotNull(message = "The subject must be given!")
        String subject,
        @NotNull(message = "Please give the grade value!")
        Integer value
)
{
}
