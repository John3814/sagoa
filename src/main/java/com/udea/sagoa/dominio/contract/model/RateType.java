package com.udea.sagoa.dominio.contract.model;

public enum RateType {
    RESIDENTIAL("Residential"),
    COMMERCIAL("Commercial"),
    INDUSTRIAL("Industrial");

    private final String description;

    RateType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}