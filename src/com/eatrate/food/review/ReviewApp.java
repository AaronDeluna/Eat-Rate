package com.eatrate.food.review;

import com.eatrate.user.User;
import com.eatrate.datamanager.RestaurantDataManager;
import com.eatrate.datamanager.UserDataManager;
import com.eatrate.enums.RestaurantType;
import com.eatrate.food.establishment.Establishment;
import com.eatrate.food.establishment.Location;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * ReviewApp: Основной класс, управляющий приложением
 */

public class ReviewApp {
    private UserDataManager userDataManager = new UserDataManager();
    private RestaurantDataManager restaurantDataManager = new RestaurantDataManager();
    public static int usersCount = 0;
    private User[] users;
    private Establishment[] establishments;
    private Review[] reviews;
    private Scanner scanner = new Scanner(System.in);

    private static final String NOT_CORRECT_MESSAGE = "-----\nДанные при вводе не корректны, попробуйте еще раз!\n-----";


    /**
     * Регистрация пользователя - вернет true после успешной регистрации пользовталя
     */
    public boolean registerUser() {
        while (true) {
            System.out.println("Введите username: ");
            String username = scanner.nextLine();
            System.out.println("Придумайте пароль: ");
            String password = scanner.nextLine();
            System.out.println("Повторите пароль: ");
            String confirmPassword = scanner.nextLine();

            if (isInputRegisterDataCorrect(username.trim(), password.trim(), confirmPassword.trim())) {
                return true;
            } else {
                System.out.println(NOT_CORRECT_MESSAGE);
            }
        }
    }


    /**
     * Авторизация пользователя - вернет true после успешной авторизации пользователя
     */
    public boolean loginUser() {
        while (true) {
            System.out.println("Введите логин: ");
            String username = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();

            try {
                if (userDataManager.userAuthorization(new User(username, password))) {
                    System.out.println("Авторизация прошла успешно!");
                    return true;
                } else {
                    System.out.println("username или password не корректны!");
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Проверка валидны ли данные при регистрации
     */
    private boolean isInputRegisterDataCorrect(String username, String password, String confirmPassword) {
        try {
            if (!username.isEmpty() && password.equals(confirmPassword) && !userDataManager.isUserExists(username)) {
                userDataManager.registerNewUser(new User(username, password));
                usersCount++;
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    /**
     * Добовляет новое заведение
     */
    public void addEstablishment() {
        while (true) {
            System.out.println("Укажите название заведения: ");
            String nameEstablishment = scanner.nextLine();
            System.out.println("Выберите тип заведения из указанных: ");
            RestaurantType.printRestaurantTypesInColumns();
            int establishmentType = getValidEstablishmentType();
            RestaurantType selectedType = RestaurantType.values()[establishmentType - 1];
            System.out.println("Укажите название улицы: ");
            String streetName = scanner.next();
            System.out.println("Укажите номер улицы(если есть): ");
            int streetNumber = scanner.nextInt();
            System.out.println("Укажите этаж: ");
            int floor = scanner.nextInt();
            Location location = new Location(streetName.trim(), streetNumber, floor);
            if (isEstablishmentInfoCorrect(location, nameEstablishment.trim())) {
                Establishment establishment = new Establishment(nameEstablishment.trim(), selectedType, location);

                try {
                    restaurantDataManager.createdNewRestaurant(establishment);
                    break;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(NOT_CORRECT_MESSAGE);
            }
        }
    }

    /**
     * Проверяет данные для добавления заведенья
     */
    public boolean isEstablishmentInfoCorrect(Location location, String nameEstablishment) {
        return !nameEstablishment.isEmpty() &&
                !location.getStreetName().isEmpty() &&
                location.getStreetNumber() >= 0 &&
                location.getFloor() >= 0;
    }

    /**
     * Проверяет корректность ввода и запрашивает ввод от пользователя
     */
    private int getValidEstablishmentType() {
        int establishmentType = -1;
        while (true) {
            System.out.println("Введите номер типа заведения (от 1 до " + RestaurantType.values().length + "): ");
            try {
                establishmentType = scanner.nextInt();
                if (establishmentType >= 1 && establishmentType <= RestaurantType.values().length) {
                    break;
                } else {
                    System.out.println("Ошибка: Введите число в диапазоне от 1 до " + RestaurantType.values().length + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Пожалуйста, введите корректное число.");
                scanner.next();
            }
        }

        return establishmentType;
    }



    public void viewAllEstablishment() {
        try {
            List<Establishment> establishmentList = restaurantDataManager.getAllEstablishment();
            for (Establishment establishment : establishmentList) {
                System.out.printf("Название заведенья: %s" +
                        ", Тип: %s" +
                        ", %s" +
                        ", Отзывов: %s шт.\n",
                        establishment.getName(),
                        establishment.getType().getName(),
                        establishment.getLocation(),
                        establishment.getCountReview());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    public void viewByNameEstablishment(String name) {

    }

    public void addReview() {

    }

    public void searchEstablishment() {

    }

    public void viewReviews() {

    }

    public UserDataManager getDataManager() {
        return userDataManager;
    }

    public void setDataManager(UserDataManager userDataManager) {
        this.userDataManager = userDataManager;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Establishment[] getRestaurants() {
        return establishments;
    }

    public void setRestaurants(Establishment[] establishments) {
        this.establishments = establishments;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }
}
