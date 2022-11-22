package com.musdon.activeEdge.service;

import com.musdon.activeEdge.dto.ApiResponse;
import com.musdon.activeEdge.dto.StockRequest;
import com.musdon.activeEdge.entity.Stock;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStockService {
    ApiResponse addStock(StockRequest request);
    List<Stock> fetchStock(int pageNumber, int pageSize);
    Stock fetchSpecificItemInStock(Long id);
    ApiResponse updateStock(StockRequest request, Long id);
}
