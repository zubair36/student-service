package com.student.service.controller;

import com.student.service.dto.StudentRequestDTO;
import com.student.service.dto.StudentResponseDTO;
import com.student.service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/say-hello")
    public String helloWorld(){
        return studentService.helloWorld();
    }

    @PostMapping("/create-student")
    public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        //Option 1. First catch returned value and return from here
//        Student student1 = studentService.createStudent(student);
//        return student1;
        //Option 2: Directly return catched value.
        return studentService.createStudent(studentRequestDTO);
    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("/get-student-by-id/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/get-student-by-email/{email}")
    public StudentResponseDTO getStudentByEmail(@PathVariable String email){
        return studentService.getStudentByEmail(email);
    }

    @GetMapping("/get-student-by-email-and-name")
    public StudentResponseDTO getStudentByEmailAndName(@RequestParam String email, @RequestParam String name){
        return studentService.getStudentByEmailAndName(email, name);
    }

    @GetMapping("/get-student-by-name/{name}")
    public String getStudentByName(@PathVariable String name){
        return studentService.getStudentByName(name);
    }
}
