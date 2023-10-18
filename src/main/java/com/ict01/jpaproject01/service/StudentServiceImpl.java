package com.ict01.jpaproject01.service;

import com.ict01.jpaproject01.ResourceNotFoundExeption;
import com.ict01.jpaproject01.model.Student;
import com.ict01.jpaproject01.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// layer comfornent
public class StudentServiceImpl implements StudentService{
    // Override 메소드

    // 의존성 주입 해줘야해
    // Constructor Dependency Injection <- 최신버전 이거 써야함
    private final StudentRepository studentRepository;

    // Construct

    @Autowired  // 의존성 자동 주입
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository; // 레포지토리 초기화
    }

    @Override
    public List<Student> lists() {
        return studentRepository.findAll(); // ALL 정보 조회
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);    // student 정보 저장

    }

    @Override
    public Student getStudent(int id) throws ResourceNotFoundExeption {
        // throws로 예외 처리, id가 없을 시 RNFE 예외 발생
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeption(id));
    }
    // 여기서 Spring 2.과 3.의 차이가 남

    @Override
    public void deleteStudent(int id) throws ResourceNotFoundExeption {
        studentRepository.deleteById(id);
        // 학생 정보 삭제
    }
}
