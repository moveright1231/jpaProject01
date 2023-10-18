package com.ict01.jpaproject01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// ROMBOK을 써서 짧아짐
@Data
// 디폴트 Constructor
@NoArgsConstructor
// All 엔티티를 이렇게 만듬
@AllArgsConstructor
// 스키마를 (테이블)을 생략하면 안됨
@Entity
public class Student {
    // 오브젝트를 자동 Generationate 시킬 것

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성
    // 타입이 여러가지 있음

    private int id;         // id

    @Column(length = 30) // 행의 길이 30
    private String name;    // 이름

    @Column(length = 30)
    private String email;   // 이메일

    @Column(length = 100)
    private String address; // 주소
}
