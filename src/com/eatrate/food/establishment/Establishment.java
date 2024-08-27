package com.eatrate.food.establishment;

import com.eatrate.food.review.Review;
import com.eatrate.enums.RestaurantType;

/**
 * Establishment: Представляет ресторан или кафе
 */
public class Establishment {

    protected String name;
    protected RestaurantType type;
    protected Location location;
    protected Review[] review;

    public Establishment(String name, RestaurantType type, Location location) {
        this.name = name;
        this.type = type;
        this.location = location;
    }

    /**
     * Отправить отзыв
     */
    public void submitReview() {

    }

    /**
     * Рассчитать средний рейтинг
     */
    public double calculateAverageRating() {
        return 0;
    }

    /**
     * Обновить детали
     */
    public void updateDetails() {

    }

    /**
     * Удалить продовольственное заведение
     */
    public void removeFoodEstablishment() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestaurantType getType() {
        return type;
    }

    public void setType(RestaurantType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Review[] getReview() {
        return review;
    }

    public void setReview(Review[] review) {
        this.review = review;
    }

    public int getCountReview() {
        if (review == null) {
            return 0;
        } else {
            return this.review.length;
        }
    }
}
