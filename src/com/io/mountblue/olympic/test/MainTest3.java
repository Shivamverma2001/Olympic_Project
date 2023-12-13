package com.io.mountblue.olympic.test;

import com.io.mountblue.olympic.Athlete;
import com.io.mountblue.olympic.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest3 {
    @Test
    public void numberOfGoldSilverBronzeEventWiseIn1980Test(){
        Athlete athlete1 = new Athlete();
        athlete1.setName("Shivam");
        athlete1.setYear("1980");
        athlete1.setMedal("Gold");

        Athlete athlete2 = new Athlete();
        athlete2.setName("Shivam");
        athlete2.setYear("1980");
        athlete2.setMedal("Silver");

        Athlete athlete3 = new Athlete();
        athlete3.setName("Shivam");
        athlete3.setYear("1980");
        athlete3.setMedal("Silver");

        Athlete athlete4 = new Athlete();
        athlete4.setName("Shivaay");
        athlete4.setYear("1980");
        athlete4.setMedal("Gold");

        Athlete athlete5 = new Athlete();
        athlete5.setName("Shivaay");
        athlete5.setYear("1980");
        athlete5.setMedal("Gold");

        Athlete athlete6 = new Athlete();
        athlete6.setName("Shivank");
        athlete6.setYear("1981");
        athlete6.setMedal("Gold");

        List<Athlete> athletes = Arrays.asList(athlete1, athlete2, athlete3, athlete4, athlete5, athlete6);

        HashMap<String,List<Integer>> result= Main.findNumberOfGoldSilverBronzeEventWiseIn1980(athletes);

        assertEquals(1,result.get("Shivam").get(0));
        assertEquals(2,result.get("Shivam").get(1));
        assertEquals(0,result.get("Shivam").get(2));
        assertEquals(2,result.get("Shivaay").get(0));
        assertNull(result.get("Shivank"));
    }
}
