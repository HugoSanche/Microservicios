package com.example.currencyconversionservice.controller;

import com.example.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


//http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
@RestController
public class CurrencyConversionController {
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity

            ){
        return  new CurrencyConversion(1001L,from,to,quantity,BigDecimal.ONE,BigDecimal.ONE,"");
    }
}

















