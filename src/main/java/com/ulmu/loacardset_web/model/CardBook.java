package com.ulmu.loacardset_web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cardBook", schema = "loa_card", uniqueConstraints = {@UniqueConstraint(columnNames = "cardBook_id")})
public class CardBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardBook_id", unique = true)
    private Long cardBookId;        //카드 도감 id

    @Column(name = "name", unique = true)
    private String name;            //카드 도감 이름

    @Column(name = "statValue", unique = false)
    private int statValue;          //카드 도감 스탯 증가량

    @Column(name = "statName", unique = false)
    private String statName;        //카드 도감 스탯 종류

    @Column(name = "cardIds", unique = false)
    private String cardIds;         //카드 도감에 포함된 카드 id들

    @Column(name = "extraDmgValues", unique = false)
    private String extraDmgValues;  //카드 도감 추가피해 값

    @Column(name = "extraDmgName", unique = false)
    private String extraDmgName;    //카드 도감 추가 데미지 종류
}
