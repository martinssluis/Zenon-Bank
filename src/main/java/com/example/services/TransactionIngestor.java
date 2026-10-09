package com.example.services;

import com.example.dto.CustomerDTO;
import com.example.dto.TransactionDTO;
import com.example.enums.TransactionType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {

    public static List<TransactionDTO> readTransactions(Path fileName)throws Exception{
        List<TransactionDTO> transactions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName.toFile()))) {

            int counter=0;
            String firstLine = bufferedReader.readLine();
            String line;

            while((line = bufferedReader.readLine()) !=null && counter < 1000){
                String[] object= line.split(",");
                transactions.add(new TransactionDTO(
                        Integer.parseInt(object[0]),
                        TransactionType.valueOf(object[1].trim().toUpperCase()),
                        new BigDecimal(object[2]),
                        new CustomerDTO(
                                object[3],
                                new BigDecimal(object[4]),
                                new BigDecimal(object[5])
                        ),
                        new CustomerDTO(
                                object[6],
                                new BigDecimal(object[7]),
                                new BigDecimal(object[8])
                        ),
                        "1".equals(object[9].trim()),
                        "1".equals(object[10].trim())
                ));
                counter++;
                transactions.subList(0, Math.min(10, transactions.size())).forEach(System.out::println);
            }

        }catch (NullPointerException exception){
            throw new RuntimeException("The file could not be found");
        }
        return transactions;

    }
}
