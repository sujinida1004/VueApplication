package com.study.VueApplication.Board.domain;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 3. Domain Layer (도메인 계층) (Model)
 *
 * 비즈니스 규칙, 정보에 대한 실질적인 도메인에 대한 정보를 가지고 있으며 이 모든 것을 책임지는 계층이다.
 * Entity를 활용하여 도메인 로직이 실행되며, 업무 상황을 반영하여 상태를 제어하는 역할에 집중하는 계층이다.
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자의 접근 권한을 protected로 제한함
@Data
@Entity(name = "BOARD")
public class Board {

    /*
    AUTO(default): JPA구현체(Hibernate)가 적절한 생성 전략을 선택해 생성 (Java 변수 타입에 따라)

    IDENTITY: 데이터베이스가 생성. 기본키 생성을 데이터베이스에 위임해주고 id가 null 이면 알아서 auto_increment 해줌
    SEQUENCE: 데이터베이스의 시퀀스를 사용해 기본키 생성
    TABLE: 기본키 값을 데이터베이스 테이블을 사용해 생성
    */
    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성규칙.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;
    private String contents;
    private String reg_id;
    private String reg_dt;

//    private File file;

    @Builder
    public Board(String title, String contents, String reg_id) {
        this.title = title;
        this.contents = contents;
        this.reg_id = reg_id;
        this.reg_dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

}
