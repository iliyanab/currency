package com.egt.intern.task.service;

import com.egt.intern.task.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CurrencyRetrievalService {
    @Value("${url}")
    private String EXCHANGE_API_URL;

    @Autowired
    private final CurrencyService currencyService;

    private final RestTemplate restTemplate;

    @Autowired
    public CurrencyRetrievalService(CurrencyService currencyService, RestTemplate restTemplate) {
        this.currencyService = currencyService;
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void updateCurrencyData() {
        ResponseEntity<Currency> response = restTemplate.getForEntity(EXCHANGE_API_URL, Currency.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            Currency currency = response.getBody();
            currencyService.save(currency);
        }

    }
}
