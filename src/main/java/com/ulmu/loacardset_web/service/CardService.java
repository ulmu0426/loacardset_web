package com.ulmu.loacardset_web.service;

import com.ulmu.loacardset_web.dto.CardDto;
import com.ulmu.loacardset_web.mapper.CardMapper;
import com.ulmu.loacardset_web.model.Card;
import com.ulmu.loacardset_web.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<CardDto> getCardList(String howToSort) throws IllegalAccessException {
        List<Card> cards;
        if (Objects.equals(howToSort, "byName")) {
            cards = cardRepository.findAllOrderByNameDesc(howToSort);
        } else if (Objects.equals(howToSort, "byId")) {
            cards = cardRepository.findAllOrderByCardIdDesc(howToSort);
        } else if (Objects.equals(howToSort, "byGetCard")) {
            cards = cardRepository.findAllOrderByGetCardDesc(howToSort);
        } else {
            throw new IllegalAccessException("정렬 기준을 알 수 없습니다.");
        }
        return CardMapper.convertToCardDtoList(cards);
    }
}
