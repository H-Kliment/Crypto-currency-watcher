package com.cryptoWatcher.utility;

import com.cryptoWatcher.CryptoWatcherApplication;
import com.cryptoWatcher.model.User;
import com.cryptoWatcher.service.CryptoCurrencyService;
import com.cryptoWatcher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ControllingPrice {

    private final UserService userService;
    private final CryptoCurrencyService cryptoCurrencyService;

    @Async
    public void checkPrice() {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return;
        }
        for (User user : users) {
            double changePercent = calculatePercentage(user.getCryptoCurrency().getPrice_usd(), cryptoCurrencyService.findBySymbol(user.getCryptoCurrency().getSymbol()).getPrice_usd());
            if (changePercent > 1) {
                CryptoWatcherApplication.LOGGER.warn(String.format("Symbol of currency: %s," +
                        " username : %s, percentage of changing price: %f", user.getCryptoCurrency().getSymbol(), user.getUsername(), changePercent));
            }
        }
    }

    private double calculatePercentage(double a, double b) {
        double percent = a / b * 100;
        double changePercent = 100 - percent; //calculation of the percentage of the price change in relation to the
        return changePercent;

    }
}
