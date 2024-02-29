package com.egt.intern.task.service;

import com.egt.intern.task.model.Currency;
import com.egt.intern.task.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Currency findByBase(String base){
         List<Currency> currenciesResult = currencyRepository.findByBase(base);
         return currenciesResult.stream()
                 .sorted((o1, o2) -> o2.getTimestamp().compareTo(o1.getTimestamp()))
                 .findFirst()
                 .get();
    }

    public Currency findById(long id) {return  currencyRepository.findById(id).get();}
}
