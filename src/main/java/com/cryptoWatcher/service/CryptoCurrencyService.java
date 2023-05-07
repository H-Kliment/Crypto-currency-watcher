package com.cryptoWatcher.service;

import com.cryptoWatcher.configuration.CryptoCurrencyConfiguration;
import com.cryptoWatcher.model.CryptoCurrency;
import com.cryptoWatcher.repository.CryptoCurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CryptoCurrencyService {
    private final CryptoCurrencyConfiguration cryptoCurrencyConfiguration;
    private final CryptoCurrencyRepository cryptoCurrencyRepository;
    //private final String[] SYMBOLS_OF_ACCESSIBLE_CURRENCIES = {"BTC", "ETH", "SOL"};

    public void save(CryptoCurrency currency) {
        cryptoCurrencyRepository.save(currency);
    }

    public CryptoCurrency findById(long id) {
        CryptoCurrency currency = cryptoCurrencyRepository.findById(id).get();
        return currency;
    }

    public CryptoCurrency findBySymbol(String symbol) {
        return cryptoCurrencyRepository.findFirstBySymbolOrderByTimeOfCheckDesc(symbol);
    }

    public List<CryptoCurrency> findAll() {
        List<CryptoCurrency> currencies = new ArrayList<>();
        for (String symbol : cryptoCurrencyConfiguration.getSymbols()) {
            currencies.add(findBySymbol(symbol));
        }
        return currencies;
    }
}
