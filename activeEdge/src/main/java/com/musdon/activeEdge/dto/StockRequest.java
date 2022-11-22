package com.musdon.activeEdge.dto;

import lombok.Data;

@Data
public class StockRequest {
    private String name;
    private Double currentPrice;
}
