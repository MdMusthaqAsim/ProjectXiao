package org.genshin.model;

public class ReliquarySubstats {
    public ReliquarySubstats(String appendPropId, Double statValue) {
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

    public Double getStatValue() {
        return statValue;
    }

    public void setStatValue(Double statValue) {
        this.statValue = statValue;
    }
}
