package com.joe.School.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StudentDto (

    Long studentId,

    @NotEmpty(message = "The first name should not be null or empty!")
    String firstName,

    @NotEmpty(message = "The last name should not be null or empty!")
    String lastName,

    @NotEmpty(message = "The email should not be null or empty!")
    @Email(message = "Incorrect email address!")
    String email
) {}
