package com.ulmu.loacardset_web.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cardSet", schema = "loa_card", uniqueConstraints = {@UniqueConstraint(columnNames = "cardSet_id")})
public class CardSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardSet_id", unique = true)
    private Long cardSetId;         //카드세트 pk

    @Column(name = "name", unique = true)
    private String name;            //카드세트 이름

    @Column(name = "cardIds", unique = false)
    private String cardIds;        //카드세트에 포함된 카드 id 목록

    @Column(name = "bonusValues", unique = false)
    private String bonusValues;     //세트 효과
}
