package com.ulmu.loacardset_web.mapper;

import com.ulmu.loacardset_web.dto.CardSetDto;
import com.ulmu.loacardset_web.model.CardSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardSetMapper {
    public static CardSetDto convertToCardSetDto(CardSet cardSet){
        CardSetDto cardSetDto = new CardSetDto();
        cardSetDto.setCardSetId(cardSet.getCardSetId());
        cardSetDto.setName(cardSet.getName());
        cardSetDto.setCardIds(stringToLongList(cardSet.getCardIds()));
        cardSetDto.setBonusValues(stringToStringList(cardSet.getBonusValues()));
        cardSetDto.setFavorite(cardSet.getFavorite());

        return cardSetDto;
    }

    private static List<Long> stringToLongList(String ids){
        /**
         * DB의 ','로 구분된 카드들의 Text id 값을 List<Long>으로 반환하는 메소드
         */
        return Stream.of(ids)
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
    private static List<String> stringToStringList(String bonusValues){
        /**
         * DB의 ','로 구분된 카드세트 효과들의 Text 값을 List<String>으로 반환하는 메소드
         */
        return Stream.of(bonusValues.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static CardSet convertToCardSetModel(CardSetDto cardSetDto){
        CardSet cardSet = new CardSet();
        cardSet.setCardSetId(cardSetDto.getCardSetId());
        cardSet.setName(cardSetDto.getName());
        cardSet.setCardIds(longListToString(cardSetDto.getCardIds()));
        cardSet.setBonusValues(stringListToString(cardSetDto.getBonusValues()));
        cardSet.setFavorite(cardSetDto.getFavorite());

        return cardSet;
    }

    private static String longListToString(List<Long> cardIds) {
        /**
         * CardSetDto 의 List<Long> 형태로 저장된 카드 세트에 포함된 카드 id 들을
         * 다시 DB에 저장할 수 있는 형태인 String 으로 변환하는 메소드
         * ','로 구분하여 저장
         */
        return cardIds.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(","));
    }

    private static String stringListToString(List<String> bonusValues) {
        /**
         * CardSetDto 의 List<String> 형태로 저장된 카드 세트 달성도별 효과를
         * 다시 DB에 저장할 수 있는 형태인 String 으로 변환하는 메소드
         * ','로 구분하여 저장
         */
        return bonusValues.stream()
                .collect(Collectors.joining(","));
    }
}
