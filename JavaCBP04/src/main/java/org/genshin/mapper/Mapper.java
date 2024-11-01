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
            Map<String, Object> map = (Map<String, Object>) objectMapper.readValue(new File("org/genshin/assets/809949310.json"), Map.class);

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

        return null;
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
            String avatarId = (String) avatarInfoListItem.get("avatarId");
            Map<Integer, PropMap> propMap = propMapMapper(avatarInfoListItem);
        }

        return null;
    }

    private static Map<Integer, PropMap> propMapMapper(Map<String, Object> avatarInfoListItem) {
        Map<Integer, Object> propMapItem = (Map<Integer, Object>) avatarInfoListItem.get("propMap");
        for(int key : propMapItem.keySet()){
            //need to create a propmap
        }
        return null;
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
        int theatreActIndex = (int) playerInfo.get("theatreActIndex");
        int theatreModeIndex = (int) playerInfo.get("theatreModeIndex");
        int theatreStarIndex = (int) playerInfo.get("theatreStarIndex");
        boolean isShowAvatarTalent = (boolean) playerInfo.get("isShowAvatarTalent");
        int fetterCount = (int) playerInfo.get("fetterCount");
        int towerStarIndex = (int) playerInfo.get("towerStarIndex");

        return new PlayerInfo(nickname, level, signature, worldLevel, nameCardId, finishAchievementNum, towerFloorIndex, towerLevelIndex, showAvatarInfoList, showNameCardIdList, profilePicture, theatreActIndex, theatreModeIndex, theatreStarIndex, isShowAvatarTalent, fetterCount, towerStarIndex);
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
