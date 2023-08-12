package com.ulmu.loacardset_web.mapper;

import com.ulmu.loacardset_web.dto.CardDto;
import com.ulmu.loacardset_web.model.Card;

public class CardMapper {
    public static CardDto convertToCardDto(Card card){
        CardDto cardDto = new CardDto();
        cardDto.setCardId(card.getCardId());
        cardDto.setName(card.getName());
        cardDto.setCount(card.getCount());
        cardDto.setAwake(card.getAwake());
        cardDto.setGrade(card.getGrade());
        cardDto.setGetCard(card.isGetCard());
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
        card.setGetCard(cardDto.isGetCard());
        card.setPath(cardDto.getPath());

        return card;
    }
}
