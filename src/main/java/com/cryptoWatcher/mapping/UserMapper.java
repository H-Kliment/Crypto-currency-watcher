package com.cryptoWatcher.mapping;

import com.cryptoWatcher.dto.UserDTO;
import com.cryptoWatcher.model.User;
import com.cryptoWatcher.service.CryptoCurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final CryptoCurrencyService cryptoCurrencyService;

    public User convertToUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setCryptoCurrency(cryptoCurrencyService.findBySymbol(userDTO.getSymbol()));
        return user;
    }
}
