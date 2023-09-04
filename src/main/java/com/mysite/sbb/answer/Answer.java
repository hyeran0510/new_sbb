package com.mysite.sbb.answer;


import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String Subject;

    @Column(columnDefinition = "TEXT")
    private String Content;

    private LocalDateTime createDate; // DATETIME

    // 아래 처럼 다른 엔티티 클래스 리모콘을 저장할 때는 꼭 관계를 적어준다.
    //private Question question;
    // `public class Answer` @ManyToOne `private Question question`
    //질문 하나에 질문 여러개 퀘스쳔매니

    @ManyToOne
    private Question question;

    @ManyToOne
    private SiteUser author;
    //답변에 인증자 하나

    private LocalDateTime modifyDaye;

    }

