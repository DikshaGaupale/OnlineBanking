package com.example.service;

import com.example.exception.CurrencyConversionException;
import com.example.model.CurrencyConversion;

public interface CurrencyConversionService {

	public CurrencyConversion createCurrencyConversion(CurrencyConversion currencyConversion) throws CurrencyConversionException;
}
