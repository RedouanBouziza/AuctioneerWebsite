package app.repositories.impl;

import app.models.Offer;
import app.repositories.OffersRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class OffersRepositoryMock implements OffersRepository {

    private List<Offer> offerList = new ArrayList<>();

    public Offer createSampleOffer(String id) {

        double min = 0.0;
        double max = 50.0;
        Date randomDate = new Date();

        // create random String
        final String title = UUID.randomUUID().toString().substring(0, 10);
        final String description = "Some Article Sold at 202";
        final LocalDate sellDate = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        final double valueHighestBid = (Math.random() * ((max - min) + 1)) + min;

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
