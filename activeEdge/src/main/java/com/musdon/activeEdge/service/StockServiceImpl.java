package com.musdon.activeEdge.service;

import com.musdon.activeEdge.dto.ApiResponse;
import com.musdon.activeEdge.dto.StockRequest;
import com.musdon.activeEdge.entity.Stock;
import com.musdon.activeEdge.repository.StockRepository;
import com.musdon.activeEdge.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class StockServiceImpl implements IStockService{

    @Autowired
    StockRepository stockRepository;
    @Override
    public ApiResponse addStock(StockRequest request) {
        ApiResponse response = new ApiResponse();
        response.setResponseCode(ResponseUtil.ERROR);
        Stock stock = Stock.builder()
                .name(request.getName())
                .currentPrice(request.getCurrentPrice())
                .currentDay(new Date())
                .lastUpdate(null)
                .build();

        stockRepository.save(stock);
        response.setName(request.getName());
        response.setPrice(request.getCurrentPrice());
        response.setResponseCode(ResponseUtil.SUCCESS);
        response.setResponseMessage(ResponseUtil.SUCCESS_MESSAGE);
        return response;
    }

    @Override
    public List<Stock> fetchStock(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize, Sort.by("currentDay"));
        return stockRepository.findAll(pageable).stream().toList();
    }

    @Override
    public Stock fetchSpecificItemInStock(Long id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public ApiResponse updateStock(StockRequest request, Long id) {
        ApiResponse response = new ApiResponse();
        Optional<Stock> stockData = stockRepository.findById(id);
        if (!stockData.isPresent()){
            response.setResponseCode(ResponseUtil.NOT_FOUND_CODE);
            response.setResponseMessage(ResponseUtil.NOT_FOUND);
        }
        response.setResponseCode(ResponseUtil.ERROR);
        Stock stock = Stock.builder()
                .id(id)
                .name(request.getName())
                .currentPrice(request.getCurrentPrice())
                .currentDay(new Date())
                .lastUpdate(new Date())
                .build();

        stockRepository.save(stock);
        response.setName(request.getName());
        response.setPrice(request.getCurrentPrice());
        response.setResponseCode(ResponseUtil.SUCCESS);
        response.setResponseMessage(ResponseUtil.SUCCESS_MESSAGE);
        return response;
    }
}
