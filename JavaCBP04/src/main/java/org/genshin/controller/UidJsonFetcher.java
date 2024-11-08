package org.genshin.controller;

import java.io.*;
import com.fasterxml.jackson.databind.*;
import java.net.*;
import java.util.*;

//fetches enka jsons from the uids provided by akashauidfetcher and stores them and returns the uid list

public class UidJsonFetcher {

    public static void uidListFileWriter(ArrayList<Integer> uidList){
        String text = uidList.toString();
        String path = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/currUserList.txt";
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public static ArrayList<Integer> returnUidListFromFile(){
        String uidListString;
        ArrayList<Integer> newUidList = new ArrayList<>();
        try {
            BufferedReader a = new BufferedReader(new FileReader("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/currUserList.txt"));
            uidListString = a.readLine();
            String[] items = uidListString.substring(1, uidListString.length() - 1).split(", ");
            for (String item : items) {
                newUidList.add(Integer.parseInt(item));
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return newUidList;
    }
    public static ArrayList<Integer> jsonFetcher(){
        ArrayList<Integer> uidList = AkashaUidFetcher.uidLister();
        ArrayList<Integer> oldUidList = returnUidListFromFile();

        String saveDir = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/UserJSONs/";
        String fileURL = "https://enka.network/api/uid/";
        for (Integer uid : uidList){
            if(oldUidList.contains(uid)){
                System.err.println("["+uid+"] already has been read, to refresh the content, write the deleting method (maintain uidlist.txt and file consistency)");
            } else {
                try {
                    String saveDirX = saveDir + uid + ".json";
                    String fileURLX = fileURL + uid;
                    JsonToFileWriter.saveURLContentToFile(fileURLX, saveDirX);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        uidListFileWriter(uidList);
        return uidList;
    }
}
