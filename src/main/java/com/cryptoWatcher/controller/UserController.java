package com.cryptoWatcher.controller;

import com.cryptoWatcher.configuration.CryptoCurrencyConfiguration;
import com.cryptoWatcher.dto.UserDTO;
import com.cryptoWatcher.mapping.UserMapper;
import com.cryptoWatcher.model.User;
import com.cryptoWatcher.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crypto-currency/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final CryptoCurrencyConfiguration cryptoCurrencyConfiguration;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registration(@RequestBody UserDTO userDTO) {
        if (Arrays.stream(cryptoCurrencyConfiguration.getSymbols()).anyMatch(s -> s.equals(userDTO.getSymbol()))) {
            User user = userMapper.convertToUser(userDTO);
            userService.save(user);
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
