package com.ulmu.loacardset_web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "card", schema = "loa_card", uniqueConstraints = {@UniqueConstraint(columnNames = "card_id")})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id", unique = true)
    private Long cardId;        //카드 pk

    @Column(name = "name", unique = true)
    private String name;        //카드이름

    @Column(name = "count", unique = false)
    private int count;          //보유
    
    @Column(name = "awake", unique = false)
    private int awake;          //각성수치
    
    @Column(name = "grade", unique = false)
    private String grade;       //카드 등급
    
    @Column(name = "getCard", unique = false)
    private boolean checked;    //카드 획득 유무
    
    @Column(name = "path", unique = false)
    private String path;        //카드 이미지 경로

    public Card() {     //보유량, 각성도, 획득유무 기본값 없음
        this.count = 0;
        this.awake = 0;
        this.checked = false;
    }
}
