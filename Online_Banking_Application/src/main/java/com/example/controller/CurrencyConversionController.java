package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.CurrencyConversionException;
import com.example.model.CurrencyConversion;
import com.example.service.CurrencyConversionService;


@RestController
@RequestMapping("/currency-conversions")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @PostMapping
    public ResponseEntity<CurrencyConversion> createCurrencyConversion(@RequestBody CurrencyConversion currencyConversion) {
        try {
            CurrencyConversion createdCurrencyConversion = currencyConversionService.createCurrencyConversion(currencyConversion);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCurrencyConversion);
        } catch (CurrencyConversionException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
