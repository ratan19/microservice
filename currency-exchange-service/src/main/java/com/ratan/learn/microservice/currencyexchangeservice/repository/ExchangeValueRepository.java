package com.ratan.learn.microservice.currencyexchangeservice.repository;

import com.ratan.learn.microservice.currencyexchangeservice.entity.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
