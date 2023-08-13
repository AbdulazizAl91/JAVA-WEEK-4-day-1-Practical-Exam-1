package com.example.schoolmanagement.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "id of teacher should not empty")
    @Positive
    private Integer id;
    @NotEmpty(message = "name of teacher should be not empty")
    @Size(min = 3,max = 23,message = "name of student should be between 3 and 23")
    private String name;
    @NotNull(message = "salary should be not empty")
    @Min(3000)
    private Integer salary;

}
