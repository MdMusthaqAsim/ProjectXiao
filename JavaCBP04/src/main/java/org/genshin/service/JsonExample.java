package org.genshin.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.genshin.model.EquipList;
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
            System.out.println((Integer) playerInfo.get("theaterActIndex"));

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
//            for(Object o : (ArrayList<Object>) map.get("avatarInfoList")) {
//                Map<String, Object> avatarInfoListItem = (Map<String, Object>) o;
//                ArrayList<Object> equipList = (ArrayList<Object>) avatarInfoListItem.get("equipList");
//                ArrayList<EquipList> equipListArray = new ArrayList<>();
//                for(Object equipListObject : equipList){
//                    Map<String, Object> equipListObjectMap = (Map<String, Object>) equipListObject;
//                    if(equipListObjectMap.get("weapon") == null){
//                        Integer itemId = (Integer)equipListObjectMap.get("itemId");
//                        System.out.println(avatarInfoListItem.get("avatarId")+" - "+itemId);
//                        Map<String, Object> reliquaryItem = (Map<String, Object>) equipListObjectMap.get("reliquary");
//                        //System.out.println(reliquaryItem);
//                        Integer level = (Integer) reliquaryItem.get("level");
//                        Integer mainPropId = (Integer) reliquaryItem.get("mainPropId");
//                        //System.out.println(mainPropId+"::::::::"+level);
//
//                        Map<String, Object> flatItem = (Map<String, Object>) equipListObjectMap.get("flat");
//                        //System.out.println("flat:::}}}}}}}}"+flatItem);
//                        ArrayList<Object> reliquarySubstats = (ArrayList<Object>) flatItem.get("reliquarySubstats");
//                        for(Object reliquarySubstatsItem : reliquarySubstats){
//                            Map<String, Object> reliquarySubstatsItemMap = (Map<String, Object>) reliquarySubstatsItem;
//                            System.out.println("Stat: "+reliquarySubstatsItemMap.get("appendPropId"));
//                            System.out.println("Value: "+reliquarySubstatsItemMap.get("statValue"));
//                        }
////                        System.out.println("reliquary - "+equipListObjectMap.get("reliquary"));
////                        System.out.println("flat - "+equipListObjectMap.get("flat"));
//
//                        //EquipList equipListItem = new EquipList(itemId, reliquary, flat);
//                    }else{
//                        Integer itemId = (Integer)equipListObjectMap.get("itemId");
//                        System.out.println(avatarInfoListItem.get("avatarId")+" - "+itemId);
//                        Map<String, Object> flatItem = (Map<String, Object>) equipListObjectMap.get("flat");
////                        System.out.println("weapon - "+equipListObjectMap.get("weapon"));
////                        System.out.println("flat - "+equipListObjectMap.get("flat"));
//
//                        //EquipList equipListItem = new EquipList(itemId, weapon, flat);
//                    }
//                    //equipListArray.add(equipListItem);
//                }

//                ArrayList<Object> equipList = (ArrayList<Object>) avatarInfoListItem.get("equipList");
//
//                for(Object equipment : equipList){
//                    Map<String, Object> equips = (Map<String, Object>) equipment;
//                    System.out.println("itemId: "+equips.get("itemId"));
//                    Map<String,Object> reliquary = (Map<String, Object>) equips.get("reliquary");
//                    System.out.println("reliq: "+reliquary);
//                    Map<String,Object> flat=(Map<String, Object>) equips.get("flat");
//                    System.out.println("flat::::: "+flat.get("reliquarySubstats"));
//
//                    Map<String, Object> reliquaryMainstat = (Map<String, Object>) flat.get("reliquaryMainstat");
//                    try {
//                        System.out.println(reliquaryMainstat.get("mainPropId"));
//                    } catch (Exception e) {
//                        System.out.println("hi");//weapon logic
//                    }
//
//                }


//                Map<Integer, Integer> skillLevelMap = (Map<Integer, Integer>) avatarInfoListItem.get("skillLevelMap");
//                //System.out.println((skillLevelMap.keySet()).getClass());
//                for(Object i : skillLevelMap.keySet()){
//                    System.out.println(Integer.parseInt((String)i)+" - "+(skillLevelMap.get(i)).getClass());
//                }



//                Map<Integer, String> fightPropMapItem = (Map<Integer, String>) avatarInfoListItem.get("fightPropMap");
//                System.out.println(fightPropMapItem);
//                for (Object index : fightPropMapItem.keySet()){
//                    System.out.println(index.getClass()+" index");
//                    Object x = (fightPropMapItem.get(index));
//                    x = x.toString();
//
//                    System.out.println(avatarInfoListItem.get("avatarId")+" - "+Integer.parseInt((String) index)+" - "+Double.parseDouble((String) x)+" item ("+x.getClass()+")");

//                }
//                Map<Integer, Object> propMapItem = (Map<Integer, Object>) avatarInfoListItem.get("propMap");
//                Map<Integer, PropMap> propMap = new HashMap<>();

                // code here



//                for(Object i :  propMapItem.values()){
//                    Map<String, Object> iObj = (Map<String, Object>) i;
//                    propMap.put((Integer) iObj.get("type"), new PropMap((int)iObj.get("type"), (String)iObj.get("ival"), (String)iObj.get("val")));
//                    System.out.println(avatarInfoListItem.get("avatarId")+" - "+propMap.get(iObj.get("type")).getType());
//                }



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

