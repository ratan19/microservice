package com.ratan.learn.microservice.limitsservice.controller;

import com.ratan.learn.microservice.limitsservice.bean.LimitConfiguration;
import com.ratan.learn.microservice.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LimitsConfigurationController {


    @Autowired
    Configuration configuration;

    @GetMapping(path = "/limits")
    public LimitConfiguration retrieveLimitsFromConfiguration(){

        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());

    }
}
