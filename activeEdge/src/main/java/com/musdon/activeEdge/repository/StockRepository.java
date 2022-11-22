package com.musdon.activeEdge.repository;

import com.musdon.activeEdge.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
