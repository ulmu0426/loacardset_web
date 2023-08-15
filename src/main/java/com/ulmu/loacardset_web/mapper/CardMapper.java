package com.ulmu.loacardset_web.mapper;

import com.ulmu.loacardset_web.dto.CardDto;
import com.ulmu.loacardset_web.model.Card;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class CardMapper {
    public static CardDto convertToCardDto(Card card){
        CardDto cardDto = new CardDto();
        cardDto.setCardId(card.getCardId());
        cardDto.setName(card.getName());
        cardDto.setCount(card.getCount());
        cardDto.setAwake(card.getAwake());
        cardDto.setGrade(card.getGrade());
        cardDto.setChecked(card.isChecked());
        cardDto.setPath(card.getPath());

        return cardDto;
    }

    public static Card convertToCardModel(CardDto cardDto){
        Card card = new Card();
        card.setCardId(cardDto.getCardId());
        card.setName(cardDto.getName());
        card.setCount(cardDto.getCount());
        card.setAwake(cardDto.getAwake());
        card.setGrade(cardDto.getGrade());
        card.setChecked(cardDto.isChecked());
        card.setPath(cardDto.getPath());

        return card;
    }

    public static List<CardDto> convertToCardDtoList(List<Card> cards) {
        return cards.stream()
                .map(CardMapper::convertToCardDto)
                .collect(Collectors.toList());
    }

    public static List<Card> convertToCardModelList(List<CardDto> cardDtos) {
        return cardDtos.stream()
                .map(CardMapper::convertToCardModel)
                .collect(Collectors.toList());
    }
}
