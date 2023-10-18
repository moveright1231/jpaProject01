package com.ict01.jpaproject01.controller;

import com.ict01.jpaproject01.ResourceNotFoundExeption;
import com.ict01.jpaproject01.model.Student;
import com.ict01.jpaproject01.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller // Spring MVC 컨트롤러로 선언
@RequestMapping("/student") // URL 설정옴남
@RequiredArgsConstructor    // 필수 생성자 자동 생성
public class StudentController {

    private final StudentService studentService;    // studentService 객체

    //http://localhost:8080/student/lists
    // [1] 전체 학생 정보 조회
    @GetMapping("/lists")   // GET 요청을 처리하는 메서드
    public String lists(Model model){

        // (1) 모든 학생들을 가져온다.
        List<Student> students = studentService.lists();    // 전체 학생 정보 조회

        // (2) 가져온 Student Colleciotn을 view로 전달한다.
        model.addAttribute("students",students);    // 모델에 학생 리스트 추가

        //http://localhost:8080/student/lists/WEP-INF/views/listStudents.jsp
        // (3) WEB-INF/views/listStudents.jsp
        return "listStudent";
        // 중요한건 return, 탬플릿을 이해해야함(확장을 위해서)
    }
    // [1-2]
    // @ResponseBody
    // public List<Student> lists() throws ClassNotFoundException,  SQLException {
    //
    // List<Student> students = studentService.lists();
    // return students;

    // [2] 학생 정보 등록 (Create)
    // [2-1] 학생 정보 등록 Form
    @GetMapping("/showForm") // URI
    public String showFormAdd(Model model){
        Student student = new Student();    // 객체 생성
        model.addAttribute("student",student);  // 객체 추가
        // WEB-INF/views/studentForm.jsp
        return "studentForm"; // 반환
    }


    // [2-2] 학생 정보 Action
    @PostMapping("/saveStudent")
    // 홈이 만들어지고 데이터가 만들어짐 그다음 Action
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "redirect:/student/lists";   // student lists로 redirect
    }

    // [3] 학생 정보 수정
    // [3-1] 학생 정보 수정 (Update)
    @GetMapping("/updateForm")
    public String showFormUpdate(@RequestParam("studentId")int id, Model model)throws ResourceNotFoundExeption{
        Student student = studentService.getStudent(id);    // 학생 정보 get
        model.addAttribute("student", student); // 객체 추가
        return "updateForm";    // 반환
    }
    // [3-2] 학생 정보 수정 (Update)
    @PostMapping("/updateStudent")  // POST 요청 처리 메소드
    public String updateStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);    // 저장
        return "redirect:/student/lists";   // student lists로 redirect
    }

    // [4] 학생 정보 삭제 DELETE
    @GetMapping("/delete")  // get 요청 처리 메소드
    public String deleteStudent(@RequestParam("studentId")int id)throws ResourceNotFoundExeption {
        studentService.deleteStudent(id);   // 삭제
        return "redirect:/student/lists";
    }
}
