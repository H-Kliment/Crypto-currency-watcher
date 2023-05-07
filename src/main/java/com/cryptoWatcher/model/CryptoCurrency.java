package com.cryptoWatcher.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "crypto_currency")
public class CryptoCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int currencyId;
    @NotNull
    private String symbol;
    @NotNull
    private String name;
    @NotNull
    private double price_usd;
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Calendar timeOfCheck;

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice_usd(double price_usd) {
        this.price_usd = price_usd;
    }

    public void setTimeOfCheck(Calendar timeOfCheck) {
        this.timeOfCheck = timeOfCheck;
    }
}
