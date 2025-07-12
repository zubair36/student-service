package com.student.service.repo;

import com.student.service.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

//    StudentEntity findByEmail(String email);

        Optional<StudentEntity> findByName(String name);

    //SELECT * FROM STUDENT WHERE EMAIL = 'EMAIL';
    List<StudentEntity> findByEmail(String email);

    //SELECT * FROM STUDENT WHERE EMAIL = 'EMAIL' AND NAME = 'name';
    StudentEntity findByEmailAndName(String email, String name);
}
