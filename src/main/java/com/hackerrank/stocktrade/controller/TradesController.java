package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.dto.TradeRequest;
import com.hackerrank.stocktrade.model.repository.TradeRepository;
import com.hackerrank.stocktrade.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/trades")
@RequiredArgsConstructor
public class TradesController {

    final TradeService service;

    @PostMapping
    public ResponseEntity<?> addNewTrade(TradeRequest request){
        return service.addTrade(request);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTradeById(@PathVariable Long id){
        return service.getTradeById(id);
    }

    @GetMapping
    public ResponseEntity<?> getAllTrades(){
        return service.getAllTrades();
    }

    @GetMapping(value = "/users/{userID}")
    public ResponseEntity<?> getTradeByUserId(@PathVariable Long userID){
        return service.getTradeByUserId(userID);
    }

    @GetMapping(value = "/stocks/{stockSymbol}")
    public ResponseEntity<?> getStocks(@PathVariable String stockSymbol,
                                             @RequestParam String type,
                                             @RequestParam String startDate,
                                             @RequestParam String endDate){
        return service.getTradeRecords(stockSymbol,type,startDate,endDate);
    }
}
