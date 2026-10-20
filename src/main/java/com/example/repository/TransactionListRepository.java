package com.example.repository;

import com.example.dto.TransactionDTO;

import java.util.List;
import java.util.Optional;

public interface TransactionListRepository {
    Optional<TransactionDTO> getTransactionByOriginClientName(List<TransactionDTO> transactions,
                                                                             String originClientName);
}
