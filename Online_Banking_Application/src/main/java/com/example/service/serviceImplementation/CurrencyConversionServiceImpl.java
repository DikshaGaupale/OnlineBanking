package com.example.service.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CurrencyConversionException;
import com.example.model.CurrencyConversion;
import com.example.repository.CurrencyConversionRepository;
import com.example.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	 @Autowired
	     CurrencyConversionRepository currencyConversionRepository;
	 
	 @Override
	 public CurrencyConversion createCurrencyConversion(CurrencyConversion currencyConversion) throws CurrencyConversionException {
	     // Validate the source and target currencies
	     String sourceCurrency = currencyConversion.getSourceCurrency();
	     String targetCurrency = currencyConversion.getTargetCurrency();
	     if (sourceCurrency.equals(targetCurrency)) {
	         throw new CurrencyConversionException("Source and target currencies cannot be the same.");
	     }
	     
	     // Validate the exchange rate
	     double exchangeRate = currencyConversion.getExchangeRate();
	     if (exchangeRate <= 0) {
	         throw new CurrencyConversionException("Exchange rate must be a positive value.");
	     }
	     
	     // Perform any additional validations or business rules specific to currency conversions
	     
	     // Save the currency conversion to the repository
	     return currencyConversionRepository.save(currencyConversion);
	 }
}
