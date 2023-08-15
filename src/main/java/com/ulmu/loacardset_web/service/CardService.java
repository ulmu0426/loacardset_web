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
        /**
         * 요청한 정렬 순서에 따라 카드 목록 CardDto 형태로 반환
         */
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

    public List<CardDto> updateCardList(List<CardDto> cardDtos) {
        /**
         * 카드 목록을 수정후 수정된 카드 목록 CardDto 형태로 반환
         */
        for (CardDto cardDto : cardDtos){
            Optional<Card> res = cardRepository.findById(cardDto.getCardId());
            if(res.isEmpty()){
                continue;
            }
            Card tempCard = res.get();
            tempCard.setAwake(cardDto.getAwake());
            tempCard.setCount(cardDto.getCount());
            tempCard.setChecked((tempCard.getAwake() > 0) || (tempCard.getCount() > 0));
            this.cardRepository.save(tempCard);
        }
        return CardMapper.convertToCardDtoList(cardRepository.findAllOrderByCardIdDesc("byId"));
    }
}
