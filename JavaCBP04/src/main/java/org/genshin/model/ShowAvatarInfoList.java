package org.genshin.model;

public class ShowAvatarInfoList {
    public ShowAvatarInfoList(int avatarId, int level, int energyType) {
        this.avatarId = avatarId;
        this.level = level;
        this.energyType = energyType;
    }

    private int avatarId;
    private int level;
    private int energyType;

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getEnergyType() {
        return energyType;
    }

    public void setEnergyType(int energyType) {
        this.energyType = energyType;
    }
}
