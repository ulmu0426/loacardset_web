package com.ulmu.loacardset_web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CardBookDto {
    private Long cardBookId;

    private String name;

    private int statValue;

    private String statName;

    private List<Long> cardIds;

    private List<Float> extraDmgValues;

    private String extraDmgName;
}
