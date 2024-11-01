package org.genshin.model;

public class ReliquaryMainstat {
    public ReliquaryMainstat(String mainPropId, double statValue) {
        this.mainPropId = mainPropId;
        this.statValue = statValue;
    }

    private String mainPropId;
    private double statValue;

    public String getMainPropId() {
        return mainPropId;
    }

    public void setMainPropId(String mainPropId) {
        this.mainPropId = mainPropId;
    }

    public double getStatValue() {
        return statValue;
    }

    public void setStatValue(double statValue) {
        this.statValue = statValue;
    }
}
