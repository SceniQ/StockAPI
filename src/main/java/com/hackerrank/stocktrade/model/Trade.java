package com.hackerrank.stocktrade.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "trade")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;
    private String symbol;
    private Integer shares;
    private Float price;
    private LocalDateTime timestamp;
    

}
