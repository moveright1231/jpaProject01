package com.ict01.jpaproject01.service;

import com.ict01.jpaproject01.ResourceNotFoundExeption;
import com.ict01.jpaproject01.model.Student;

import java.util.List;

public interface StudentService {

    //(1) 전체 학생 조회 (Read)
    public List<Student> lists(); //lists 메서드 이름은 네이밍 룰 -> list, findALL으로 쓸 수 있음

    //(2) 학생 등록 (Create)
    // 학생 정보를 DB에 저장하는 메서드
    public void saveStudent(Student student);

    //(3) 학생정보 수정 (Update)
    // 주어진 ID에 = 학생의 정보를 조회하는 메소드
    public Student getStudent(int id) throws ResourceNotFoundExeption;  // 정보가 없을 시 RNFE 예외 발생
    // throws로 예외처리를 반드시 해줘야함

    //(4) 학생정보 삭제 (Delete)
    public void deleteStudent(int id) throws ResourceNotFoundExeption;  // 정보가 없을 시 RNFE 예외 발생

}
