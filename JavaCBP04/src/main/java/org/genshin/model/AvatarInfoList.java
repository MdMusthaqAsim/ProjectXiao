package org.genshin.model;

import java.util.*;

public class AvatarInfoList {
    public AvatarInfoList(int avatarId, Map<Integer, PropMap> propMap, Map<Integer, Double> fightPropMap, int skillDepotId, ArrayList<Integer> inherentProudSkillList, Map<Integer, Integer> skillLevelMap, ArrayList<EquipList> equipList, Map<String, Integer> fetterInfo) {
        this.avatarId = avatarId;
        this.propMap = propMap;
        this.fightPropMap = fightPropMap;
        this.skillDepotId = skillDepotId;
        this.inherentProudSkillList = inherentProudSkillList;
        this.skillLevelMap = skillLevelMap;
        this.equipList = equipList;
        this.fetterInfo = fetterInfo;
    }

    private int avatarId;
    private Map<Integer, PropMap> propMap;
    private Map<Integer, Double> fightPropMap;
    private int skillDepotId;
    private ArrayList<Integer> inherentProudSkillList;
    private Map<Integer, Integer> skillLevelMap;
    private ArrayList<EquipList> equipList;
    private Map<String, Integer> fetterInfo;

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public Map<Integer, PropMap> getPropMap() {
        return propMap;
    }

    public void setPropMap(Map<Integer, PropMap> propMap) {
        this.propMap = propMap;
    }

    public Map<Integer, Double> getFightPropMap() {
        return fightPropMap;
    }

    public void setFightPropMap(Map<Integer, Double> fightPropMap) {
        this.fightPropMap = fightPropMap;
    }

    public int getSkillDepotId() {
        return skillDepotId;
    }

    public void setSkillDepotId(int skillDepotId) {
        this.skillDepotId = skillDepotId;
    }

    public ArrayList<Integer> getInherentProudSkillList() {
        return inherentProudSkillList;
    }

    public void setInherentProudSkillList(ArrayList<Integer> inherentProudSkillList) {
        this.inherentProudSkillList = inherentProudSkillList;
    }

    public Map<Integer, Integer> getSkillLevelMap() {
        return skillLevelMap;
    }

    public void setSkillLevelMap(Map<Integer, Integer> skillLevelMap) {
        this.skillLevelMap = skillLevelMap;
    }

    public ArrayList<EquipList> getEquipList() {
        return equipList;
    }

    public void setEquipList(ArrayList<EquipList> equipList) {
        this.equipList = equipList;
    }

    public Map<String, Integer> getFetterInfo() {
        return fetterInfo;
    }

    public void setFetterInfo(Map<String, Integer> fetterInfo) {
        this.fetterInfo = fetterInfo;
    }
}
