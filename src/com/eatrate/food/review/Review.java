package com.eatrate.food.review;

/**
 * Review: Представляет отзыв пользователя.
 */

public class Review {
    private String author;
    private String telephoneNumber;
    private int rating;
    private String comment;

    public Review(String author, String telephoneNumber, int rating, String comment) {
        this.author = author;
        this.telephoneNumber = telephoneNumber;
        this.rating = rating;
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "author='" + author + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                '}';
    }
}
