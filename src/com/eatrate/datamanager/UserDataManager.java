package com.eatrate.datamanager;

import com.eatrate.user.User;

import java.io.*;
import java.util.Scanner;

/**
 * UserDataManager: Отвечает за запись, чтение, удаление содержимго файла
 */
public class UserDataManager {
    private static final String USERS_FILE_NAME = "users.csv";

    /**
     * регестрируем нового пользователя
     */
    public void registerNewUser(User user) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE_NAME, true))) {
            writer.write(user.getUsername() + ":" + user.getPassword());
            writer.newLine();
        }
    }

    /**
     * Авторизация пользователя в системе
     */
    public boolean userAuthorization(User user) throws FileNotFoundException {
        File file = new File(USERS_FILE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] userInfo = scanner.nextLine().split(":");
            if (user.getUsername().equals(userInfo[0]) && user.getPassword().equals(userInfo[1])) {
                return true;
            }
        }
        return false;
    }


    /**
     * проверяем на существование пользователя в файле
     */
    public boolean isUserExists(String username) throws FileNotFoundException {
        File file = new File(USERS_FILE_NAME);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String[] usersInfo = scanner.nextLine().split(":");
            if (username.equals(usersInfo[0])) {
                return true;
            }
        }
        return false;
    }
}
