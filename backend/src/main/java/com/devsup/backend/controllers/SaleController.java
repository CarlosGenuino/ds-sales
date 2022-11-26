package com.devsup.backend.controllers;

import com.devsup.backend.entities.Sale;
import com.devsup.backend.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SalesService service;

    @GetMapping
    public ResponseEntity<Page<Sale>> list(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable
    ){
        Page<Sale> sales = service.findSales(minDate, maxDate, pageable);
        return ResponseEntity.ok(sales);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> notificar(@PathVariable Long id){
        service.notificar(id);
        return ResponseEntity.ok().build();
    }

}
