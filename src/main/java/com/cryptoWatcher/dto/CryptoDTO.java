package com.cryptoWatcher.dto;

import com.cryptoWatcher.model.CryptoCurrency;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class CryptoDTO {

    private int id;
    private String symbol;
    private String name;
    private double price_usd;
    private Calendar timeOfCheck;
}
