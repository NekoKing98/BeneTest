package org.example.zadacha1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class SendingList {

    private static final LocalTime WORKING_TIME = LocalTime.of(18, 0, 0);
    private static final int[] WORKING_DAY = {1, 10, 20};
    private static final String BASE_URL = "https://calendar.kuzyak.in/api/calendar/";

    private boolean isWorking;
    private boolean isHoliday;

    public LocalDateTime nearDate(LocalDateTime dateTime) {
        checkDate(dateTime);
        for (int checkDay : WORKING_DAY) {
            if (dateTime.getDayOfMonth() == checkDay) {
                if (dateTime.toLocalTime().isBefore(WORKING_TIME))
                    return worker(dateTime);
            }

            if (dateTime.getDayOfMonth() <= checkDay) {
                LocalDateTime checkDate = dateTime.plusDays(checkDay - dateTime.getDayOfMonth());
                checkDate(checkDate);
                if (!isWorking && isHoliday) {
                    while (!isWorking) {
                        checkDate = checkDate.minusDays(1);
                        checkDate(checkDate);
                    }
                    return worker(checkDate);
                } else if (!isWorking) {
                    while (!isWorking && !isHoliday) {
                        checkDate = checkDate.plusDays(1);
                        checkDate(checkDate);
                    }
                    return worker(checkDate);
                } else return worker(checkDate);
            }

            if (dateTime.getDayOfMonth() >= Arrays.stream(WORKING_DAY).max().getAsInt()) {
                LocalDateTime checkDate = dateTime.withDayOfMonth(1).plusMonths(1);
                checkDate(checkDate);
                if (!isWorking && isHoliday) {
                    while (!isWorking) {
                        checkDate = checkDate.minusDays(1);
                        checkDate(checkDate);
                    }
                    return worker(checkDate);
                } else if (!isWorking) {
                    while (!isWorking && !isHoliday) {
                        checkDate = checkDate.plusDays(1);
                        checkDate(checkDate);
                    }
                    return worker(checkDate);
                } else return worker(checkDate);
            }

        }
        return worker(dateTime);
    }

    public LocalDateTime worker(LocalDateTime dateTime) {
        return dateTime.withHour(WORKING_TIME.getHour())
                .withMinute(WORKING_TIME.getMinute())
                .withSecond(WORKING_TIME.getSecond())
                .withNano(WORKING_TIME.getNano());
    }

    public void checkDate(LocalDateTime dateTime) {
        String url = BASE_URL + dateTime.getYear() + "/" + (dateTime.getMonthValue()) + "/" + dateTime.getDayOfMonth();
        HttpURLConnection connection = null;
        BufferedReader in = null;

        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            if (connection.getResponseCode() == 200) {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String content = in.readLine();
                isHoliday = content.contains("\"holiday\"") && !content.contains("\"isShortDay\"");
                isWorking = content.contains("\"isWorkingDay\":true");
            } else {
                System.out.println("Ошибка при загрузке данных: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода: " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("Ошибка при закрытии BufferedReader: " + e.getMessage());
            }

            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
