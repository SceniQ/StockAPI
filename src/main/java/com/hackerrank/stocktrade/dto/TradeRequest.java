package com.hackerrank.stocktrade.dto;

import com.hackerrank.stocktrade.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeRequest {

    private Long id;
    private String type;
    private User user;
    private String symbol;
    private int shares;
    private Float price;
    private String timestamp;

}
