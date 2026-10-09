package com.example;

import com.example.dto.CustomerDTO;
import com.example.dto.TransactionDTO;
import com.example.enums.TransactionType;
import com.example.services.TransactionIngestor;

import java.math.BigDecimal;
import java.nio.file.Path;

import static com.example.services.TransactionIngestor.transactions;


public class Main {
    static void main() throws Exception {

        var transaction1 = new TransactionDTO(1, TransactionType.PAYMENT, new BigDecimal("1864.28"),
                new CustomerDTO("C1666544295", new BigDecimal("21249.0"), new BigDecimal("19384.72")),
                new CustomerDTO("M2044282225", new BigDecimal("0.0"), new BigDecimal("0.0")),
                false, false);


        var transaction2 = new TransactionDTO(1, TransactionType.TRANSFER, new BigDecimal("181.0"),
                new CustomerDTO("C1305486145", new BigDecimal("181.0"), new BigDecimal("0.0")),
                new CustomerDTO("C553264065", new BigDecimal("0.0"), new BigDecimal("0.0")),
                true, false);

//        IO.println(transaction1);
//        IO.println(transaction2);

        var firtThousandLines = TransactionIngestor.readTransactions(Path.of("data", "PS_20174392719_1491204439457_log.csv"));
        transactions.subList(0, Math.min(10, transactions.size())).forEach(System.out::println);

    }
}
