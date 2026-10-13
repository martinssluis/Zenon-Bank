package com.example.services;

import com.example.dto.CustomerDTO;
import com.example.dto.TransactionDTO;
import com.example.enums.TransactionType;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TransactionIngestor {

    public List<TransactionDTO> readTransactions(String fileName) {
        Path path = Path.of(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
            return lines.stream()
                    .skip(1)
                    .limit(1000)
                    .map(this::parseTransaction)
                    .toList();

        } catch (Exception exception) {
            throw new RuntimeException("The file could not be found: " + fileName, exception);
        }
    }

    private  TransactionDTO parseTransaction(String line) {
        String[] chunks = line.split(",");

        int step = Integer.parseInt(chunks[0]);
        TransactionType type = TransactionType.valueOf(chunks[1]);

        BigDecimal amount = new BigDecimal(chunks[2]);

        var origin = new CustomerDTO(chunks[3], new BigDecimal(chunks[4]), new BigDecimal(chunks[5]));
        var recipient = new CustomerDTO(chunks[6], new BigDecimal(chunks[7]), new BigDecimal(chunks[8]));

        boolean isFraud = "1".equals(chunks[9]);
        boolean isFlaggedFraud = "1".equals(chunks[10]);

        return new TransactionDTO(step, type, amount, origin, recipient, isFraud, isFlaggedFraud);
    }
}
