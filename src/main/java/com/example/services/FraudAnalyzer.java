package com.example.services;


import com.example.dto.TransactionDTO;
import java.util.List;

public class FraudAnalyzer {


    public static List<TransactionDTO> analyzeFrauds(List<TransactionDTO> transactions) {
        return transactions.stream()
                .filter(TransactionDTO::isFraud)
                .toList();
    }
}
