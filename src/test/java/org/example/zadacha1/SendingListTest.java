package org.example.zadacha1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
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
    public void testNearDate1() throws IOException {
        LocalDateTime test1 = LocalDateTime.of(2024, 3, 6, 18, 0);
        LocalDateTime ans1 = LocalDateTime.of(2024, 3, 11, 18, 0);
        assertEquals(ans1, sendingList.nearDate(test1));
    }
    @Test
    public void testNearDate2() throws IOException {
        LocalDateTime test2 = LocalDateTime.of(2024, 3, 10, 18, 0);
        LocalDateTime ans2 = LocalDateTime.of(2024, 3, 11, 18, 0);
        assertEquals(ans2, sendingList.nearDate(test2));
    }

    @Test
    public void testNearDate3() throws IOException {
        LocalDateTime test3 = LocalDateTime.of(2024, 3, 11, 18, 1);
        LocalDateTime ans3 = LocalDateTime.of(2024, 3, 20, 18, 0);
        assertEquals(ans3, sendingList.nearDate(test3));
    }

    @Test
    public void testNearDate4() throws IOException {
        LocalDateTime test4 = LocalDateTime.of(2024, 5, 7, 18, 0);
        LocalDateTime ans4 = LocalDateTime.of(2024, 5, 8, 18, 0);
        assertEquals(ans4, sendingList.nearDate(test4));
    }

    @Test
    public void testNearDate5() throws IOException {
        LocalDateTime test5 = LocalDateTime.of(2024, 4, 10, 17, 0);
        LocalDateTime ans5 = LocalDateTime.of(2024, 4, 10, 18, 0);
        assertEquals(ans5, sendingList.nearDate(test5));
    }

    @Test
    public void testNearDate6() throws IOException {
        LocalDateTime test6 = LocalDateTime.of(2023, 12, 21, 18, 0);
        LocalDateTime ans6 = LocalDateTime.of(2023, 12, 29, 18, 0);
        assertEquals(ans6, sendingList.nearDate(test6));
    }

    @Test
    public void testNearDate7() throws IOException {
        LocalDateTime test7 = LocalDateTime.of(2024, 5, 22, 18, 0);
        LocalDateTime ans7 = LocalDateTime.of(2024, 6, 3, 18, 0);
        assertEquals(ans7, sendingList.nearDate(test7));
    }

    @Test
    public void testNearDate8() throws IOException {
        LocalDateTime test8 = LocalDateTime.of(2024, 4, 17, 18, 0);
        LocalDateTime ans8 = LocalDateTime.of(2024, 4, 22, 18, 0);
        assertEquals(ans8, sendingList.nearDate(test8));
    }
}
