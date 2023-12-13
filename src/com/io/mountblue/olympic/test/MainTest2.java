package com.io.mountblue.olympic.test;

import com.io.mountblue.olympic.Athlete;
import com.io.mountblue.olympic.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest2 {
    @Test
    public void athleteWonGoldMedalIn1980AndAgeLessThan30Test(){
        Athlete athlete1=new Athlete();
        athlete1.setAge("29");
        athlete1.setName("Shivam");
        athlete1.setYear("1980");
        athlete1.setMedal("Gold");

        Athlete athlete2=new Athlete();
        athlete2.setAge("29");
        athlete2.setName("Shivam");
        athlete2.setYear("1980");
        athlete2.setMedal("Gold");

        Athlete athlete3=new Athlete();
        athlete3.setAge("25");
        athlete3.setName("Kartik");
        athlete3.setYear("1980");
        athlete3.setMedal("Silver");

        Athlete athlete4=new Athlete();
        athlete4.setAge("31");
        athlete4.setName("Shivaay");
        athlete4.setYear("1980");
        athlete4.setMedal("Gold");

        Athlete athlete5=new Athlete();
        athlete5.setAge("25");
        athlete5.setName("Kartik");
        athlete5.setYear("1981");
        athlete5.setMedal("Gold");

        List<Athlete> athletes= Arrays.asList(athlete1,athlete2,athlete3,athlete4,athlete5);

        HashMap<String,Integer> result= Main.findAthleteWonGoldMedalIn1980AndAgeLessThan30(athletes);

        assertEquals(2,result.get("Shivam"));
        assertNull(result.get("Kartik"));
        assertNull(result.get("Shivaay"));
    }
}
