package com.eatrate.food.establishment;

import com.eatrate.food.review.Review;
import com.eatrate.enums.RestaurantType;

import java.util.ArrayList;
import java.util.List;

/**
 * Establishment: Представляет ресторан или кафе
 */
public class Establishment {

    protected String name;
    protected RestaurantType type;
    protected Location location;
    protected List<Review> reviews = new ArrayList<>();
    public static int establishmentCount = 0;

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReview(Review review) {
        this.reviews.add(review);
    }

    public int getCountReview() {
        if (reviews == null) {
            return 0;
        } else {
            return this.reviews.size();
        }
    }
}
