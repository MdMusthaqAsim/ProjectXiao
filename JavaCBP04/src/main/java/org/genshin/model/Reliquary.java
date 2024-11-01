package org.genshin.model;

import java.util.ArrayList;

public class Reliquary {
    public Reliquary(int level, int mainPropId, ArrayList<Integer> appendPropIdList) {
        this.level = level;
        this.mainPropId = mainPropId;
        this.appendPropIdList = appendPropIdList;
    }

    private int level;
    private int mainPropId;
    private ArrayList<Integer> appendPropIdList;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMainPropId() {
        return mainPropId;
    }

    public void setMainPropId(int mainPropId) {
        this.mainPropId = mainPropId;
    }

    public ArrayList<Integer> getAppendPropIdList() {
        return appendPropIdList;
    }

    public void setAppendPropIdList(ArrayList<Integer> appendPropIdList) {
        this.appendPropIdList = appendPropIdList;
    }
}
