package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stocks")
@RequiredArgsConstructor
public class StocksController {

    final TradeService service;

    @GetMapping(value = "/{stockSymbol}/price")
    public ResponseEntity<?> getStocks(@PathVariable String stockSymbol,
                                             @RequestParam String startDate,
                                             @RequestParam String endDate){
        return service.getStocks(stockSymbol,startDate,endDate);
    }
}
