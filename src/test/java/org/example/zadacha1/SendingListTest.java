package org.example.zadacha1;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SendingListTest {

    private org.example.zadacha1.SendingList sendingList;

    @BeforeEach
    public void setUp(){
        sendingList = new SendingList();
    }

    @Test
    public void testNearDate1(){
        LocalDateTime test = LocalDateTime.of(2024, 3, 6, 18, 0);
        LocalDateTime ans = LocalDateTime.of(2024, 3, 11, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }
    @Test
    public void testNearDate2(){
        LocalDateTime test = LocalDateTime.of(2024, 3, 10, 18, 0);
        LocalDateTime ans = LocalDateTime.of(2024, 3, 11, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }

    @Test
    public void testNearDate3(){
        LocalDateTime test = LocalDateTime.of(2024, 3, 11, 18, 1);
        LocalDateTime ans = LocalDateTime.of(2024, 3, 20, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }

    @Test
    public void testNearDate4(){
        LocalDateTime test = LocalDateTime.of(2024, 5, 7, 18, 0);
        LocalDateTime ans = LocalDateTime.of(2024, 5, 8, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }

    @Test
    public void testNearDate5(){
        LocalDateTime test = LocalDateTime.of(2024, 4, 10, 17, 0);
        LocalDateTime ans = LocalDateTime.of(2024, 4, 10, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }

    @Test
    public void testNearDate6(){
        LocalDateTime test = LocalDateTime.of(2023, 12, 21, 18, 0);
        LocalDateTime ans = LocalDateTime.of(2023, 12, 29, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }

    @Test
    public void testNearDate7(){
        LocalDateTime test = LocalDateTime.of(2024, 5, 22, 18, 0);
        LocalDateTime ans = LocalDateTime.of(2024, 6, 3, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }

    @Test
    public void testNearDate8(){
        LocalDateTime test = LocalDateTime.of(2024, 4, 17, 18, 0);
        LocalDateTime ans = LocalDateTime.of(2024, 4, 22, 18, 0);
        assertEquals(ans, sendingList.nearDate(test));
    }
}
