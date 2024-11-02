package org.genshin.model;

public class WeaponStats {
    public WeaponStats(String appendPropId, Double statValue) {
        this.appendPropId = appendPropId;
        this.statValue = statValue;
    }

    private String appendPropId;
    private Double statValue;

    public String getAppendPropId() {
        return appendPropId;
    }

    public void setAppendPropId(String appendPropId) {
        this.appendPropId = appendPropId;
    }

    public double getStatValue() {
        return statValue;
    }

    public void setStatValue(double statValue) {
        this.statValue = statValue;
    }
}
