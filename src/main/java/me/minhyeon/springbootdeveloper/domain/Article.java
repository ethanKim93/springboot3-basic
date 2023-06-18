package me.minhyeon.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , updatable = false)
    private Long id; // DB 컬럼 'id'와 매칭

    @Column(name="title",nullable = false)
    private String title;
    @Column(name="content",nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 작성
    public Article(String title,String content){
        this.title = title;
        this.content = content;
    }

    public  void update(String title,String content){
        this.title = title;
        this.content = content;
    }

}
