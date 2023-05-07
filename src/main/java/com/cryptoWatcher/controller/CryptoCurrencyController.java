package com.cryptoWatcher.controller;

import com.cryptoWatcher.configuration.CryptoCurrencyConfiguration;
import com.cryptoWatcher.dto.CryptoDTO;
import com.cryptoWatcher.mapping.CryptoCurrencyMapper;
import com.cryptoWatcher.model.CryptoCurrency;
import com.cryptoWatcher.service.CryptoCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crypto-currency")
public class CryptoCurrencyController {
    private final CryptoCurrencyService cryptoCurrencyService;
    private final CryptoCurrencyMapper cryptoCurrencyMapper;
    private final CryptoCurrencyConfiguration cryptoCurrencyConfiguration;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CryptoDTO> getAll() {
        List<CryptoDTO> cryptoDTOS = new ArrayList<>();
        for (CryptoCurrency currency : cryptoCurrencyService.findAll()) {
            cryptoDTOS.add(cryptoCurrencyMapper.convertToDTO(currency));
        }
        return cryptoDTOS;
    }

    @GetMapping(path = "/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CryptoDTO> getBySymbol(@PathVariable String symbol) {
        if (Arrays.stream(cryptoCurrencyConfiguration.getSymbols()).anyMatch(s -> s == symbol)) {
            return ResponseEntity.ok(cryptoCurrencyMapper.convertToDTO(cryptoCurrencyService.findBySymbol(symbol)));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }


}
