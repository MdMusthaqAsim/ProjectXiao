package org.genshin.mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class ObjectMapperFr {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file into a Map
            Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File("C:/Users/amush/Downloads/809949310.json"), Map.class);
            //First part, playerInfo mapping starts here
            Map<String, Object> playerInfo = (Map<String, Object>) map.get("playerInfo");
            String nickname=(String) playerInfo.get("nickname");
            int level= (int) playerInfo.get("level");
            String signature= (String) playerInfo.get("signature");
            int worldLevel= (int) playerInfo.get("worldLevel");
            int nameCardId= (int) playerInfo.get("nameCardId");
            int finishAchievementNum= (int) playerInfo.get("finishAchievementNum");
            int towerFloorIndex= (int) playerInfo.get("towerFloorIndex");
            int towerLevelIndex= (int) playerInfo.get("towerLevelIndex");
            ArrayList<Object> showNameCardIdList = (ArrayList<Object>) playerInfo.get("showNameCardIdList");
            //System.out.println(showNameCardIdList.get(0));
            ArrayList<Object> showAvatarInfoList = (ArrayList<Object>) playerInfo.get("showAvatarInfoList");
            //System.out.println(showAvatarInfoList);
            Map<String,Object> profilePicture= (Map<String,Object>) playerInfo.get("profilePicture");
            int theaterActIndex = (int) playerInfo.get("theaterActIndex");
            int theaterModeIndex = (int) playerInfo.get("theaterModeIndex");
            int theaterStarIndex = (int) playerInfo.get("theaterStarIndex");
            boolean isShowAvatarTalent = (boolean) playerInfo.get("isShowAvatarTalent");
            int fetterCount = (int) playerInfo.get("fetterCount");
            int towerStarIndex = (int) playerInfo.get("towerStarIndex");
            //All fields fetched, create object and send data via constructor call

            //Second part, avatarInfoList starts here
            ArrayList<Object> avatarInfoList = (ArrayList<Object>) map.get("avatarInfoList");
            for(Object singleCharacterData : avatarInfoList) {
                Map<String,Object> singleOperableData = (Map<String, Object>) singleCharacterData;
                if((int)singleOperableData.get("avatarId") == 10000026 /* This is used to filter out your character*/) {
                    int avatarId = (int) singleOperableData.get("avatarId");
                    Map<String,Object> propMap = (Map<String, Object>) singleOperableData.get("propMap");
                    Map<String,Object> fightPropMap = (Map<String, Object>) singleOperableData.get("fightPropMap");
                    int skillDeptoId = (int) singleOperableData.get("skillDepotId");
                    ArrayList<Object> inherentProudSkillList = (ArrayList<Object>) singleOperableData.get("inherentProudSkillList");
                    Map<String,Object> skillLevelMap = (Map<String,Object>) singleOperableData.get("skillLevelMap");
                    ArrayList<Object> equipList = (ArrayList<Object>) singleOperableData.get("equipList");
                    for(Object equipment: equipList){
                        Map<String,Object> equips= (Map<String, Object>) equipment;
                        int itemId=(int)equips.get("itemId");
                        Map<String,Object> reliquary = (Map<String, Object>) equips.get("reliquary");
                        Map<String,Object> flat=(Map<String, Object>) equips.get("flat");
                        //Now push this inside equiplist array object, make sure it's within the loop
                    }
                    //Fetter info field not found within AvatarInfoList class, hence omitted
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}