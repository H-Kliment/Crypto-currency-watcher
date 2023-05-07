package com.cryptoWatcher.repository;

import com.cryptoWatcher.model.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCurrencyRepository extends JpaRepository<CryptoCurrency, Long> {

    CryptoCurrency findFirstBySymbolOrderByTimeOfCheckDesc(String symbol); //Method to get actual information of currency's value
}
