package com.ratan.learn.microservice.currencyexchangeservice.controller;


import com.ratan.learn.microservice.currencyexchangeservice.entity.ExchangeValue;
import com.ratan.learn.microservice.currencyexchangeservice.repository.ExchangeValueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

        ExchangeValue e = exchangeValueRepository.findByFromAndTo(from, to);
        e.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("{}", e);
        return e;
    }
}
