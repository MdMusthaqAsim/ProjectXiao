package org.genshin.model;

public class SetEffect {
    public SetEffect(String artSet, String statName, Double statChange) {
        this.artSet = artSet;
        this.statName = statName;
        this.statChange = statChange;
    }

    private String artSet;
    private String statName;
    private Double statChange;

    public String getArtSet() {
        return artSet;
    }

    public void setArtSet(String artSet) {
        this.artSet = artSet;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public Double getStatChange() {
        return statChange;
    }

    public void setStatChange(Double statChange) {
        this.statChange = statChange;
    }
}
