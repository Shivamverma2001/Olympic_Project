package com.io.mountblue.olympic.test;

import com.io.mountblue.olympic.Athlete;
import com.io.mountblue.olympic.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest4 {
    @Test
    public void footbalGoldWinnerOfEveryOlympicTest(){
        Athlete athlete1 = new Athlete();
        athlete1.setName("Shivam");
        athlete1.setYear("1980");
        athlete1.setMedal("Gold");
        athlete1.setSport("Football");

        Athlete athlete2 = new Athlete();
        athlete2.setName("Shivaay");
        athlete2.setYear("1980");
        athlete2.setMedal("Gold");
        athlete2.setSport("Football");

        Athlete athlete3 = new Athlete();
        athlete3.setName("Himanshu");
        athlete3.setYear("1984");
        athlete3.setMedal("Gold");
        athlete3.setSport("Football");

        Athlete athlete4 = new Athlete();
        athlete4.setName("Gorav");
        athlete4.setYear("1984");
        athlete4.setMedal("Silver");
        athlete4.setSport("Football");

        Athlete athlete5 = new Athlete();
        athlete5.setName("Piyush");
        athlete5.setYear("1988");
        athlete5.setMedal("Gold");
        athlete5.setSport("Football");

        Athlete athlete6 = new Athlete();
        athlete6.setName("Gorav");
        athlete6.setYear("1986");
        athlete6.setMedal("Silver");
        athlete6.setSport("Football");

        List<Athlete> athletes = Arrays.asList(athlete1, athlete2, athlete3, athlete4, athlete5);

        Map<String, List<String>> result = Main.findFootbalGoldWinnerOfEveryOlympic(athletes);

        assertEquals(Arrays.asList("Shivam", "Shivaay"), result.get("1980"));
        assertEquals(Arrays.asList("Himanshu"), result.get("1984"));
        assertEquals(Arrays.asList("Piyush"), result.get("1988"));
        assertNull(result.get("1986"));
    }
}
