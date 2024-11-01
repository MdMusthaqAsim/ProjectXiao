package org.genshin.model;

public class ReliquarySubstats {
    public ReliquarySubstats(String appendPropId, double statValue) {
        this.appendPropId = appendPropId;
        this.statValue = statValue;
    }

    private String appendPropId;
    private double statValue;

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
