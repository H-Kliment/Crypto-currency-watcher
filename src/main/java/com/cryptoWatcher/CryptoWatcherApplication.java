package com.cryptoWatcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.cryptoWatcher.repository")
public class CryptoWatcherApplication {

	public static final Logger LOGGER = LogManager.getLogger(CryptoWatcherApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CryptoWatcherApplication.class, args);
	}

}
