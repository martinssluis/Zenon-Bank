package com.example.dto;

import java.math.BigDecimal;

public record CustomerDTO (
         String name,
         BigDecimal oldBalance,
         BigDecimal newBalance

){}
