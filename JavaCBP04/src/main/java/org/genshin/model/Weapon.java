package org.genshin.model;

import java.util.Map;

public class Weapon {
    public Weapon(int level, int promoteLevel, Map<Integer, Integer> affixMap) {
        this.level = level;
        this.promoteLevel = promoteLevel;
        this.affixMap = affixMap;
    }

    private int level;
    private int promoteLevel;
    private Map<Integer, Integer> affixMap;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPromoteLevel() {
        return promoteLevel;
    }

    public void setPromoteLevel(int promoteLevel) {
        this.promoteLevel = promoteLevel;
    }

    public Map<Integer, Integer> getAffixMap() {
        return affixMap;
    }

    public void setAffixMap(Map<Integer, Integer> affixMap) {
        this.affixMap = affixMap;
    }
}
