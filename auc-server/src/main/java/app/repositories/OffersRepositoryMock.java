package app.repositories;

import app.models.Offer;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class OffersRepositoryMock implements OffersRepository {

    private List<Offer> offerList = new ArrayList<>();

    public OffersRepositoryMock() {
        for (int i = 0; i < 7; i++) {
            offerList.add(Offer.createSampleOffer(1 + i));
        }
    }

    @Override
    public List<Offer> findAll() {
        return this.offerList;
    }


    @Override
    public Offer findByIdOffer(long id) {
        return this.offerList.stream().filter(offer -> Objects.equals(offer.getId(), id)).findFirst().orElse(null);
    }

    public long newId() {
        return this.offerList.stream().mapToLong(Offer::getId).max().orElse(0) + 1;
    }

    @Override
    public Offer save(Offer offer) {

        if (offer.getId() == 0 && offer.getTitle() == null) {
            offer = Offer.createSampleOffer((int)newId());
            this.offerList.add(offer);
            return offer;
        }

        if (offer.getId() == 0 || this.findByIdOffer(offer.getId()) == null) {
            offer.setId(newId());
            this.offerList.add(offer);
        } else {
            Offer offerToUpdate = findByIdOffer(offer.getId());
            if (offerToUpdate != null) {
                offerToUpdate.setTitle(offer.getTitle());
                offerToUpdate.setDescription(offer.getDescription());
                offerToUpdate.setSellDate(offer.getSellDate());
                offerToUpdate.setStatus(offer.getStatus());
                offerToUpdate.setValueHighestBid(offer.getValueHighestBid());
            }
        }
        return offer;
    }

    @Override
    public Offer deleteById(long id) {
        Offer offer = this.findByIdOffer(id);
        this.offerList.remove(offer);
        return offer;
    }



}
