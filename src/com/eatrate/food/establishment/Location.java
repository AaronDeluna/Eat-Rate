package com.eatrate.food.establishment;

/**
 * Location: Представляет локацию места
 * названиеЗаведения/названиеУлицы/номерУлицы/этаж
 */

public class Location {
    private String streetName;
    private int streetNumber;
    private int floor;

    public Location(String streetName, int streetNumber, int floor) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.floor = floor;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Адрес: " +
                "улица: " + streetName +
                ", номер: " + streetNumber +
                ", этаж: " + floor;
    }
}