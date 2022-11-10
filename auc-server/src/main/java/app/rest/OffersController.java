package app.rest;

import app.models.Offer;
import app.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class OffersController {

    @Autowired
    private OffersRepository offersRepository;

    @GetMapping("/offers/test")
    public List<Offer> getTestOffers() {
        return offersRepository.findAll();
    }
}
