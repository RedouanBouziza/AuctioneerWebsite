package app.repositories;

import app.models.Bid;
import app.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

import static org.springframework.util.ClassUtils.getUserClass;

@Component
public class DataLoader implements CommandLineRunner {
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("DataLoader.run()");
        this.createOffers();
        this.createBids();

        System.out.println("Injected accounts from " +
                (this.offerRepository != null ? getUserClass(this.offerRepository.getClass()).getName() : "none"));
        System.out.println("Injected authors from " +
                (this.bidRepository != null ? getUserClass(this.bidRepository.getClass()).getName() : "none"));

    }

    @Autowired
    private EntityRepository<Offer> offerRepository;

    private void createOffers(){
        List<Offer> offers = offerRepository.findAll();

        if (offers.size() > 0) return;
        System.out.println("DataLoader.createOffers()");

        for (int i = 0; i < 10; i++) {
            Offer offer = Offer.createSampleOffer(0);
            this.offerRepository.save(offer);
        }
    }

    @Autowired
    private EntityRepository<Bid> bidRepository;

    private void createBids(){
        List<Bid> bids = bidRepository.findAll();
        List<Offer> offers = offerRepository.findAll();

        if (bids.size() > 0) return;
        System.out.println("DataLoader.createBids()");

        for (int i = 0; i < 10; i++) {
            Bid bid = Bid.createSampleBid(0);

            Offer randomOffer = offers.get(new Random().nextInt(offers.size()));

            bid.associateOffer(randomOffer);
            randomOffer.setValueHighestBid(bid.getBidValue());

            this.bidRepository.save(bid);

            int index = offers.indexOf(randomOffer);
            offers.get(index).addBid(bid);

            offers.remove(randomOffer);
        }
    }
}
