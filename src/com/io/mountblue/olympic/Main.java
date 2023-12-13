package com.io.mountblue.olympic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static String ATHLETE_FILE_PATH="data/athlete_events.csv";
    public static int ATHLETE_ID=0;
    public static int ATHLETE_NAME=1;
    public static int ATHLETE_SEX=2;
    public static int ATHLETE_AGE=3;
    public static int ATHLETE_HEIGHT=4;
    public static int ATHLETE_WEIGHT=5;
    public static int ATHLETE_TEAM=6;
    public static int ATHLETE_NOC=7;
    public static int ATHLETE_GAMES=8;
    public static int ATHLETE_YEAR=9;
    public static int ATHLETE_SEASON=10;
    public static int ATHLETE_CITY=11;
    public static int ATHLETE_SPORT=12;
    public static int ATHLETE_EVENT=13;
    public static int ATHLETE_MEDAL=14;

    public static void main(String[] args) {
        List<Athlete> athletes=getAtheleteData();

        findNumberOfGoldMedalsWonByEachPlayerYearly(athletes);
        findAthleteWonGoldMedalIn1980AndAgeLessThan30(athletes);
        findNumberOfGoldSilverBronzeEventWiseIn1980(athletes);
        findFootbalGoldWinnerOfEveryOlympic(athletes);
        findFemaleAtheleteWonMaxNumberOfGoldInAllOlympic(athletes);
        findNameOfAthleteParticipatedInMoreThanThreeOlympics(athletes);
    }

    public static List<String> findNameOfAthleteParticipatedInMoreThanThreeOlympics(List<Athlete> athletes) {
        HashMap<String,Integer> numberOfTimesAthletesParticipatedInOlympics=new HashMap<>();
        List<String> playerNames=new ArrayList<>();
        for (Athlete athlete:athletes){
            numberOfTimesAthletesParticipatedInOlympics.put(athlete.getName(),
                    numberOfTimesAthletesParticipatedInOlympics.getOrDefault(athlete.getName(),0)+1);
        }

        for (Map.Entry<String,Integer> athleteParticipatedInOlympics:
                numberOfTimesAthletesParticipatedInOlympics.entrySet()){

            if(athleteParticipatedInOlympics.getValue()>3){
                System.out.println(athleteParticipatedInOlympics.getKey());

                playerNames.add(athleteParticipatedInOlympics.getKey());
            }
        }

        return playerNames;
    }

    public static String findFemaleAtheleteWonMaxNumberOfGoldInAllOlympic(List<Athlete> athletes) {
        HashMap<String,Integer> femalesWonGoldInAllOlympics=new HashMap<>();

        for (Athlete athlete:athletes){
            if(athlete.getSex().equals("F")){
                femalesWonGoldInAllOlympics.put(athlete.getName(),
                        femalesWonGoldInAllOlympics.getOrDefault(athlete.getName(),0)+1);
            }
        }

        int numberOfGolds=0;
        String femaleAthleteName=null;

        for(Map.Entry<String,Integer> femaleWonGold:femalesWonGoldInAllOlympics.entrySet()){
            if(femaleWonGold.getValue()>numberOfGolds){
                numberOfGolds=femaleWonGold.getValue();
                femaleAthleteName=femaleWonGold.getKey();
            }
        }

        System.out.println(femaleAthleteName+" "+numberOfGolds);

        return  femaleAthleteName;
    }

    public static Map<String, List<String>> findFootbalGoldWinnerOfEveryOlympic(List<Athlete> athletes) {
        Map<String, List<String>> goldWinnersOfEveryOlympic = new LinkedHashMap<>();

        for (Athlete athlete : athletes) {
            if (athlete.getMedal().equals("Gold") && athlete.getSport().equals("Football")) {
                goldWinnersOfEveryOlympic.computeIfAbsent(athlete.getYear(), k -> new ArrayList<>())
                        .add(athlete.getName());
            }
        }

        for (Map.Entry<String, List<String>> entry : goldWinnersOfEveryOlympic.entrySet()) {
            System.out.println(entry.getKey());
            for (String athleteName : entry.getValue()) {
                System.out.println(athleteName);
            }
        }

        return goldWinnersOfEveryOlympic;
    }

    public static HashMap<String, List<Integer>> findNumberOfGoldSilverBronzeEventWiseIn1980(List<Athlete> athletes) {
        HashMap<String, Integer> numberOfGoldsEventWise = new HashMap<>();
        HashMap<String, Integer> numberOfSilversEventWise = new HashMap<>();
        HashMap<String, Integer> numberOfBronzesEventWise = new HashMap<>();
        HashMap<String, List<Integer>> numberOfMedalsEventWise = new HashMap<>();

        for (Athlete athlete : athletes) {
            if (athlete.getYear().equals("1980")) {
                String athleteName = athlete.getName();
                int numberOfGoldMedals = numberOfGoldsEventWise.getOrDefault(athleteName, 0);
                int numberOfSilverMedals = numberOfSilversEventWise.getOrDefault(athleteName, 0);
                int numberOfBronzeMedals = numberOfBronzesEventWise.getOrDefault(athleteName, 0);

                if (athlete.getMedal().equals("Gold")) {
                    numberOfGoldsEventWise.put(athleteName, numberOfGoldMedals + 1);
                } else if (athlete.getMedal().equals("Silver")) {
                    numberOfSilversEventWise.put(athleteName, numberOfSilverMedals + 1);
                } else if (athlete.getMedal().equals("Bronze")) {
                    numberOfBronzesEventWise.put(athleteName, numberOfBronzeMedals + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> goldMedalWithEventName : numberOfGoldsEventWise.entrySet()) {
            List<Integer> medals = new ArrayList<>();
            medals.add(goldMedalWithEventName.getValue());
            medals.add(numberOfSilversEventWise.getOrDefault(goldMedalWithEventName.getKey(), 0));
            medals.add(numberOfBronzesEventWise.getOrDefault(goldMedalWithEventName.getKey(), 0));

            numberOfMedalsEventWise.put(goldMedalWithEventName.getKey(), medals);
        }

        for (Map.Entry<String, List<Integer>> entry : numberOfMedalsEventWise.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Gold: " + entry.getValue().get(0));
            System.out.println("Silver: " + entry.getValue().get(1));
            System.out.println("Bronze: " + entry.getValue().get(2));
            System.out.println();
        }

        return numberOfMedalsEventWise;
    }



    public static HashMap<String,Integer>  findAthleteWonGoldMedalIn1980AndAgeLessThan30(List<Athlete> athletes) {
        HashMap<String,Integer> athletesWonGoldMedal=new HashMap<>();

        for(Athlete athlete:athletes){
            if(athlete.getAge()!=null && !athlete.getAge().equals("NA") && Integer.parseInt(athlete.getAge())<30 &&
                    athlete.getYear().equals("1980") && athlete.getMedal().equals("Gold")){

                athletesWonGoldMedal.put(athlete.getName(),
                        athletesWonGoldMedal.getOrDefault(athlete.getName(),0)+1);
            }
        }

        for(Map.Entry<String,Integer> athleteWonGoldMedal:athletesWonGoldMedal.entrySet()){
            System.out.println(athleteWonGoldMedal.getKey()+" "+athleteWonGoldMedal.getValue());
        }

        return athletesWonGoldMedal;
    }

    public static HashMap<String, Integer> findNumberOfGoldMedalsWonByEachPlayerYearly(List<Athlete> athletes) {
        HashMap<String, Integer> numberOfGoldWonByPlayers = new HashMap<>();

        for (Athlete athlete : athletes) {
            if (athlete.getMedal().equals("Gold")) {
                String key = athlete.getName() + "-" + athlete.getYear();

                numberOfGoldWonByPlayers.put(key, numberOfGoldWonByPlayers.getOrDefault(key, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : numberOfGoldWonByPlayers.entrySet()) {
            String[] parts = entry.getKey().split("-");
            String playerName = parts[0];
            String year = parts[1];

            System.out.println("In " + year + ": " + playerName + " " + entry.getValue() + " gold medals");
        }

        return numberOfGoldWonByPlayers;
    }

    private static List<Athlete> getAtheleteData() {
        List<Athlete> athletes=new ArrayList<>();

        FileReader fileReader=null;
        BufferedReader reader=null;

        try{
            fileReader=new FileReader(ATHLETE_FILE_PATH);
            reader =new BufferedReader(fileReader);

            reader.readLine();

            String line;

            while ((line= reader.readLine())!=null){
                String[] data=customSplit(line);

                Athlete athlete=new Athlete();
                athlete.setId(data[ATHLETE_ID]);
                athlete.setName(data[ATHLETE_NAME]);
                athlete.setSex(data[ATHLETE_SEX]);
                athlete.setAge(data[ATHLETE_AGE]);
                athlete.setHeight(data[ATHLETE_HEIGHT]);
                athlete.setWeight(data[ATHLETE_WEIGHT]);
                athlete.setTeam(data[ATHLETE_TEAM]);
                athlete.setNoc(data[ATHLETE_NOC]);
                athlete.setGames(data[ATHLETE_GAMES]);
                athlete.setYear(data[ATHLETE_YEAR]);
                athlete.setSeason(data[ATHLETE_SEASON]);
                athlete.setCity(data[ATHLETE_CITY]);
                athlete.setSport(data[ATHLETE_SPORT]);
                athlete.setEvent(data[ATHLETE_EVENT]);
                athlete.setMedal(data[ATHLETE_MEDAL]);

                athletes.add(athlete);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return athletes;
    }

    public static String[] customSplit(String data) {
        ArrayList<String> columns = new ArrayList<>();
        StringBuilder currentColumn = new StringBuilder();
        boolean inQuotes = false;

        for (char c : data.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                columns.add(currentColumn.toString().replace("\"", "").trim());
                currentColumn.setLength(0);
            } else {
                currentColumn.append(c);
            }
        }

        columns.add(currentColumn.toString().replace("\"", "").trim());

        return columns.toArray(new String[0]);
    }
}