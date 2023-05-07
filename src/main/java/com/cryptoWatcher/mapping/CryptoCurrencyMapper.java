package com.cryptoWatcher.mapping;

import com.cryptoWatcher.dto.CryptoDTO;
import com.cryptoWatcher.model.CryptoCurrency;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class CryptoCurrencyMapper {

    public CryptoCurrency convertToCurrency(CryptoDTO cryptoDTO) {
        CryptoCurrency currency = new CryptoCurrency();
        currency.setCurrencyId(cryptoDTO.getId());
        currency.setName(cryptoDTO.getName());
        currency.setSymbol(cryptoDTO.getSymbol());
        currency.setPrice_usd(cryptoDTO.getPrice_usd());
        currency.setTimeOfCheck(Calendar.getInstance());
        return currency;
    }

    public CryptoDTO convertToDTO(CryptoCurrency cryptoCurrency) {
        CryptoDTO cryptoDTO = new CryptoDTO();
        cryptoDTO.setId(cryptoCurrency.getCurrencyId());
        cryptoDTO.setName(cryptoCurrency.getName());
        cryptoDTO.setSymbol(cryptoCurrency.getSymbol());
        cryptoDTO.setPrice_usd(cryptoCurrency.getPrice_usd());
        cryptoDTO.setTimeOfCheck(cryptoCurrency.getTimeOfCheck());
        return cryptoDTO;
    }

}
