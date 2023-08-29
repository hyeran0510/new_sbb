package com.mysite.sbb.question;


import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer id;

    @Column(length = 200) // VARCHAR(200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate; // DATETIME

    // 아래 처럼 다른 엔티티 클래스 리모콘을 저장할 때는 꼭 관계를 적어준다.
    //private Question question;
    // `public class Answer` @ManyToOne `private Question question`
    //질문 하나에 질문 여러개 퀘스쳔매니

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;


}
