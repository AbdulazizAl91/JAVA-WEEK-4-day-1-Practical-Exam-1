package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Model.Student;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();

    public ArrayList<Student> getStudents(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
    public boolean updateStudent(Integer id,Student student){
        for (int i =0; i<students.size();i++){
            if (students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(Integer id){
        for (int i =0; i<students.size();i++){
            if (students.get(i).getId()==id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public Student searchByName(String  name){
        for (int i=0;i<students.size();i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){
                return students.get(i);
            }
        }

        return new Student(-1,"null",-1,"null");
    }
}
