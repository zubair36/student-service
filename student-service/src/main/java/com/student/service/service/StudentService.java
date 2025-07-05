package com.student.service.service;

import com.student.service.dto.StudentRequestDTO;
import com.student.service.dto.StudentResponseDTO;
import com.student.service.entity.StudentEntity;
import com.student.service.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String helloWorld(){
        return "Hello World";
    }

    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO){
        StudentEntity studentEntity = new StudentEntity();
//        String name = studentRequestDTO.getName();
//        studentEntity.setName(name);
        studentEntity.setName(studentRequestDTO.getName());
        studentEntity.setRollNumber(studentRequestDTO.getRollNumber());
        studentEntity.setEmail(studentRequestDTO.getEmail());
        StudentEntity responseEntity = studentRepository.save(studentEntity);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
//        Long studentId = responseEntity.getId();
//        studentResponseDTO.setStudentId(studentId);
        studentResponseDTO.setStudentId(responseEntity.getId());
        studentResponseDTO.setRollNumber(responseEntity.getRollNumber());

        return studentResponseDTO;
    }
}
