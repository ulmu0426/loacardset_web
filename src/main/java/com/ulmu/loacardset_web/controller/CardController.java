package com.ulmu.loacardset_web.controller;

import com.ulmu.loacardset_web.dto.CardDto;
import com.ulmu.loacardset_web.model.Card;
import com.ulmu.loacardset_web.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping(value = "/{sort}")
    public ResponseEntity<List<CardDto>> getCardList(@PathVariable("sort") String sort) throws IllegalAccessException {
        List<CardDto> cardDtos = cardService.getCardList(sort);
        return new ResponseEntity<>(cardDtos, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<List<CardDto>> putCardList(@RequestBody List<CardDto> cardDtos) {
        List<CardDto> cardDtoList = cardService.updateCardList(cardDtos);
        return new ResponseEntity<>(cardDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<CardDto>> getCardListAsGrade(@PathVariable("sort") String sort,
                                                            @PathVariable("grade") String grade) throws IllegalAccessException {
        List<CardDto> cardDtos = cardService.getCardListAsGrade(sort, grade);
        return new ResponseEntity<>(cardDtos, HttpStatus.OK);
    }
}
