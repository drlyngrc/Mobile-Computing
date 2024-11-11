package com.activity.mobcom.Domain;

public class FlagDomain {
    private String name;
    private int flagResId;

    public FlagDomain(String name, int flagResId) {
        this.name = name;
        this.flagResId = flagResId;
    }

    public String getName() {
        return name;
    }

    public int getFlagResId() {
        return flagResId;
    }
}
