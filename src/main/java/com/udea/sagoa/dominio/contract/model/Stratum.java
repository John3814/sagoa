package com.udea.sagoa.dominio.contract.model;

public enum Stratum {
    STRATUM_1("Low-Low"),
    STRATUM_2("Low"),
    STRATUM_3("Middle-Low"),
    STRATUM_4("Middle"),
    STRATUM_5("Middle-High"),
    STRATUM_6("High");

    private final String description;

    Stratum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}