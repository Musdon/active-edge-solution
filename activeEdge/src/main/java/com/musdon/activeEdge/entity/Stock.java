package com.musdon.activeEdge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "current_price")
    private Double currentPrice;
    @Column(name = "current_day")
    private Date currentDay;
    @Column(name = "last_update")
    private Date lastUpdate;

    public Stock(String name, Double currentPrice, Date currentDay, Date lastUpdate){
        this.name = name;
        this.currentPrice = currentPrice;
        this.currentDay = currentDay;
        this.lastUpdate = lastUpdate;
    }
}
