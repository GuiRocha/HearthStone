package com.guilherm.hearthstone.model;

public enum Tipo {
    MAGIA(1),
    CRIATURA(2);
    private int code;


    Tipo(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Tipo valueOf(int code) {
        for (Tipo value : Tipo.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("invalid tipo Code");
    }
}
