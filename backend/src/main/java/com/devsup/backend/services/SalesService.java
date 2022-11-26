package com.devsup.backend.services;

import com.devsup.backend.entities.Sale;
import com.devsup.backend.repositories.SalesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class SalesService {

    @Autowired
    private SalesRepository repository;

    public Page<Sale> list(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){

        LocalDate min = !"".equals(minDate) ? LocalDate.parse(minDate): LocalDate.now().minusDays(365);
        LocalDate max = !"".equals(maxDate) ? LocalDate.parse(maxDate): LocalDate.now();

        return repository.findSales(min, max, pageable);
    }

    public void notificar(Long id) {
        Sale entity = repository.findById(id).orElseThrow();
        log.debug("O Vendedor {} no dia {} realizou um total de {} vendas e gerou um total de {}", entity.getSellerName(), entity.getDate(), entity.getDeals(), entity.getAmount());
    }
}
