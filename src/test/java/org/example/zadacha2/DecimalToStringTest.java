package org.example.zadacha2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class DecimalToStringTest {

    private org.example.zadacha2.DecimalToString decimalToString;

    @BeforeEach
    public void SetUp() {
        decimalToString = new DecimalToString();
    }

    @Test
    public void convertBigDecimalToWords1() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("999999.99"));
        String ans = "Девятьсот девяносто девять тысяч девятьсот девяносто девять рублей 99 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords2() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("121121"));
        String ans = "Сто двадцать одна тысяча сто двадцать один рубль 00 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords3() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("532532.32"));
        String ans = "Пятьсот тридцать две тысячи пятьсот тридцать два рубля 32 копейки";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords4() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("500000.50"));
        String ans = "Пятьсот тысяч рублей 50 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords5() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("123456"));
        String ans = "Сто двадцать три тысячи четыреста пятьдесят шесть рублей 00 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords6() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("987654.21"));
        String ans = "Девятьсот восемьдесят семь тысяч шестьсот пятьдесят четыре рубля 21 копейка";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords7() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("111111"));
        String ans = "Сто одиннадцать тысяч сто одиннадцать рублей 00 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords8() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("765432.98"));
        String ans = "Семьсот шестьдесят пять тысяч четыреста тридцать два рубля 98 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords9() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("900000.75"));
        String ans = "Девятьсот тысяч рублей 75 копеек";
        assertEquals(test, ans);
    }

    @Test
    public void convertBigDecimalToWords10() {
        String test = decimalToString.convertBigDecimalToWords(new BigDecimal("421234.56"));
        String ans = "Четыреста двадцать одна тысяча двести тридцать четыре рубля 56 копеек";
        assertEquals(test, ans);
    }

}
