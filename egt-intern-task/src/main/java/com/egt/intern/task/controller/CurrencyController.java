package com.egt.intern.task.controller;

import com.egt.intern.task.model.Currency;

import com.egt.intern.task.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    //test data insert, comment if wanting to use actual fixer api
    @PostMapping("/exchange")
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency) {

            try {
                Currency _currency = currencyService.save(new Currency(
                        currency.getId(),
                        currency.isSuccess(),
                        currency.getTimestamp(),
                        currency.getBase(),
                        currency.getDate(),
                        currency.getRates()
                ));
                return new ResponseEntity<>(_currency, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @GetMapping("/exchange/{base}")
    public ResponseEntity<Currency> getLatestRates(@PathVariable String base) {
        return ResponseEntity.ok(currencyService.findByBase(base));
    }


    @GetMapping("/exchange/all")
    private ResponseEntity<List<Currency>> findAll() {
        return ResponseEntity.ok(currencyService.findAll());
    }
}
