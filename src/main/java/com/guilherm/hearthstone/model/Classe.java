package com.guilherm.hearthstone.model;

public enum Classe {
    MAGO(1),
    PALADINO(2),
    CACADOR(2),
    DRUIDA(3),
    QUALQUER(4);

    private int code;

    Classe(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public static Classe valueOf(int code) {
        for (Classe value : Classe.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("invalid tipo Code");
    }
}
