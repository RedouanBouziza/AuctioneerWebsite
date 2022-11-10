package app.repositories.impl;

import app.models.Offer;
import app.repositories.OffersRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class OffersRepositoryMock implements OffersRepository {

    private List<Offer> offerList = new ArrayList<>();

    public Offer createSampleOffer(String id) {
        
        // create random String
        final String title = UUID.randomUUID().toString().substring(0, 10);
        // create random String
        final String description = UUID.randomUUID().toString().substring(0, 10);

        final double valueHighestBid = (Math.random() * .1 - .05) + 52.379189;
        final Date sellDate =

        return new Offer(id, title, description, sellDate, getRandomStatus(), valueHighestBid);
    }

    private Offer.Status getRandomStatus() {
        double randomNumber = Math.ceil(Math.random() * 9);
        // change status
        if (randomNumber < 3) {
            return Offer.Status.IN_USE;
        } else if (randomNumber < 6 && randomNumber > 3) {
            return Offer.Status.IDLE;
        }
        return Offer.Status.MAINTENANCE;
    }

    @Override
    public List<Offer> findAll() {
        for (int i = 0; i < 7; i++) {
            offerList.add(createSampleOffer(UUID.randomUUID().toString()));
        }
        return offerList;
    }
}
