package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.dto.Response;
import com.hackerrank.stocktrade.dto.TradeRequest;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.repository.TradeRepository;
import com.hackerrank.stocktrade.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TradeService {

    final TradeRepository repository;
    final UserRepository userRepository;

    public ResponseEntity<?> addTrade(TradeRequest request){
        Optional<Trade> trade = repository.findById(request.getId());
        if(trade.isPresent()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Trade newTrade = new Trade();
        newTrade.setId(request.getId());
        newTrade.setType(request.getType());
        newTrade.setUser(request.getUser());
        newTrade.setSymbol(request.getSymbol());
        newTrade.setShares(request.getShares());
        newTrade.setPrice(request.getPrice());
        newTrade.setTimestamp(LocalDateTime.
                parse(request.getTimestamp().replace(" ","T")));

        userRepository.save(request.getUser());
        repository.save(newTrade);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<?> getTradeById(Long id){
        Optional<Trade> trade = repository.findById(id);
        if(!trade.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(trade.get(),HttpStatus.OK);
    }

    public ResponseEntity<?> getAllTrades(){
        List<Trade> trades = repository.findAll();
        if(trades.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(trades,HttpStatus.OK);
    }

    public ResponseEntity<?> getTradeByUserId(Long userId){
        List<Trade> trades = repository.findAll();
        List<Trade> userTrades = new ArrayList<>();
        if(trades.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        for(Trade trade: trades){
            if(trade.getUser().getId().equals(userId)){
                userTrades.add(trade);
            }
        }
        if(userTrades.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Arrays.sort(new List[]{userTrades});
        return new ResponseEntity<>(userTrades,HttpStatus.OK);
    }

    public ResponseEntity<?> getTradeRecords(String stockSymbol, String type, String startDate, String endDate){
        List<Trade> trades = repository.findBySymbolAndType(stockSymbol,type);
        List<Trade> userTrades = new ArrayList<>();
        if(trades.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        for(Trade trade: trades){
            LocalDate tradingDate = trade.getTimestamp().toLocalDate();
            LocalDate startingDate = LocalDate.parse(startDate);
            LocalDate endingDate = LocalDate.parse(endDate);
            if(tradingDate.isAfter(startingDate) && tradingDate.isBefore(endingDate))
                userTrades.add(trade);
        }
        if(userTrades.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userTrades,HttpStatus.OK);
    }


    public ResponseEntity<?> getStocks(String stockSymbol, String startDate, String endDate){
        Response message =  new Response("There are no trades in the given date range");
        List<Trade> trades = repository.findAllBySymbol(stockSymbol);
        List<Float> tradePrices = new ArrayList<>();
        if(trades.isEmpty())
            return new ResponseEntity<>(message.getMessage(), HttpStatus.NOT_FOUND);

        for(Trade trade: trades){
            LocalDate tradingDate = trade.getTimestamp().toLocalDate();
            LocalDate startingDate = LocalDate.parse(startDate);
            LocalDate endingDate = LocalDate.parse(endDate);
            if(tradingDate.isAfter(startingDate) && tradingDate.isBefore(endingDate))
                tradePrices.add(trade.getPrice());
        }

        if(tradePrices.isEmpty())
            return new ResponseEntity<>(message.getMessage(), HttpStatus.NOT_FOUND);

        Collections.sort(tradePrices);

        SuccessResponse response = new SuccessResponse();
        response.setSymbol(stockSymbol);
        response.setHighestPrice(tradePrices.get(tradePrices.size()-1));
        response.setLowestPrice(tradePrices.get(0));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class SuccessResponse{
        private String symbol;
        private Float lowestPrice;
        private Float HighestPrice;
    }

}
