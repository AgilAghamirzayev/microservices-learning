package com.example.currencyconversion.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Log4j2
@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeServiceProxy proxy;

    //    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
//
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//
//        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
//                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
//
//        CurrencyConversionBean body = responseEntity.getBody();
//
//        return new CurrencyConversionBean(body.getId(), from, to, body.getConversionMultiple(), quantity,
//                quantity.multiply(body.getConversionMultiple()), body.getPort());
//
//    }
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

        log.info("{}", response);
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());

    }
}
