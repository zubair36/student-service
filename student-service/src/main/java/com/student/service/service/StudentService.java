package com.student.service.service;

import com.student.service.dto.StudentRequestDTO;
import com.student.service.dto.StudentResponseDTO;
import com.student.service.entity.StudentEntity;
import com.student.service.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public String deleteStudent(Long id){
        studentRepository.deleteById(id);
        return "Student Deleted Successfully!!";
    }

    public StudentResponseDTO getStudentById(Long id){
        StudentEntity studentEntity = studentRepository.findById(id).get();
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setStudentId(studentEntity.getId());
        responseDTO.setRollNumber(studentEntity.getRollNumber());
        return responseDTO;
    }

    public StudentResponseDTO getStudentByEmail(String email){
        List<StudentEntity> list = studentRepository.findByEmail(email);
        StudentResponseDTO responseDTO = new StudentResponseDTO();
//        responseDTO.setStudentId(studentEntity.getId());
//        responseDTO.setRollNumber(studentEntity.getRollNumber());
        return null;
    }

    public StudentResponseDTO getStudentByEmailAndName(String email, String name){
        StudentEntity studentEntity = studentRepository.findByEmailAndName(email, name);
        StudentResponseDTO responseDTO = new StudentResponseDTO();
        responseDTO.setStudentId(studentEntity.getId());
        responseDTO.setRollNumber(studentEntity.getRollNumber());
        return responseDTO;
    }

    public String getStudentByName(String name){
        Optional<StudentEntity> studentEntity = studentRepository.findByName(name);
//        boolean flag = studentEntity.isPresent();
        if(studentEntity.isPresent()){
            return "Student Exist";
        }
        return "Student Doesn't exist!!";
    }
}
