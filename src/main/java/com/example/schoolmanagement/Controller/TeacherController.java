package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.ApiRespose.ApiResponse;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity geTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());

    }
    @PostMapping("/add")
    public ResponseEntity addteacher(@RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdate = teacherService.updateTeacher(id,teacher);
        if (isUpdate){
            return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
        }
        return ResponseEntity.status(400).body("teacher not updated");

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

            boolean isDelete = teacherService.deleteTeacher(id);
            if (isDelete){
                return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
            }
            return ResponseEntity.status(400).body(new ApiResponse("student not founded"));

    }
    @GetMapping("search-by-id/{id}")
    public ResponseEntity searchById(@PathVariable Integer id){
        if (teacherService.searchById(id).getId()==-1){
            return ResponseEntity.status(400).body("teacher not founded");
        }
        return ResponseEntity.status(200).body(teacherService.searchById(id));
    }
}
