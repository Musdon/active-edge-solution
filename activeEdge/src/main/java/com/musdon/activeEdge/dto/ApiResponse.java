package com.musdon.activeEdge.dto;

import com.musdon.activeEdge.entity.Stock;
import lombok.Data;

@Data
public class ApiResponse {
    private String responseCode;
    private String responseMessage;
    private String name;
    private Double price;
}
