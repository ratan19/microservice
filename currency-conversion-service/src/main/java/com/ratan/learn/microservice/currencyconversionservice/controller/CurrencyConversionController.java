package com.ratan.learn.microservice.currencyconversionservice.controller;


import com.ratan.learn.microservice.currencyconversionservice.proxies.CurrencyExchangeServiceProxy;
import com.ratan.learn.microservice.currencyconversionservice.entity.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy ;

    @GetMapping(path = "currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean getConvertedCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){


        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> responseEntity =  new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class, uriVariables);


        CurrencyConversionBean c = responseEntity.getBody();

        return new CurrencyConversionBean(c.getId(), from, to, c.getConversionMultiple(),quantity, quantity.multiply(c.getConversionMultiple()),c.getPort());
    }

    @GetMapping(path = "currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean getConvertedCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){


        /*Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> responseEntity =  new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean c = responseEntity.getBody();*/

        CurrencyConversionBean c = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);

        logger.info("{}", c);
        return new CurrencyConversionBean(c.getId(), from, to, c.getConversionMultiple(),quantity, quantity.multiply(c.getConversionMultiple()),c.getPort());
    }
}
