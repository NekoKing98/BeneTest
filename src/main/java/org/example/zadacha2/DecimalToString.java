package org.example.zadacha2;

import java.math.BigDecimal;


public class DecimalToString {

    private static final String[][] ONES = {
            {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"}
    };

    private static final String[] ONE_TENS = {
            "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    };

    private static final String[] TENS = {
            "", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят",
            "восемьдесят", "девяносто"
    };

    private static final String[] HUNDREDS = {
            "", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот",
            "восемьсот", "девятьсот"
    };

    private static final String[][] FORMS = {
            {"", "тысяча", "тысячи", "тысяч"},
            {"", " рубль ", " рубля ", " рублей "},
            {"", " копейка", " копейки", " копеек"}
    };

    public String convert(int n) {
        if (n == 0) {
            return "ноль";
        }
        if (n < 10) {
            return ONES[0][n];
        }
        if (n < 20) {
            return ONE_TENS[n % 10];
        }
        if (n < 100) {
            return TENS[n / 10] + " " + ONES[0][n % 10];
        }
        if (n < 1000) {
            if (n % 100 < 10 || n % 100 >= 20) {
                return HUNDREDS[n / 100] + " " + TENS[n / 10 % 10] + " " + ONES[0][n % 10];
            } else {
                return HUNDREDS[n / 100] + " " + TENS[n / 10 % 10] + " " + ONE_TENS[n % 10];
            }
        }
        if (n < 10000) {
            if (n % 100 < 10 || n % 100 >= 20) {
                return ONES[1][n / 1000] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONES[0][n % 10];
            } else {
                return ONES[1][n / 1000] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONE_TENS[n % 10];
            }
        }
        if (n < 100000) {
            if (n / 1000 < 20) {
                if (n % 100 < 10 || n % 100 >= 20) {
                    return ONE_TENS[n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONES[0][n % 10];
                } else {
                    return ONE_TENS[n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONE_TENS[n % 10];
                }
            } else {
                if (n % 100 < 10 || n % 100 >= 20) {
                    return TENS[n / 10000] + " " + ONES[1][n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONES[0][n % 10];
                } else {
                    return TENS[n / 10000] + " " + ONES[1][n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONE_TENS[n % 10];
                }
            }
        }

        if (n < 1000000) {
            if (n / 1000 % 100 >= 10 && n / 1000 % 100 < 20) {
                if (n % 100 < 10 || n % 100 >= 20) {
                    return HUNDREDS[n / 100000] + " " + ONE_TENS[n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONES[0][n % 10];
                } else {
                    return HUNDREDS[n / 100000] + " " + ONE_TENS[n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONE_TENS[n % 10];
                }
            } else if (n / 1000 % 100 < 10 || n / 1000 % 100 >= 20) {
                if (n % 100 < 10 || n % 100 >= 20) {
                    return HUNDREDS[n / 100000] + " " + TENS[n / 10000 % 10] + " " + ONES[1][n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONES[0][n % 10];
                } else {
                    return HUNDREDS[n / 100000] + " " + TENS[n / 10000 % 10] + " " + ONES[1][n / 1000 % 10] + " " + thousands(n / 1000) + " " + HUNDREDS[n / 100 % 10] + " " + TENS[n / 10 % 10] + " " + ONE_TENS[n % 10];
                }
            }
        }
        return "";
    }

    public String getForm(String[] form, int n) {
        if (n % 100 >= 5 && n % 100 <= 20) {
            return form[3];
        }
        if (n % 10 >= 2 && n % 10 <= 4) {
            return form[2];
        }
        if (n % 10 == 1) {
            return form[1];
        } else return form[3];
    }

    public String thousands(int n) {
        return getForm(FORMS[0], n);
    }

    public String rub(int n) {
        return getForm(FORMS[1], n);
    }

    public String cop(int n) {
        return getForm(FORMS[2], n);
    }

    public String convertBigDecimalToWords(BigDecimal cost) {
        StringBuilder resultBuilder = new StringBuilder();
        String resultString;
        int integerPart = cost.intValue();
        int decimalPart = cost.remainder(BigDecimal.ONE).movePointRight(2).intValue();

        resultBuilder.append(convert(integerPart)).append(rub(integerPart)).append(decimalPart < 10 ? "0" + decimalPart : decimalPart).append(cop(decimalPart));
        resultString = resultBuilder.toString().replaceAll("\\s+", " ");
        return resultString.substring(0, 1).toUpperCase() + resultString.substring(1);
    }
}




