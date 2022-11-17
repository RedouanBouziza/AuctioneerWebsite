package app.repositories.impl;

import app.models.Offer;
import app.repositories.OffersRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class OffersRepositoryMock implements OffersRepository {

    private List<Offer> offerList = new ArrayList<>();

    public OffersRepositoryMock() {
        for (int i = 0; i < 7; i++) {
            offerList.add(createSampleOffer(UUID.randomUUID().toString()));
        }
    }

    public static Offer createSampleOffer(String s) {

        double min = 0.0;
        double max = 50.0;

        final long id = (long) Math.floor(Math.random() * (3000 - 1 + 1));
        final String title = UUID.randomUUID().toString().substring(0, 10);
        final String description = "Some Article Sold at 202";
        final LocalDate sellDate = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        final double valueHighestBid = (Math.random() * ((max - min) + 1)) + min;

        return new Offer(id, title, description, sellDate, getRandomStatus(), valueHighestBid);
    }

    private static Offer.Status getRandomStatus() {
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
        return this.offerList;
    }

    @Override
    public Offer findById(long id) {
        return this.offerList.stream().filter(offer -> Objects.equals(offer.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public Offer save(Offer offer) {
        int index = IntStream.range(0, this.offerList.size()).
                filter(i -> Objects.equals(offer.getId(), this.offerList.get(i).getId())).
                findFirst().orElse(-1);

        if (index > -1){
            this.offerList.set(index, offer);
        } else {
            this.offerList.add(offer);
        }

        return offer;
    }

    @Override
    public void deleteById(long id) {
        this.offerList = this.offerList.stream().filter(offer -> !(Objects.equals(offer.getId(), id))).collect(Collectors.toList());
    }


}
