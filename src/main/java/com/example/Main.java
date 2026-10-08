package com.example;

import com.example.dto.CustomerDTO;
import com.example.dto.TransactionDTO;
import com.example.enums.TransactionType;

import java.math.BigDecimal;


public class Main {
    static void main() {

        var transaction1 = new TransactionDTO(1, TransactionType.PAYMENT, new BigDecimal("1864.28"),
                new CustomerDTO("C1666544295", new BigDecimal("21249.0"), new BigDecimal("19384.72")),
                new CustomerDTO("M2044282225", new BigDecimal("0.0"), new BigDecimal("0.0")),
                false, false);


        var transaction2 = new TransactionDTO(1, TransactionType.TRANSFER, new BigDecimal("181.0"),
                new CustomerDTO("C1305486145", new BigDecimal("181.0"), new BigDecimal("0.0")),
                new CustomerDTO("C553264065", new BigDecimal("0.0"), new BigDecimal("0.0")),
                true, false);

        IO.println(transaction1);
        IO.println(transaction2);
    }
}
