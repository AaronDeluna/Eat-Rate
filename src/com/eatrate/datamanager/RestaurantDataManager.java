package com.eatrate.datamanager;

import com.eatrate.enums.RestaurantType;
import com.eatrate.food.establishment.Establishment;
import com.eatrate.food.establishment.Location;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantDataManager {
    private static final String FILE_NAME = "establishment.txt";

    private static final int ESTABLISHMENT_NAME = 0;
    private static final int ESTABLISHMENT_TYPE = 1;
    private static final int STREET_NAME = 2;
    private static final int STREET_NUMBER = 3;
    private static final int FLOOR = 4;

    /**
     * Создание нового ресторана
     */
    public void createdNewRestaurant(Establishment establishment) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(establishment.getName() +
                    ":" + establishment.getType() +
                    ":" + establishment.getLocation().getStreetName() +
                    ":" + establishment.getLocation().getStreetNumber() +
                    ":" + establishment.getLocation().getFloor() +
                    ":" + Arrays.toString(establishment.getReview()) +
                    ":" + establishment.getCountReview());
            writer.newLine();
        }
    }

    public List<Establishment> getAllEstablishment() throws FileNotFoundException {
        List<Establishment> establishmentList = new ArrayList<>();
        File file = new File(FILE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] establishmentInfo = scanner.nextLine().split(":");
            Location location = new Location(
                    establishmentInfo[STREET_NAME],
                    Integer.parseInt(establishmentInfo[STREET_NUMBER]),
                    Integer.parseInt(establishmentInfo[FLOOR])
            );
            RestaurantType restaurantType = RestaurantType.valueOf(establishmentInfo[ESTABLISHMENT_TYPE].toUpperCase());
            establishmentList.add(new Establishment(establishmentInfo[ESTABLISHMENT_NAME], restaurantType, location));
        }
        return establishmentList;
    }

//    public Establishment getByNameEstablishment(String name) {
//
//    }


}
