package org.genshin.model;

public class PropMap {
    public PropMap(Integer type, String ival, String val) {
        this.type = type;
        this.ival = ival;
        this.val = val;
    }

    private Integer type;
    private String ival;
    private String val;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIval() {
        return ival;
    }

    public void setIval(String ival) {
        this.ival = ival;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "PropMap{" +
                "type=" + type +
                ", ival='" + ival + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
