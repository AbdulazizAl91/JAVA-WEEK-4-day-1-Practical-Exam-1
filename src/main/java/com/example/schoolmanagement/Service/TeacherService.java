package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers=new ArrayList<>();
    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }
    public void addTeTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public boolean updateTeacher(Integer id,Teacher teacher){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }
    public boolean deleteTeacher(Integer id){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public Teacher searchById(Integer id){
        for (int i=0;i<teachers.size();i++){
            if (teachers.get(i).getId()==id){
                return teachers.get(i);
            }
        }
        return new Teacher(-1,"null",-1);
    }
}
