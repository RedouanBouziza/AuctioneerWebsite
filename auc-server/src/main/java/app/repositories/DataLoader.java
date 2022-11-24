package app.repositories;

import app.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("DataLoader.run()");
        this.createOffers();

    }

    @Autowired
    private EntityRepository<Offer> offerRepository;

    private void createOffers(){
        List<Offer> offers = offerRepository.findAll();

        if (offers.size() > 0) return;

        System.out.println("DataLoader.createOffers()");

        for (int i = 0; i < 10; i++) {
            Offer offer = Offer.createSampleOffer(i+1);
            this.offerRepository.save(offer);
        }
    }
}
