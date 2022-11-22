package com.musdon.activeEdge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stock")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    @Column(name = "current_price")
    private Double currentPrice;
    @Column(name = "current_day")
    @JsonIgnore
    private Date currentDay;

    @JsonIgnore
    @Column(name = "last_update")
    private Date lastUpdate;

    public Stock(String name, Double currentPrice, Date currentDay, Date lastUpdate){
        this.name = name;
        this.currentPrice = currentPrice;
        this.currentDay = currentDay;
        this.lastUpdate = lastUpdate;
    }
}
