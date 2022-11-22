package com.musdon.activeEdge;

import com.musdon.activeEdge.entity.Stock;
import com.musdon.activeEdge.repository.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    StockRepository stockRepository;

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    @Override
    public void run(String... args) throws Exception {


        stockRepository.save(new Stock("IPhone 14", 14000.00, new Date(), new Date()));
        stockRepository.save(new Stock("IPhone 13", 13000.00, new Date(), new Date()));
        stockRepository.save(new Stock("IPhone 12", 12000.00, new Date(), new Date()));

        stockRepository.findAll().forEach((stock -> logger.info("{}", stock)));
    }
}
