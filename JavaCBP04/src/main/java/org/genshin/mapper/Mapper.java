package org.genshin.mapper;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import org.genshin.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class Mapper {

    public static User userMapper(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = null;
        try {
            Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File(path), Map.class);

            PlayerInfo playerInfo = playerInfoMapper(map);
            ArrayList<AvatarInfoList> avatarInfoList = avatarInfoListMapper(map);
            int ttl = (int) map.get("ttl");
            String uid = (String) map.get("uid");
            Owner owner = ownerMapper(map);

            user = new User(playerInfo, avatarInfoList, ttl, uid, owner);

        } catch (IOException e) {
            System.out.println(e);
        }
        return user;
    }

    private static Owner ownerMapper(Map<String, Object> map) {
        Map<String, Object> owner = (Map<String, Object>) map.get("owner");
        String hash = (String) owner.get("hash");
        String username = (String) owner.get("username");
        Profile profile = profileMapper(owner);
        int id = (int) owner.get("id");

        return new Owner(hash, username, profile, id);
    }

    private static Profile profileMapper(Map<String, Object> owner) {
        Map<String, Object> profile = (Map<String, Object>) owner.get("profile");
        String bio = (String) profile.get("bio");
        int level = (int) profile.get("level");
        int signup_state = (int) profile.get("signup_state");
        String avatar = (String) profile.get("avatar");

        return new Profile(bio, level, signup_state, avatar);
    }

    private static ArrayList<AvatarInfoList> avatarInfoListMapper(Map<String, Object> map) {
        ArrayList<AvatarInfoList> avatarInfoList = new ArrayList<>();

        for(Object o : (ArrayList<Object>) map.get("avatarInfoList")){
            Map<String, Object> avatarInfoListItem = (Map<String, Object>) o;
            Integer avatarId = (Integer) avatarInfoListItem.get("avatarId");
            Map<Integer, PropMap> propMap = propMapMapper(avatarInfoListItem);
            Map<Integer, Double> fightPropMap = fightPropMapMapper(avatarInfoListItem);
            Integer skillDepotId = (Integer)avatarInfoListItem.get("skillDepotId");
            ArrayList<Integer> inherentProudSkillList = inherentProudSkillListMapper(avatarInfoListItem);
            Map<Integer, Integer> skillLevelMap = skillLevelMapMapper(avatarInfoListItem);
            ArrayList<EquipList> equipList = equipListMapper(avatarInfoListItem);
            Map<String, Integer> fetterInfo = fetterInfoMapper(avatarInfoListItem);

            AvatarInfoList avatarInfoListObj = new AvatarInfoList(avatarId, propMap, fightPropMap, skillDepotId, inherentProudSkillList, skillLevelMap, equipList, fetterInfo);
            avatarInfoList.add(avatarInfoListObj);
        }

        return avatarInfoList;
    }

    private static Map<String, Integer> fetterInfoMapper(Map<String, Object> avatarInfoListItem) {
        return (Map<String, Integer>) avatarInfoListItem.get("fetterInfo");
    }

    private static ArrayList<EquipList> equipListMapper(Map<String, Object> avatarInfoListItem) {
        ArrayList<Object> equipList = (ArrayList<Object>) avatarInfoListItem.get("equipList");
        ArrayList<EquipList> equipListArray = new ArrayList<>();
        EquipList equipListItem = null;
        for(Object equipListObject : equipList){
            Map<String, Object> equipListObjectMap = (Map<String, Object>) equipListObject;

            if(equipListObjectMap.get("weapon") == null){

                Integer itemId = (Integer)equipListObjectMap.get("itemId");
                Reliquary reliquary = reliquaryMapper(equipListObjectMap);
                Flat flat = reliqFlatMapper(equipListObjectMap);

                equipListItem = new EquipList(itemId, reliquary, flat);
            }else{

                Integer itemId = (Integer)equipListObjectMap.get("itemId");
                Weapon weapon = weaponMapper(equipListObjectMap);
                Flat flat = weaponFlatMapper(equipListObjectMap);

                equipListItem = new EquipList(itemId, weapon, flat);
            }
            equipListArray.add(equipListItem);
        }
        return equipListArray;
    }

    private static Flat weaponFlatMapper(Map<String, Object> equipListObjectMap) {
        Map<String, Object> flatItem = (Map<String, Object>) equipListObjectMap.get("flat");
        String nameTextMapHash = (String) flatItem.get("nameTextMapHash");
        Integer rankLevel = (Integer) flatItem.get("rankLevel");
        String itemType = (String) flatItem.get("itemType");
        String icon = (String) flatItem.get("icon");
        ArrayList<WeaponStats> weaponStats = weaponStatsMapper(flatItem);

        return new Flat(weaponStats, nameTextMapHash, rankLevel, itemType, icon);
    }

    private static ArrayList<WeaponStats> weaponStatsMapper(Map<String, Object> flatItem) {
        ArrayList<Object> weaponStats = (ArrayList<Object>) flatItem.get("weaponStats");
        ArrayList<WeaponStats> weaponStatsList = new ArrayList<>();
        for (Object weaponStat : weaponStats){
            Map<String, Object> weaponStatItem = (Map<String, Object>) weaponStat;
            String appendPropId = (String) weaponStatItem.get("appendStatId");
            Double statValue = Double.valueOf(weaponStatItem.get("statValue").toString()) ;
            WeaponStats weaponStatsObj = new WeaponStats(appendPropId, statValue);
            weaponStatsList.add(weaponStatsObj);
        }
        return weaponStatsList;
    }

    private static Flat reliqFlatMapper(Map<String, Object> equipListObjectMap) {
        Map<String, Object> flatItem = (Map<String, Object>) equipListObjectMap.get("flat");
        String nameTextMapHash = (String) flatItem.get("nameTextMapHash");
        Integer rankLevel = (Integer) flatItem.get("rankLevel");
        String itemType = (String) flatItem.get("itemType");
        String icon = (String) flatItem.get("icon");
        String equipType = (String) flatItem.get("equipType");
        String setNameTextMapHash = (String) flatItem.get("setNameTextMapHash");
        ArrayList<ReliquarySubstats> reliquarySubstats = reliquarySubstatsMapper(flatItem);
        ReliquaryMainstat reliquaryMainstat = reliquaryMainstatMapper(flatItem);

        return new Flat(reliquarySubstats, reliquaryMainstat, nameTextMapHash, rankLevel, itemType, icon, equipType, setNameTextMapHash);
    }

    private static ReliquaryMainstat reliquaryMainstatMapper(Map<String, Object> flatItem) {
        Map<String, Object> reliquaryMainstat = (Map<String, Object>) flatItem.get("reliquaryMainstat");
        String mainPropId = (String) reliquaryMainstat.get("mainPropId");
        Double statValue = Double.valueOf(reliquaryMainstat.get("statValue").toString()) ;
        return new ReliquaryMainstat(mainPropId, statValue);
    }

    private static ArrayList<ReliquarySubstats> reliquarySubstatsMapper(Map<String, Object> flatItem) {
        ArrayList<Object> reliquarySubstats = (ArrayList<Object>) flatItem.get("reliquarySubstats");
        ArrayList<ReliquarySubstats> reliquarySubstatsList = new ArrayList<>();
        for(Object reliquarySubstatsItem : reliquarySubstats){
            Map<String, Object> reliquarySubstatsItemMap = (Map<String, Object>) reliquarySubstatsItem;
            String appendPropId = (String) reliquarySubstatsItemMap.get("appendPropId");
            Double statValue = Double.valueOf(reliquarySubstatsItemMap.get("statValue").toString()) ;
            ReliquarySubstats reliquarySubstatsObj = new ReliquarySubstats(appendPropId, statValue);
            reliquarySubstatsList.add(reliquarySubstatsObj);
        }
        return reliquarySubstatsList;
    }

    private static Weapon weaponMapper(Map<String, Object> equipListObjectMap) {
        Map<String, Object> weaponItem = (Map<String, Object>) equipListObjectMap.get("weapon");
        Integer level = (Integer) weaponItem.get("level");
        Integer promoteLevel;
        if ((Integer) weaponItem.get("promoteLevel") == null){
            promoteLevel = 0;
        }else{
            promoteLevel = (Integer) weaponItem.get("promoteLevel");
        }

        Map<Integer, Integer> affixMap = affixMapMapper(weaponItem);

        return new Weapon(level, promoteLevel, affixMap);
    }

    private static Map<Integer, Integer> affixMapMapper(Map<String, Object> weaponItem) {
        Map<String, Integer> affixMapItem = (Map<String, Integer>) weaponItem.get("affixMap");
        Map<Integer, Integer> affixMap = new HashMap<>();
        for(String key : affixMapItem.keySet()){
            affixMap.put(Integer.parseInt(key), affixMapItem.get(key));
        }
        return affixMap;
    }

    private static Reliquary reliquaryMapper(Map<String, Object> equipListObjectMap) {
        Map<String, Object> reliquaryItem = (Map<String, Object>) equipListObjectMap.get("reliquary");
        Integer level = (Integer) reliquaryItem.get("level");
        Integer mainPropId = (Integer) reliquaryItem.get("mainPropId");
        ArrayList<Integer> appendPropIdList = appendPropIdListMapper(reliquaryItem);

        return new Reliquary(level, mainPropId, appendPropIdList);
    }

    private static ArrayList<Integer> appendPropIdListMapper(Map<String, Object> reliquaryItem) {
        ArrayList<Integer> appendPropIdListItem = (ArrayList<Integer>) reliquaryItem.get("appendPropIdList");
        return new ArrayList<>(appendPropIdListItem);
    }

    private static Map<Integer, Integer> skillLevelMapMapper(Map<String, Object> avatarInfoListItem) {
        Map<Integer, Integer> skillLevelMap = (Map<Integer, Integer>) avatarInfoListItem.get("skillLevelMap");
        Map<Integer, Integer> skillLevelMapObj = new HashMap<>();
        for(Object i : skillLevelMap.keySet()){
            skillLevelMapObj.put(Integer.parseInt((String)i), skillLevelMap.get(i));
        }
        return skillLevelMapObj;
    }

    private static ArrayList<Integer> inherentProudSkillListMapper(Map<String, Object> avatarInfoListItem) {
        ArrayList<Integer> inherentProudSkillList = (ArrayList<Integer>) avatarInfoListItem.get("inherentProudSkillList");
        return new ArrayList<>(inherentProudSkillList);
    }

    private static Map<Integer, Double> fightPropMapMapper(Map<String, Object> avatarInfoListItem) {
        Map<Integer, Double> fightPropMapItem = (Map<Integer, Double>) avatarInfoListItem.get("fightPropMap");
        Map<Integer, Double> fightPropMap = new HashMap<>();
        for (Object index : fightPropMapItem.keySet()){
            Object x = (fightPropMapItem.get(index));
            x = x.toString();
            fightPropMap.put(Integer.parseInt((String) index), Double.parseDouble((String) x));
        }
        return fightPropMap;
    }

    private static Map<Integer, PropMap> propMapMapper(Map<String, Object> avatarInfoListItem) {
        Map<String, Object> propMapItem = (Map<String, Object>) avatarInfoListItem.get("propMap");
        Map<Integer, PropMap> propMap = new HashMap<>();
        for(String key : propMapItem.keySet()){
            Map<String, Object> propMapItemChildren = (Map<String, Object>) propMapItem.get(key);
            Integer type = (Integer) propMapItemChildren.get("type");
            String ival = (String) propMapItemChildren.get("ival");
            String val = (String) propMapItemChildren.get("val");
            PropMap propMapObj = new PropMap(type, ival, val);
            propMap.put((Integer.parseInt(key)),propMapObj);
        }
        return propMap;
    }

    private static PlayerInfo playerInfoMapper(Map<String, Object> map) {
        Map<String, Object> playerInfo = (Map<String, Object>) map.get("playerInfo");
        String nickname = (String) playerInfo.get("nickname");
        int level = (int) playerInfo.get("level");
        String signature = (String) playerInfo.get("signature");
        int worldLevel = (int) playerInfo.get("worldLevel");
        int nameCardId = (int) playerInfo.get("nameCardId");
        int finishAchievementNum = (int) playerInfo.get("finishAchievementNum");
        int towerFloorIndex = (int) playerInfo.get("towerFloorIndex");
        int towerLevelIndex = (int) playerInfo.get("towerLevelIndex");
        ArrayList<ShowAvatarInfoList> showAvatarInfoList = showAvatarInfoListMapper(playerInfo);
        ArrayList<Integer> showNameCardIdList = showNameCardIdListMapper(playerInfo);
        Map<String, Integer> profilePicture = profilePictureMapper(playerInfo);
        Integer theaterActIndex = (Integer) playerInfo.get("theaterActIndex");
        int theaterModeIndex = (int) playerInfo.get("theaterModeIndex");
        int theaterStarIndex = (int) playerInfo.get("theaterStarIndex");
        boolean isShowAvatarTalent = (boolean) playerInfo.get("isShowAvatarTalent");
        int fetterCount = (int) playerInfo.get("fetterCount");
        int towerStarIndex = (int) playerInfo.get("towerStarIndex");

        return new PlayerInfo(nickname, level, signature, worldLevel, nameCardId, finishAchievementNum, towerFloorIndex, towerLevelIndex, showAvatarInfoList, showNameCardIdList, profilePicture, theaterActIndex, theaterModeIndex, theaterStarIndex, isShowAvatarTalent, fetterCount, towerStarIndex);
    }

    private static Map<String, Integer> profilePictureMapper(Map<String, Object> playerInfo) {
        return (Map<String, Integer>) playerInfo.get("profilePicture");
    }

    private static ArrayList<Integer> showNameCardIdListMapper(Map<String, Object> playerInfo) {
        return new ArrayList<>((ArrayList<Integer>) playerInfo.get("showNameCardIdList"));
    }

    private static ArrayList<ShowAvatarInfoList> showAvatarInfoListMapper(Map<String, Object> playerInfo) {
        ArrayList<ShowAvatarInfoList> showAvatarInfoList = new ArrayList<>();
        for (Object o : (ArrayList<Object>) playerInfo.get(("showAvatarInfoList"))){
            Map<String, Object> showAvatarInfoListItem = (Map<String, Object>) o;
            ShowAvatarInfoList item = new ShowAvatarInfoList((int)showAvatarInfoListItem.get("avatarId"), (int)showAvatarInfoListItem.get("level"), (int)showAvatarInfoListItem.get("energyType"));
            showAvatarInfoList.add(item);
        }
        return showAvatarInfoList;
    }
}
