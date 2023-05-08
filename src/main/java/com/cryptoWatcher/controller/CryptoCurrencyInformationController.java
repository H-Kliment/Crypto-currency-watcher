package com.cryptoWatcher.controller;


import com.cryptoWatcher.configuration.CryptoCurrencyConfiguration;
import com.cryptoWatcher.dto.CryptoDTO;
import com.cryptoWatcher.mapping.CryptoCurrencyMapper;
import com.cryptoWatcher.model.CryptoCurrency;
import com.cryptoWatcher.service.CryptoCurrencyService;
import com.cryptoWatcher.utility.ControllingPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class CryptoCurrencyInformationController {
    private final CryptoCurrencyService cryptoCurrencyService;
    private final CryptoCurrencyMapper cryptoCurrencyMapper;
    private final ControllingPrice controllingPrice;
    private final CryptoCurrencyConfiguration cryptoCurrencyConfiguration;

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void updateValue() {
        RestTemplate restTemplate = new RestTemplate();
        for (int i : cryptoCurrencyConfiguration.getId()) {
            String url = String.format("https://api.coinlore.net/api/ticker/?id=%d", i);
            CryptoDTO[] currencies = restTemplate.getForObject(url, CryptoDTO[].class);
            CryptoCurrency cryptoCurrency = cryptoCurrencyMapper.convertToCurrency(currencies[0]);
            cryptoCurrencyService.save(cryptoCurrency);
        }
        controllingPrice.checkPrice();

    }
}
