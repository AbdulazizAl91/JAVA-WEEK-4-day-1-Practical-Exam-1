package com.example.schoolmanagement.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotNull(message = "id of student should not empty")
    @Positive
    private Integer id;
    @NotEmpty(message = "name of student should be not empty")
    @Size(min = 3,max = 23,message = "name of student should be between 3 and 23")
    private String name;
    @NotNull(message = "age should be not null")
    @Positive
    private Integer age;
    @NotEmpty(message = "major should be not empty")
    @Size(min = 2,max = 30,message = "major should be between 2 and 30")
    private String major;
}
