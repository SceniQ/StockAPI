package com.hackerrank.stocktrade.model.repository;

import com.hackerrank.stocktrade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<Trade,Long> {
    Optional<Trade> findById(Long id);
    List<Trade> findBySymbolAndType(String stockSymbol, String type);
    List<Trade> findAllBySymbol(String symbol);
}
