package app.repositories.impl;

import app.models.Offer;
import app.repositories.OffersRepository;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class OffersRepositoryMock implements OffersRepository {

    private List<Offer> offerList = new ArrayList<>();

    public Offer createSampleOffer(String id) {

        double min = 0.0;
        double max = 50.0;

        // create random String
        final String title = UUID.randomUUID().toString().substring(0, 10);
        final String description = "Some Article Sold at 202";
        final double valueHighestBid = (Math.random() * ((max - min) + 1)) + min;
        final Date sellDate =  Math.floor(Math.random() * ());

        return new Offer(id, title, description, sellDate, getRandomStatus(), valueHighestBid);
    }

    private Offer.Status getRandomStatus() {
        double randomNumber = Math.floor(Math.random() * 9);
        // change status
        if (randomNumber < 3) {
            return Offer.Status.FOR_SALE;
        } else if (randomNumber < 6 && randomNumber > 3) {
            return Offer.Status.NEW;
        }
        return Offer.Status.WITHDRAWN;
    }

    @Override
    public List<Offer> findAll() {
        for (int i = 0; i < 7; i++) {
            offerList.add(createSampleOffer(UUID.randomUUID().toString()));
        }
        return offerList;
    }
}
