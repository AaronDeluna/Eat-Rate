package com.eatrate.user;

import com.eatrate.food.review.Review;

import java.util.Scanner;

/**
 * User: Представляет пользователя системы
 */
public class User {
    private String username;
    private String password;
    private Review[] reviews;
    private Scanner scanner = new Scanner(System.in);

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public void setReviews(Review[] reviews) {
        this.reviews = reviews;
    }
}
