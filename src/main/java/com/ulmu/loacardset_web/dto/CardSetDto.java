package com.ulmu.loacardset_web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardSetDto {
    private Long cardSetId;             //카드세트 id

    private String name;                //카드세트 이름

    private List<Long> cardIds;         //카드세트에 포함된 카드 id들

    private List<String> bonusValues;   //카드세트효과 증가량

    private Boolean favorite;           //카드세트 즐겨찾기
}
