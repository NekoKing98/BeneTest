package org.example.zadacha2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("900000.75");
        DecimalToString decimalToString = new DecimalToString();
        System.out.println(decimalToString.convertBigDecimalToWords(decimal));
    }
}
