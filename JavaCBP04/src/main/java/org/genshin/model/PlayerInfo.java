package org.genshin.model;

import java.util.ArrayList;
import java.util.Map;

public class PlayerInfo {
        public PlayerInfo(String nickname, Integer level, String signature, Integer worldLevel, Integer nameCardId, Integer finishAchievementNum, Integer towerFloorIndex, Integer towerLevelIndex, ArrayList<ShowAvatarInfoList> showAvatarInfoList, ArrayList<Integer> showNameCardIdList, Map<String, Integer> profilePicture, Integer theatreActIndex, Integer theatreModeIndex, Integer theatreStarIndex, Boolean isShowAvatarTalent, Integer fetterCount, Integer towerStarIndex) {
                this.nickname = nickname;
                this.level = level;
                this.signature = signature;
                this.worldLevel = worldLevel;
                this.nameCardId = nameCardId;
                this.finishAchievementNum = finishAchievementNum;
                this.towerFloorIndex = towerFloorIndex;
                this.towerLevelIndex = towerLevelIndex;
                this.showAvatarInfoList = showAvatarInfoList;
                this.showNameCardIdList = showNameCardIdList;
                this.profilePicture = profilePicture;
                this.theatreActIndex = theatreActIndex;
                this.theatreModeIndex = theatreModeIndex;
                this.theatreStarIndex = theatreStarIndex;
                this.isShowAvatarTalent = isShowAvatarTalent;
                this.fetterCount = fetterCount;
                this.towerStarIndex = towerStarIndex;
        }

        private String nickname;
        private Integer level;
        private String signature;
        private Integer worldLevel;
        private Integer nameCardId;
        private Integer finishAchievementNum;
        private Integer towerFloorIndex;
        private Integer towerLevelIndex;
        private ArrayList<ShowAvatarInfoList> showAvatarInfoList;
        private ArrayList<Integer> showNameCardIdList;
        private Map<String, Integer> profilePicture;
        private Integer theatreActIndex;
        private Integer theatreModeIndex;
        private Integer theatreStarIndex;
        private Boolean isShowAvatarTalent;
        private Integer fetterCount;
        private Integer towerStarIndex;

        public String getNickname() {
                return nickname;
        }

        public void setNickname(String nickname) {
                this.nickname = nickname;
        }

        public Integer getLevel() {
                return level;
        }

        public void setLevel(Integer level) {
                this.level = level;
        }

        public String getSignature() {
                return signature;
        }

        public void setSignature(String signature) {
                this.signature = signature;
        }

        public Integer getWorldLevel() {
                return worldLevel;
        }

        public void setWorldLevel(Integer worldLevel) {
                this.worldLevel = worldLevel;
        }

        public Integer getNameCardId() {
                return nameCardId;
        }

        public void setNameCardId(Integer nameCardId) {
                this.nameCardId = nameCardId;
        }

        public Integer getFinishAchievementNum() {
                return finishAchievementNum;
        }

        public void setFinishAchievementNum(Integer finishAchievementNum) {
                this.finishAchievementNum = finishAchievementNum;
        }

        public Integer getTowerFloorIndex() {
                return towerFloorIndex;
        }

        public void setTowerFloorIndex(Integer towerFloorIndex) {
                this.towerFloorIndex = towerFloorIndex;
        }

        public Integer getTowerLevelIndex() {
                return towerLevelIndex;
        }

        public void setTowerLevelIndex(Integer towerLevelIndex) {
                this.towerLevelIndex = towerLevelIndex;
        }

        public ArrayList<ShowAvatarInfoList> getShowAvatarInfoList() {
                return showAvatarInfoList;
        }

        public void setShowAvatarInfoList(ArrayList<ShowAvatarInfoList> showAvatarInfoList) {
                this.showAvatarInfoList = showAvatarInfoList;
        }

        public ArrayList<Integer> getShowNameCardIdList() {
                return showNameCardIdList;
        }

        public void setShowNameCardIdList(ArrayList<Integer> showNameCardIdList) {
                this.showNameCardIdList = showNameCardIdList;
        }

        public Map<String, Integer> getProfilePicture() {
                return profilePicture;
        }

        public void setProfilePicture(Map<String, Integer> profilePicture) {
                this.profilePicture = profilePicture;
        }

        public Integer getTheatreActIndex() {
                return theatreActIndex;
        }

        public void setTheatreActIndex(Integer theatreActIndex) {
                this.theatreActIndex = theatreActIndex;
        }

        public Integer getTheatreModeIndex() {
                return theatreModeIndex;
        }

        public void setTheatreModeIndex(Integer theatreModeIndex) {
                this.theatreModeIndex = theatreModeIndex;
        }

        public Integer getTheatreStarIndex() {
                return theatreStarIndex;
        }

        public void setTheatreStarIndex(Integer theatreStarIndex) {
                this.theatreStarIndex = theatreStarIndex;
        }

        public Boolean isShowAvatarTalent() {
                return isShowAvatarTalent;
        }

        public void setShowAvatarTalent(Boolean showAvatarTalent) {
                isShowAvatarTalent = showAvatarTalent;
        }

        public Integer getFetterCount() {
                return fetterCount;
        }

        public void setFetterCount(Integer fetterCount) {
                this.fetterCount = fetterCount;
        }

        public Integer getTowerStarIndex() {
                return towerStarIndex;
        }

        public void setTowerStarIndex(Integer towerStarIndex) {
                this.towerStarIndex = towerStarIndex;
        }
}
