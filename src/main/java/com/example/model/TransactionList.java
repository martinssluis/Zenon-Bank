package com.example.model;

import com.example.dto.TransactionDTO;
import com.example.repository.TransactionListRepository;

import java.util.List;
import java.util.Optional;

public class TransactionList implements TransactionListRepository {

    @Override
    public  Optional<TransactionDTO> getTransactionByOriginClientName
            (List<TransactionDTO> transactions,String originClientName){

        return transactions.stream()
                .filter(transactionDTO -> transactionDTO.origin().name().equals(originClientName))
                .findFirst();
    };
}
