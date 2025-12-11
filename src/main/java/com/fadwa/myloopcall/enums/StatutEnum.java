package com.fadwa.myloopcall.enums;

public enum StatutEnum {
    VALIDE("Validé"),
    ANNULATION("Annulation"),
    RAPPEL_YACINE("Rappel Yacine"),
    NRP("NRP");

    private final String displayName;

    StatutEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}