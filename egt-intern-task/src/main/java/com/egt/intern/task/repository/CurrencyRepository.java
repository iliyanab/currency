package com.egt.intern.task.repository;

import com.egt.intern.task.model.Currency;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    boolean existsByBase(String base);

    List<Currency> findByBase(String base);

}
