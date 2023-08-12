package com.ulmu.loacardset_web.mapper;

import com.ulmu.loacardset_web.dto.CardBookDto;
import com.ulmu.loacardset_web.model.CardBook;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardBookMapper {
    public static CardBookDto convertToCardBookDto(CardBook cardBook){
        CardBookDto cardBookDto = new CardBookDto();
        cardBookDto.setCardBookId(cardBook.getCardBookId());
        cardBookDto.setName(cardBook.getName());
        cardBookDto.setStatValue(cardBook.getStatValue());
        cardBookDto.setStatName(cardBook.getStatName());
        cardBookDto.setCardIds(stringToLongList(cardBook.getCardIds()));
        cardBookDto.setExtraDmgValues(stringToFloatList(cardBook.getExtraDmgValues()));
        cardBookDto.setExtraDmgName(cardBook.getExtraDmgName());
        return cardBookDto;
    }

    private static List<Long> stringToLongList(String cardBookCardIds) {
        /**
         * DB의 ','로 구분된 카드들의 Text id 값을 List<Long>으로 반환하는 메소드
         */
        return Stream.of(cardBookCardIds)
                .map(String::trim)
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private static List<Float> stringToFloatList(String extraDmgValues) {
        /**
         * DB의 ','로 구분된 카드들의 Text extraDmgValues 값을 List<Float>으로 반환하는 메소드
         */
        return Stream.of(extraDmgValues)
                .map(Float::parseFloat)
                .collect(Collectors.toList());
    }

    public static CardBook convertToCardBookModel(CardBookDto cardBookDto){
        CardBook cardBook = new CardBook();
        cardBook.setCardBookId(cardBookDto.getCardBookId());
        cardBook.setName(cardBookDto.getName());
        cardBook.setStatValue(cardBookDto.getStatValue());
        cardBook.setStatName(cardBookDto.getStatName());
        cardBook.setCardIds(longListToString(cardBookDto.getCardIds()));
        cardBook.setExtraDmgValues(floatListToString(cardBookDto.getExtraDmgValues()));
        cardBook.setExtraDmgName(cardBookDto.getExtraDmgName());
        return cardBook;
    }

    private static String longListToString(List<Long> cardIds) {
        /**
         * CardBookDto 의 List<Long> 형태로 저장된 카드 세트에 포함된 카드 id 들을
         * 다시 DB에 저장할 수 있는 형태인 String 으로 변환하는 메소드
         * ','로 구분하여 저장
         */
        return cardIds.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(","));
    }

    private static String floatListToString(List<Float> extraDmgValues) {
        /**
         * CardBookDto 의 List<Float> 형태로 저장된 카드 세트에 포함된 카드 id 들을
         * 다시 DB에 저장할 수 있는 형태인 String 으로 변환하는 메소드
         * ','로 구분하여 저장
         */
        return extraDmgValues.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(","));
    }
}
