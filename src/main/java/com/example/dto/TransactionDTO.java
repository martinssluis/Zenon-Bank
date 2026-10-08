package com.example.dto;

import com.example.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionDTO(
         Integer step,
         TransactionType type,
         BigDecimal amount,

         CustomerDTO origin,
         CustomerDTO recipient,

         Boolean isFraud,
         Boolean isFlaggedFraud
){}