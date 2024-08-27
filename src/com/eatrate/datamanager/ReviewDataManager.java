package com.eatrate.datamanager;

import com.eatrate.food.establishment.Establishment;
import com.eatrate.food.review.Review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDataManager {
    private static final String FILE_NAME = "reviews.txt";
    private static final String ESTABLISHMENT_FILE_NAME = "establishment.txt";

    private static final int AUTHOR = 0;
    private static final int TELEPHONE_NUMBER = 1;
    private static final int RATING = 2;
    private static final int COMMENT = 3;

    public boolean createNewReview(String nameEstablishment, Review review) throws IOException {
        EstablishmentDataManager establishmentDataManager = new EstablishmentDataManager();
        Establishment establishment = establishmentDataManager.getByNameEstablishment(nameEstablishment);
        establishment.setReview(review);
        return establishmentDataManager.updateEstablishmentWithReview(nameEstablishment, review);
    }
}
