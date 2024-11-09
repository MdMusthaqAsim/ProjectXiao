package org.genshin.controller;

import java.io.*;
import com.fasterxml.jackson.databind.*;

import java.util.*;

//gets all the uids from the 10 akasha api links and sends them to UidJsonFetcher
public class AkashaUidFetcher { //make this check the arraylist first

    public static void akashaListFileWriter(ArrayList<String> returnList){
        String text = returnList.toString();
        String path = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/currAkashaPages.txt";
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static ArrayList<String> returnAkashaListFromFile(){
        String akashaListString;
        ArrayList<String> newAkashaList = new ArrayList<>();
        try {
            BufferedReader a = new BufferedReader(new FileReader("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/currAkashaPages.txt"));
            akashaListString = a.readLine();
            String[] items = akashaListString.substring(1, akashaListString.length() - 1).split(", ");
            newAkashaList.addAll(Arrays.asList(items));
        } catch (IOException e) {
            System.err.println(e);
        }
        return newAkashaList;
    }

    public static Integer getPageNumber(String link){
        String li=link.substring(81);
        int And=li.indexOf('&');
        Integer pageNumber=Integer.parseInt(li.substring(0,And));
        return pageNumber;
    }
    public static ArrayList<String> akashaJsonFetcher(String rankingName, ArrayList<String> akashaApiLinks){
        //ranking name example: Xiao120Homa.  "Xiao120HomaP1.json" where Xiao is char name, 120 is ER bracket, Homa is the weapon category and P1 is pg no.
        //takes akasha api call links and fetches the files and names them as rankingName+"P"+i+.json and returns the list of files so created
        ArrayList<String> returnList = new ArrayList<>();
        ArrayList<String> oldAkashaList = returnAkashaListFromFile();
        for (String akashaLink : akashaApiLinks){
            //if ranking name in fileName same as existing, (pgno from the link) then add to list, skipping that iteration
            String fileName = rankingName+"P"+(getPageNumber(akashaLink))+".json";
            if(oldAkashaList.contains(fileName)){
                returnList.add(fileName);
            } else {
                String saveDir = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/AkashaJSONs/" + fileName;
                try {
                    JsonToFileWriter.saveURLContentToFile(akashaLink, saveDir);
                    returnList.add(fileName);
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        akashaListFileWriter(returnList);
        return returnList;
    }
    public static ArrayList<Integer> uidLister(){
        //takes the akashaJsonFetcher arraylist output and reads the files mentioned in the input and returns the uids from that
        ArrayList<Integer> uidList = new ArrayList<>();
        String rankingName = "Xiao120Homa";
        ArrayList<String> akashaApiLinks = new ArrayList<>(){ //10+1 akasha api links, containing 20 uids each
            {
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=1&filter=&uids=&p=gt%7C718309.5368191481&fromId=665cda1d8f1b3f627fc8e7d0&li=21&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=2&filter=&uids=&p=lt%7C719099.8674470225&fromId=64ea5a3ddbe6a10bf2b0edbe&li=20&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=3&filter=&uids=&p=lt%7C711004.7082426915&fromId=65789ee8dbe6a10bf2c4eced&li=40&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=4&filter=&uids=&p=lt%7C704311.7886029927&fromId=66efb0a78f1b3f627f55bc07&li=60&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=5&filter=&uids=&p=lt%7C700801.139194104&fromId=64ea5939dbe6a10bf2ab99af&li=80&variant=120er&calculationId=1000002601");

                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=6&filter=&uids=&p=lt%7C698140.9497622285&fromId=64f7f401dbe6a10bf2653aab&li=100&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=7&filter=&uids=&p=lt%7C695437.1377883212&fromId=66f75a128f1b3f627fa36b8f&li=120&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=8&filter=&uids=&p=lt%7C692855.0995534939&fromId=64ea595fdbe6a10bf2ac6062&li=140&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=9&filter=&uids=&p=lt%7C689360.9210792804&fromId=64ea59badbe6a10bf2ae3252&li=160&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=10&filter=&uids=&p=lt%7C685716.380288172&fromId=65ad1028dbe6a10bf279beb2&li=180&variant=120er&calculationId=1000002601");

                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=11&filter=&uids=&p=lt%7C683950.688454308&fromId=663f4f738f1b3f627f5f77a7&li=200&variant=120er&calculationId=1000002601");
                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=12&filter=&uids=&p=lt%7C683100.1127737699&fromId=65d9be2b8f1b3f627f00eabf&li=220&variant=120er&calculationId=1000002601");
            }
        };
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> fileNameList = akashaJsonFetcher(rankingName, akashaApiLinks); //if filename in
        for (String fileName : fileNameList){
            String filePath = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/AkashaJSONs/"+fileName;
            try {
                Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File(filePath), Map.class);
                ArrayList<Object> data = (ArrayList<Object>) map.get("data");
                for (Object dataItem : data ){
                    Map<String, String> dataItemMap = (Map<String, String>) dataItem;
                    int temp;
                    try{
                        temp = Integer.parseInt(dataItemMap.get("uid"));
                    }catch(NumberFormatException e){
                        System.out.println("User has invalid uid: "+dataItemMap.get("uid"));
                        continue;
                    }
                    uidList.add(temp);
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return uidList;
    }
}
