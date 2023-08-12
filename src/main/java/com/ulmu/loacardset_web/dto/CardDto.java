package com.ulmu.loacardset_web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Long cardId;        //카드 id

    private String name;        //카드 이름

    private int count;          //카드 보유 수량

    private int awake;          //카드 각성도

    private String grade;       //카드 등급

    private boolean getCard;    //카드 획득 유무

    private String path;        //카드 이미지 경로
}
