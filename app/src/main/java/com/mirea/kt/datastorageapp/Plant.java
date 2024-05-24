package com.mirea.kt.datastorageapp;

public class Plant {
    private int id;
    private String name;
    private String variety;
    private boolean isGreenhousePlant;

    public Plant(int id, String name, String variety, boolean isGreenhousePlant) {
        this.id = id;
        this.name = name;
        this.variety = variety;
        this.isGreenhousePlant = isGreenhousePlant;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public boolean isGreenhousePlant() {
        return isGreenhousePlant;
    }

    public void setGreenhousePlant(boolean greenhousePlant) {
        isGreenhousePlant = greenhousePlant;
    }
}
