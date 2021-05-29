package com.in28minutes.currencyexchangeservice.controller;

import com.in28minutes.currencyexchangeservice.entity.CurrencyExchange;
import com.in28minutes.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("/currency-exchange")
public record CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable("from") String from,
                                                  @PathVariable("to") String to) {

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if (currencyExchange == null) {
            throw new RuntimeException("Unable to find data for from: " + from + " to: " + to);
        }

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
