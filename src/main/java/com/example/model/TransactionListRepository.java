package com.example.model;

import com.example.dto.TransactionDTO;

import java.util.List;
import java.util.Optional;

public class TransactionListRepository {

    public  Optional<TransactionDTO> getTransactionByOriginClientName(List<TransactionDTO> transactions,
                                                                      String originClientName){

        return transactions.stream()
                .filter(transactionDTO -> transactionDTO.origin().name().equals(originClientName))
                .findFirst();
    };
}
