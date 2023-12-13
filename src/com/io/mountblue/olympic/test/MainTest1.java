package com.io.mountblue.olympic.test;

import com.io.mountblue.olympic.Athlete;
import com.io.mountblue.olympic.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest1 {
    @Test
    public void numberOfGoldMedalsWonByEachPlayerYearlyTest(){
        Athlete athlete1=new Athlete();
        athlete1.setName("Shivam");
        athlete1.setYear("2018");
        athlete1.setMedal("Gold");

        Athlete athlete2=new Athlete();
        athlete2.setName("Shivam");
        athlete2.setYear("2018");
        athlete2.setMedal("Gold");

        Athlete athlete3=new Athlete();
        athlete3.setName("Kartik");
        athlete3.setYear("2017");
        athlete3.setMedal("Silver");

        Athlete athlete4=new Athlete();
        athlete4.setName("Shivam");
        athlete4.setYear("2017");
        athlete4.setMedal("Gold");

        Athlete athlete5=new Athlete();
        athlete5.setName("Kartik");
        athlete5.setYear("2018");
        athlete5.setMedal("Gold");

        List<Athlete> athletes= Arrays.asList(athlete1,athlete2,athlete3,athlete4,athlete5);

        HashMap<String,Integer> result= Main.findNumberOfGoldMedalsWonByEachPlayerYearly(athletes);

        assertEquals(2,result.get("Shivam-2018"));
        assertEquals(1,result.get("Shivam-2017"));
        assertEquals(1,result.get("Kartik-2018"));
        assertNull(result.get("Kartik-2017"));
    }
}