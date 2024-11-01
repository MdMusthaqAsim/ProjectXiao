package org.genshin.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.genshin.model.PropMap;
import org.genshin.model.ShowAvatarInfoList;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file into a Map
            Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File("src/main/java/org/genshin/assets/809949310.json"), Map.class);



            // Accessing values using keys
            String uid = (String) map.get("uid");

            Map<String, Object> playerInfo = (Map<String, Object>) map.get("playerInfo");

            String nickname = (String) playerInfo.get("nickname");

////            ArrayList<ShowAvatarInfoList> showAvatarInfoList = new ArrayList<>();
//////            for (Object o : (ArrayList<Object>) playerInfo.get(("showAvatarInfoList"))){
//////                Map<String, Object> showAvatarInfoListItem = (Map<String, Object>) o;
//////                ShowAvatarInfoList item = new ShowAvatarInfoList((int)showAvatarInfoListItem.get("avatarId"), (int)showAvatarInfoListItem.get("level"), (int)showAvatarInfoListItem.get("energyType"));
//////                showAvatarInfoList.add(item);
//////            }
//////            for(ShowAvatarInfoList o : showAvatarInfoList){
//////                System.out.println(o.getAvatarId()+"+++");
//////            }
//            ArrayList<Integer> a = new ArrayList<>((ArrayList<Integer>) playerInfo.get("showNameCardIdList"));
//            System.out.println(a+"@@@");
            for(Object o : (ArrayList<Object>) map.get("avatarInfoList")) {
                Map<String, Object> avatarInfoListItem = (Map<String, Object>) o;
                Map<Integer, Object> propMapItem = (Map<Integer, Object>) avatarInfoListItem.get("propMap");
                Map<Integer, PropMap> propMap = new HashMap<>();

                // code here



                for(Object i :  propMapItem.values()){
                    Map<String, Object> iObj = (Map<String, Object>) i;
                    propMap.put((Integer) iObj.get("type"), new PropMap((int)iObj.get("type"), (String)iObj.get("ival"), (String)iObj.get("val")));
                    System.out.println(avatarInfoListItem.get("avatarId")+" - "+propMap.get(iObj.get("type")).getType());
                }
            }


//            ArrayList<Integer> nameCardIdList = (ArrayList<Integer>) playerInfo.get("showNameCardIdList");
//            int cardId = nameCardIdList.get(0);
//            System.out.println(cardId);
//
//            // Output values
//            System.out.println("uid: " + uid);
//
//            System.out.println(playerInfo);

            System.out.println("nickname: " + nickname);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

