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
    private Long cardBookId;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "statValue", unique = false)
    private int statValue;

    @Column(name = "statName", unique = false)
    private String statName;

    @Column(name = "cardIds", unique = false)
    private String cardIds;

    @Column(name = "extraDmgValues", unique = false)
    private String extraDmgValues;

    @Column(name = "extraDmgName", unique = false)
    private String extraDmgName;
}
