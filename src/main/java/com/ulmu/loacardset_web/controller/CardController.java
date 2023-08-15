package com.ulmu.loacardset_web.controller;

import com.ulmu.loacardset_web.dto.CardDto;
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
}