package com.example.services;


import com.example.dto.TransactionDTO;

import java.util.Comparator;
import java.util.List;

public class FraudAnalyzer {


    public static List<TransactionDTO> analyzeFrauds(List<TransactionDTO> transactions) {
        return transactions.stream()
                .filter(TransactionDTO::isFraud)
                .toList();
    }

    public static List<TransactionDTO> biggestFrauds(List<TransactionDTO> fraudeulentTransactions) {
        return fraudeulentTransactions.stream()
                .sorted(Comparator.comparing(TransactionDTO::amount).reversed())
                .limit(3)
                .toList();
    }
}
