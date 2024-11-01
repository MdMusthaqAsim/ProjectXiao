package org.genshin.model;

import java.util.ArrayList;

public class Flat {
    public Flat(String nameTextMapHash, Integer rankLevel, String itemType, String icon, String equipType, String setNameTextMapHash, ArrayList<WeaponStats> weaponStats, ArrayList<ReliquarySubstats> reliquarySubstats, ReliquaryMainstat reliquaryMainstat) {
        this.nameTextMapHash = nameTextMapHash;
        this.rankLevel = rankLevel;
        this.itemType = itemType;
        this.icon = icon;
        this.equipType = equipType;
        this.setNameTextMapHash = setNameTextMapHash;
        this.weaponStats = weaponStats;
        this.reliquarySubstats = reliquarySubstats;
        this.reliquaryMainstat = reliquaryMainstat;
    }

    private String nameTextMapHash;
    private Integer rankLevel;
    private String itemType;
    private String icon;
    private String equipType; //reliq exclusive
    private String setNameTextMapHash; //reliq exclusive
    private ArrayList<WeaponStats> weaponStats;
    private ArrayList<ReliquarySubstats> reliquarySubstats; //reliq exclusive
    private ReliquaryMainstat reliquaryMainstat; //reliq exclusive

    public String getNameTextMapHash() {
        return nameTextMapHash;
    }

    public void setNameTextMapHash(String nameTextMapHash) {
        this.nameTextMapHash = nameTextMapHash;
    }

    public int getRankLevel() {
        return rankLevel;
    }

    public void setRankLevel(int rankLevel) {
        this.rankLevel = rankLevel;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getSetNameTextMapHash() {
        return setNameTextMapHash;
    }

    public void setSetNameTextMapHash(String setNameTextMapHash) {
        this.setNameTextMapHash = setNameTextMapHash;
    }

    public ArrayList<WeaponStats> getWeaponStats() {
        return weaponStats;
    }

    public void setWeaponStats(ArrayList<WeaponStats> weaponStats) {
        this.weaponStats = weaponStats;
    }

    public ArrayList<ReliquarySubstats> getReliquarySubstats() {
        return reliquarySubstats;
    }

    public void setReliquarySubstats(ArrayList<ReliquarySubstats> reliquarySubstats) {
        this.reliquarySubstats = reliquarySubstats;
    }

    public ReliquaryMainstat getReliquaryMainstat() {
        return reliquaryMainstat;
    }

    public void setReliquaryMainstat(ReliquaryMainstat reliquaryMainstat) {
        this.reliquaryMainstat = reliquaryMainstat;
    }
}
