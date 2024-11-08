package org.genshin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.genshin.controller.AkashaUidFetcher;
import org.genshin.controller.JsonToFileWriter;
import org.genshin.mapper.Mapper;
import org.genshin.model.*;

import java.io.*;
import java.util.*;

public class JsonExample {

    public static void main(String[] args) {
        //ArrayList<Integer> uidList = AkashaUidFetcher.uidLister();
        //System.out.println(uidList.size());
        Integer uid = 809949310;
        User user = Mapper.userMapper("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/UserJSONs/"+uid+".json");
        for(AvatarInfoList o: user.getAvatarInfoList()){
            if(o.getAvatarId() == 10000026){
                Double baseAtk = o.getFightPropMap().get(4);
                Double flatAtkBuff = o.getFightPropMap().get(5);
                Double percentageAtk = o.getFightPropMap().get(6);
                Double hpFinal = o.getFightPropMap().get(2000);
                Double weaponFlatAtkBuff = hpFinal*(0.018);
                Double weaponAtkPercentBuff = 0.0;
                Double finalAtkStat = (baseAtk*(1+percentageAtk+weaponAtkPercentBuff))+flatAtkBuff+weaponFlatAtkBuff;
                System.out.println(finalAtkStat);
            } else  {
                System.err.println("No");
            }
        }
//        String uidListString;
//        ArrayList<Integer> newUidList = new ArrayList<>();
//        try {
//            BufferedReader a = new BufferedReader(new FileReader("/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/currUserList.txt"));
//            uidListString = a.readLine();
//            //System.out.println(uidListString);
//            String[] items = uidListString.substring(1, uidListString.length() - 1).split(", ");
//            for (String item : items) {
//                newUidList.add(Integer.parseInt(item));
//            }
//            System.err.println(newUidList);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        int uid = 809949310;
//        String saveDir = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/UserJSONs/";
//        String fileURL = "https://enka.network/api/uid/";
////        saveDir = saveDir+uid+".json";
////        fileURL = fileURL+uid;
//        for (int uid : uidList){
//            try {
//                String saveDirX = saveDir+uid+".json";
//                String fileURLX = fileURL+uid;
//                JsonToFileWriter.saveURLContentToFile(fileURLX, saveDirX);
//
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(uid);
        //}
//        ArrayList<Integer> uidList = new ArrayList<>();
//        String rankingName = "Xiao120Homa";
//        ArrayList<String> akashaApiLinks = new ArrayList<>(){ //10 akasha api links, containing 20 uids each
//            {
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=1&filter=&uids=&p=gt%7C718309.5368191481&fromId=665cda1d8f1b3f627fc8e7d0&li=21&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=2&filter=&uids=&p=lt%7C719099.8674470225&fromId=64ea5a3ddbe6a10bf2b0edbe&li=20&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=3&filter=&uids=&p=lt%7C711004.7082426915&fromId=65789ee8dbe6a10bf2c4eced&li=40&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=4&filter=&uids=&p=lt%7C704311.7886029927&fromId=66efb0a78f1b3f627f55bc07&li=60&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=5&filter=&uids=&p=lt%7C700801.139194104&fromId=64ea5939dbe6a10bf2ab99af&li=80&variant=120er&calculationId=1000002601");
//
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=6&filter=&uids=&p=lt%7C698140.9497622285&fromId=64f7f401dbe6a10bf2653aab&li=100&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=7&filter=&uids=&p=lt%7C695437.1377883212&fromId=66f75a128f1b3f627fa36b8f&li=120&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=8&filter=&uids=&p=lt%7C692855.0995534939&fromId=64ea595fdbe6a10bf2ac6062&li=140&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=9&filter=&uids=&p=lt%7C689360.9210792804&fromId=64ea59badbe6a10bf2ae3252&li=160&variant=120er&calculationId=1000002601");
//                add("https://akasha.cv/api/leaderboards?sort=calculation.result&order=-1&size=20&page=10&filter=&uids=&p=lt%7C685716.380288172&fromId=65ad1028dbe6a10bf279beb2&li=180&variant=120er&calculationId=1000002601");
//            }
//        };
//        ObjectMapper objectMapper = new ObjectMapper();
//        ArrayList<String> fileNameList = akashaJsonFetcher(rankingName, akashaApiLinks);
//        for (String fileName : fileNameList){
//            String filePath = "/Users/mohammedmusthaqasimshaik/IdeaProjects/ProjectXiao/JavaCBP04/src/main/java/org/genshin/assets/AkashaJSONs/"+fileName;
//            try {
//                Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File(filePath), Map.class);
//                ArrayList<Object> data = (ArrayList<Object>) map.get("data");
//
//                for (Object dataItem : data ){
//
//                    Map<String, String> dataItemMap = (Map<String, String>) dataItem;
////                    System.out.println(dataItemMap.get("uid")+" :"+(++j));
//                    //uidList.add(Integer.parseInt(dataItemMap.get("uid")));
//                    int temp;
//                    try{
//                        temp = Integer.parseInt(dataItemMap.get("uid"));
//                    }catch(NumberFormatException e){
//                        System.out.println("fuck "+dataItemMap.get("uid"));
//                        continue;
//                    }
//                    uidList.add(temp);
//                }
//
//            } catch (IOException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//        System.out.println(uidList);
//        System.out.println(uidList.size());
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {

            // Read JSON file into a Map
//            Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File("src/main/java/org/genshin/assets/809949310.json"), Map.class);
//
//
//
//            // Accessing values using keys
//            String uid = (String) map.get("uid");
//
//            Map<String, Object> playerInfo = (Map<String, Object>) map.get("playerInfo");
//
//            String nickname = (String) playerInfo.get("nickname");
//            System.out.println((Integer) playerInfo.get("theaterActIndex"));

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

//            System.out.println("nickname: " + nickname);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        }
    }


