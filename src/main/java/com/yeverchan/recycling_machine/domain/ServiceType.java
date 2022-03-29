package com.yeverchan.recycling_machine.domain;

public enum ServiceType {
    REWARD("reward"),
    PURCHASED("purchased"),
    SOLD("sold");

    private final String type;

    ServiceType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
