package com.io.mountblue.olympic.test;

import com.io.mountblue.olympic.Athlete;
import com.io.mountblue.olympic.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest6 {
    @Test
    public void testFindNameOfAthleteParticipatedInMoreThanThreeOlympics() {
        Athlete athlete1 = new Athlete();
        athlete1.setName("Shivam");
        athlete1.setSex("M");
        athlete1.setMedal("Gold");
        athlete1.setYear("1980");

        Athlete athlete2 = new Athlete();
        athlete2.setName("Shivam");
        athlete2.setSex("M");
        athlete2.setMedal("Silver");
        athlete2.setYear("1980");

        Athlete athlete3 = new Athlete();
        athlete3.setName("Shivam");
        athlete3.setSex("M");
        athlete3.setMedal("Bronze");
        athlete3.setYear("1984");

        Athlete athlete4 = new Athlete();
        athlete4.setName("Shivam");
        athlete4.setSex("M");
        athlete4.setMedal("Gold");
        athlete4.setYear("1984");

        Athlete athlete5 = new Athlete();
        athlete5.setName("Aviral");
        athlete5.setSex("M");
        athlete5.setMedal("Gold");
        athlete5.setYear("1988");

        Athlete athlete6 = new Athlete();
        athlete6.setName("Aviral");
        athlete6.setSex("M");
        athlete6.setMedal("Gold");
        athlete6.setYear("1988");

        Athlete athlete7 = new Athlete();
        athlete7.setName("Aviral");
        athlete7.setSex("M");
        athlete7.setMedal("Gold");
        athlete7.setYear("1988");

        Athlete athlete8 = new Athlete();
        athlete8.setName("Aviral");
        athlete8.setSex("M");
        athlete8.setMedal("Gold");
        athlete8.setYear("1988");

        Athlete athlete9 = new Athlete();
        athlete9.setName("Praful");
        athlete9.setSex("M");
        athlete9.setMedal("Gold");
        athlete9.setYear("1988");

        List<Athlete> athletes = Arrays.
                asList(athlete1, athlete2, athlete3, athlete4, athlete5,athlete6, athlete7, athlete8,athlete9);

        List<String> result = Main.findNameOfAthleteParticipatedInMoreThanThreeOlympics(athletes);

        assertEquals(Arrays.asList("Aviral","Shivam"), result);
    }
}
