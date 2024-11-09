package org.genshin.model;

public class Damage {

    public Damage(Integer uid, Integer characterId, Double e, Double CD, Double LP, Double HP, Double DPR) {
        this.uid = uid;
        this.characterId = characterId;
        E = e;
        this.CD = CD;
        this.LP = LP;
        this.HP = HP;
        this.DPR = DPR;
    }

    private Integer uid;
    private Integer characterId;
    private Double E;
    private Double CD;
    private Double LP;
    private Double HP;
    private Double DPR;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    public Double getE() {
        return E;
    }

    public void setE(Double e) {
        E = e;
    }

    public Double getCD() {
        return CD;
    }

    public void setCD(Double CD) {
        this.CD = CD;
    }

    public Double getLP() {
        return LP;
    }

    public void setLP(Double LP) {
        this.LP = LP;
    }

    public Double getHP() {
        return HP;
    }

    public void setHP(Double HP) {
        this.HP = HP;
    }

    public Double getDPR() {
        return DPR;
    }

    public void setDPR(Double DPR) {
        this.DPR = DPR;
    }
}

