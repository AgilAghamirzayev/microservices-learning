package com.in28minutes.currencyexchangeservice.repository;

import com.in28minutes.currencyexchangeservice.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findByFromAndTo(String from, String to);
}
