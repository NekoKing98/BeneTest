package org.example.zadacha1;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        SendingList sendingList = new SendingList();
        System.out.println(sendingList.nearDate(LocalDateTime.now()));
    }
}