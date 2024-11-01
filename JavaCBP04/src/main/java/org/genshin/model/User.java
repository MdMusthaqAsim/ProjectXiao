package org.genshin.model;

import java.util.*;

public class User {

    public User(PlayerInfo playerInfo, ArrayList<AvatarInfoList> avatarInfoList, int ttl, String uid, Owner owner) {
        this.playerInfo = playerInfo;
        this.avatarInfoList = avatarInfoList;
        this.ttl = ttl;
        this.uid = uid;
        this.owner = owner;
    }

    private PlayerInfo playerInfo; //done
    private ArrayList<AvatarInfoList> avatarInfoList;
    private int ttl; //done
    private String uid; //done
    private Owner owner; //done

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public ArrayList<AvatarInfoList> getAvatarInfoList() {
        return avatarInfoList;
    }

    public void setAvatarInfoList(ArrayList<AvatarInfoList> avatarInfoList) {
        this.avatarInfoList = avatarInfoList;
    }
}
