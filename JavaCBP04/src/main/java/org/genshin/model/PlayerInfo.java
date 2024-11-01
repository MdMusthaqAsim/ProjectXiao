package org.genshin.model;

import java.util.ArrayList;
import java.util.Map;

public class PlayerInfo {
        public PlayerInfo(String nickname, int level, String signature, int worldLevel, int nameCardId, int finishAchievementNum, int towerFloorIndex, int towerLevelIndex, ArrayList<ShowAvatarInfoList> showAvatarInfoList, ArrayList<Integer> showNameCardIdList, Map<String, Integer> profilePicture, int theatreActIndex, int theatreModeIndex, int theatreStarIndex, boolean isShowAvatarTalent, int fetterCount, int towerStarIndex) {
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
        private int level;
        private String signature;
        private int worldLevel;
        private int nameCardId;
        private int finishAchievementNum;
        private int towerFloorIndex;
        private int towerLevelIndex;
        private ArrayList<ShowAvatarInfoList> showAvatarInfoList;
        private ArrayList<Integer> showNameCardIdList;
        private Map<String, Integer> profilePicture;
        private int theatreActIndex;
        private int theatreModeIndex;
        private int theatreStarIndex;
        private boolean isShowAvatarTalent;
        private int fetterCount;
        private int towerStarIndex;

        public String getNickname() {
                return nickname;
        }

        public void setNickname(String nickname) {
                this.nickname = nickname;
        }

        public int getLevel() {
                return level;
        }

        public void setLevel(int level) {
                this.level = level;
        }

        public String getSignature() {
                return signature;
        }

        public void setSignature(String signature) {
                this.signature = signature;
        }

        public int getWorldLevel() {
                return worldLevel;
        }

        public void setWorldLevel(int worldLevel) {
                this.worldLevel = worldLevel;
        }

        public int getNameCardId() {
                return nameCardId;
        }

        public void setNameCardId(int nameCardId) {
                this.nameCardId = nameCardId;
        }

        public int getFinishAchievementNum() {
                return finishAchievementNum;
        }

        public void setFinishAchievementNum(int finishAchievementNum) {
                this.finishAchievementNum = finishAchievementNum;
        }

        public int getTowerFloorIndex() {
                return towerFloorIndex;
        }

        public void setTowerFloorIndex(int towerFloorIndex) {
                this.towerFloorIndex = towerFloorIndex;
        }

        public int getTowerLevelIndex() {
                return towerLevelIndex;
        }

        public void setTowerLevelIndex(int towerLevelIndex) {
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

        public int getTheatreActIndex() {
                return theatreActIndex;
        }

        public void setTheatreActIndex(int theatreActIndex) {
                this.theatreActIndex = theatreActIndex;
        }

        public int getTheatreModeIndex() {
                return theatreModeIndex;
        }

        public void setTheatreModeIndex(int theatreModeIndex) {
                this.theatreModeIndex = theatreModeIndex;
        }

        public int getTheatreStarIndex() {
                return theatreStarIndex;
        }

        public void setTheatreStarIndex(int theatreStarIndex) {
                this.theatreStarIndex = theatreStarIndex;
        }

        public boolean isShowAvatarTalent() {
                return isShowAvatarTalent;
        }

        public void setShowAvatarTalent(boolean showAvatarTalent) {
                isShowAvatarTalent = showAvatarTalent;
        }

        public int getFetterCount() {
                return fetterCount;
        }

        public void setFetterCount(int fetterCount) {
                this.fetterCount = fetterCount;
        }

        public int getTowerStarIndex() {
                return towerStarIndex;
        }

        public void setTowerStarIndex(int towerStarIndex) {
                this.towerStarIndex = towerStarIndex;
        }
}
