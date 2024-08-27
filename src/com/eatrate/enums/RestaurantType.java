package com.eatrate.enums;

public enum RestaurantType {
    RESTAURANT("Ресторан"),
    CAFE("Кафе"),
    BAR("Бар"),
    BAKERY("Пекарня"),
    LIBRARY("Библиотека"),
    MUSEUM("Музей"),
    CINEMA("Кинотеатр"),
    GYM("Спортзал"),
    PARK("Парк"),
    HOTEL("Отель"),
    MALL("Торговый центр"),
    PHARMACY("Аптека"),
    HOSPITAL("Больница"),
    SCHOOL("Школа"),
    UNIVERSITY("Университет"),
    THEATER("Театр");

    private final String name;

    RestaurantType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void printRestaurantTypesInColumns() {
        RestaurantType[] types = RestaurantType.values();
        int columns = 4;
        int rows = (types.length + columns - 1) / columns;
        int width = 25;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int index = i + j * rows;
                if (index < types.length) {
                    System.out.printf("%-25s", (index + 1) + ". " + types[index].getName());
                } else {
                    System.out.printf("%-25s", "");
                }
            }
            System.out.println();
        }
    }
}
