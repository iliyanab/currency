package com.egt.intern.task;

import com.egt.intern.task.model.Currency;
import com.egt.intern.task.repository.CurrencyRepository;
import com.egt.intern.task.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootJpaH2ApplicationTests {
	@Autowired
	private CurrencyRepository mockCurrencyRepository;

	@Autowired
	private CurrencyService mockCurrencyService;

	@Test
	void contextLoads() {
	}

	@Test
	void getLatestCurrencyData() {

		Map<String, Double> mockRates = new HashMap<String, Double>();
		mockRates.put("EUR", 1.566017);
		mockRates.put("CHF",1.154727);


		Currency testCurrency = new Currency();
		testCurrency.setSuccess(true);
		testCurrency.setTimestamp(1519296210);
		testCurrency.setBase("JPY");
		testCurrency.setDate(LocalDate.of(2024, 2, 28));
		testCurrency.setRates(mockRates);

		mockCurrencyRepository.save(testCurrency);
		ResponseEntity.ok(mockCurrencyService.findById(testCurrency.getId()));
	}

}
