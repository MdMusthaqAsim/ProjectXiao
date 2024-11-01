package org.genshin.model;

public class EquipList {
    public EquipList(int itemId, Reliquary reliquary, Flat flat) {
        this.itemId = itemId;
        this.reliquary = reliquary;
        weapon = null;
        this.flat = flat;
    }

    public EquipList(int itemId, Weapon weapon, Flat flat) {
        this.itemId = itemId;
        this.weapon = weapon;
        reliquary = null;
        this.flat = flat;
    }

    private int itemId;
    private Reliquary reliquary;
    private Weapon weapon;
    private Flat flat;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Reliquary getReliquary() {
        return reliquary;
    }

    public void setReliquary(Reliquary reliquary) {
        this.reliquary = reliquary;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }
}
