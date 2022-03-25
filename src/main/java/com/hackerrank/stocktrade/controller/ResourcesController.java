package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/erase")
@RequiredArgsConstructor
public class ResourcesController {

    final TradeRepository repository;

    @DeleteMapping
    public ResponseEntity<?> eraseTrades(){
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
