package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.ApiRespose.ApiResponse;
import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentModel {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudents());

    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student,Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@RequestBody @Valid Student student,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = studentService.updateStudent(id,student);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("student updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("student not updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        boolean isDelete = studentService.deleteStudent(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("student not founded"));

    }
    @GetMapping("search-by-name/{name}")
    public ResponseEntity searchById(@PathVariable String name){
        if (studentService.searchByName(name).getId()==-1){
            return ResponseEntity.status(400).body("Student not founded");
        }
        return ResponseEntity.status(200).body(studentService.searchByName(name));

    }

}
