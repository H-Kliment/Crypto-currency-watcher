package com.cryptoWatcher.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@EnableConfigurationProperties(CryptoCurrencyConfiguration.class)
@ConfigurationProperties(prefix = "crypto-currency")
public class CryptoCurrencyConfiguration {
    private int[] id;
    private String[] symbols;
}
