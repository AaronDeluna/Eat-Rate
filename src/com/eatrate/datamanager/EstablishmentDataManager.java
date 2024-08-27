package com.eatrate.datamanager;

import com.eatrate.enums.RestaurantType;
import com.eatrate.food.establishment.Establishment;
import com.eatrate.food.establishment.Location;
import com.eatrate.food.review.Review;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EstablishmentDataManager {
    private static final String FILE_NAME = "establishment.txt";
    private static final int CORRECT_DATA_LENGTH = 6;
    private static final int ESTABLISHMENT_NAME = 0;
    private static final int ESTABLISHMENT_TYPE = 1;
    private static final int STREET_NAME = 2;
    private static final int STREET_NUMBER = 3;
    private static final int FLOOR = 4;
    private static final int REVIEW = 5;

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
                    ":" + establishment.getReviews() +
                    ":" + establishment.getCountReview());
            writer.newLine();
            Establishment.establishmentCount++;
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

    public Establishment getByNameEstablishment(String name) throws FileNotFoundException {
        File file = new File(FILE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] establishmentInfo = scanner.nextLine().split(":");
            if (establishmentInfo[ESTABLISHMENT_NAME].equals(name)) {
                Location location = new Location(
                        establishmentInfo[STREET_NAME],
                        Integer.parseInt(establishmentInfo[STREET_NUMBER]),
                        Integer.parseInt(establishmentInfo[FLOOR])
                );
                RestaurantType restaurantType = RestaurantType.valueOf(establishmentInfo[ESTABLISHMENT_TYPE].toUpperCase());
                return new Establishment(establishmentInfo[ESTABLISHMENT_NAME], restaurantType, location);
            }
        }
        return null;
    }

    public boolean isEstablishmentCorrect(String nameEstablishment) throws FileNotFoundException {
        File file = new File(FILE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] establishmentInfo = scanner.nextLine().split(":");
            if (establishmentInfo[ESTABLISHMENT_NAME].equals(nameEstablishment)) {
                return true;
            }
        }
        return false;
    }


    public boolean updateEstablishmentWithReview(String nameEstablishment, Review review) throws IOException {
        List<String> lines = new ArrayList<>();
        boolean isUpdated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(nameEstablishment)) {
                    String[] parts = line.split(":");

                    if (parts.length == CORRECT_DATA_LENGTH && parts[REVIEW].equals("null")) {
                        line =  parts[ESTABLISHMENT_NAME] + ":" + parts[ESTABLISHMENT_TYPE] +
                                ":" + parts[STREET_NAME] + ":" + parts[STREET_NUMBER] + ":" + parts[FLOOR] +
                                ":" + review.getAuthor() + ":" + review.getTelephoneNumber() +
                                ":" + review.getRating() + ":" + review.getComment();
                    } else {
                        line += "|" + review.getAuthor() + ":" + review.getTelephoneNumber() +
                                ":" + review.getRating() + ":" + review.getComment();
                    }
                    isUpdated = true;
                }
                lines.add(line);
            }
        }

        if (isUpdated) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
                return true;
            }
        }

        return false;
    }
}
