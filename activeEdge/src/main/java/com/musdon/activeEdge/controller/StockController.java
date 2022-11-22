package com.musdon.activeEdge.controller;

import com.musdon.activeEdge.dto.ApiResponse;
import com.musdon.activeEdge.dto.StockRequest;
import com.musdon.activeEdge.entity.Stock;
import com.musdon.activeEdge.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    IStockService iStockService;

    @PostMapping
    public ApiResponse addToStock(@RequestBody StockRequest stockRequest){
        return iStockService.addStock(stockRequest);
    }

    @GetMapping
    public List<Stock> fetchStock(@RequestParam int pageNo, int pageSize){
        return iStockService.fetchStock(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id){
        return iStockService.fetchSpecificItemInStock(id);
    }

    @PutMapping("/{id}")
    public ApiResponse updateStock(@PathVariable("id") Long id, @RequestBody StockRequest stockRequest){
        return iStockService.updateStock(stockRequest, id);
    }
}
