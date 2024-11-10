package org.genshin.model;

public class ShowAvatarInfoList {
    public ShowAvatarInfoList(Integer avatarId, Integer level, Integer energyType) {
        this.avatarId = avatarId;
        this.level = level;
        this.energyType = energyType;
    }

    private Integer avatarId;
    private Integer level;
    private Integer energyType;

    public Integer getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getEnergyType() {
        return energyType;
    }

    public void setEnergyType(Integer energyType) {
        this.energyType = energyType;
    }
}
