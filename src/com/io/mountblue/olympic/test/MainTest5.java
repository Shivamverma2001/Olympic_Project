package com.io.mountblue.olympic.test;

import com.io.mountblue.olympic.Athlete;
import com.io.mountblue.olympic.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest5 {
    @Test
    public void testFindFemaleAtheleteWonMaxNumberOfGoldInAllOlympic() {
        Athlete athlete1 = new Athlete();
        athlete1.setName("Anagha");
        athlete1.setSex("F");
        athlete1.setMedal("Gold");

        Athlete athlete2 = new Athlete();
        athlete2.setName("Anagha");
        athlete2.setSex("F");
        athlete2.setMedal("Gold");

        Athlete athlete3 = new Athlete();
        athlete3.setName("Maneesha");
        athlete3.setSex("F");
        athlete3.setMedal("Silver");

        Athlete athlete4 = new Athlete();
        athlete4.setName("Maneesha");
        athlete4.setSex("M");
        athlete4.setMedal("Gold");

        Athlete athlete5 = new Athlete();
        athlete5.setName("Maneesha");
        athlete5.setSex("F");
        athlete5.setMedal("Gold");

        Athlete athlete6 = new Athlete();
        athlete6.setName("Shivam");
        athlete6.setSex("M");
        athlete6.setMedal("Gold");

        Athlete athlete7 = new Athlete();
        athlete7.setName("Anagha");
        athlete7.setSex("F");
        athlete7.setMedal("Gold");

        List<Athlete> athletes = Arrays.asList(athlete1, athlete2, athlete3, athlete4, athlete5,athlete6,athlete7);

        String result = Main.findFemaleAtheleteWonMaxNumberOfGoldInAllOlympic(athletes);

        assertEquals("Anagha", result);
    }
}
