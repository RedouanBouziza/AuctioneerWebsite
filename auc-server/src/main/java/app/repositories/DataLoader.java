package app.repositories;

import app.models.Bid;
import app.models.Offer;
import app.models.User;
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
        this.createUsers();
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

        for (int i = 0; i < 6; i++) {
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

        for (int i = 0; i < 6; i++) {
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

    @Autowired
    private EntityRepository<User> usersRepository;

    private void createUsers(){
        List<User> users = usersRepository.findAll();

        users.add(this.usersRepository.save(new User(0L, "user1", "user1@test.nl")));
        System.out.println(users.get(0).toString());
        System.out.println("DataLoader.createUsers 99999999999999999999999999999()");
        users.add(this.usersRepository.save(new User(0L, "user2", "user2@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user3", "user3@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user4", "user4@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user5", "user5@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user6", "user6@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user7", "user7@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user8", "user8@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "user9", "user9@test.nl")));
        users.add(this.usersRepository.save(new User(0L, "Admin1", "admin1@test.nl")));

        for (User a : users) {
            a.setPassword("welcome");
            System.out.println("Added account: " + a + " (initial password = 'welcome')");
        }
        users.get(0).setRole("Administrator");
        users.get(1).setRole("Janitor");
    }

}
