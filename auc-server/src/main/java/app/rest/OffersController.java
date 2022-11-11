package app.rest;

import app.models.Offer;
import app.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class OffersController {

    @Autowired
    private OffersRepository offersRepository;

    @GetMapping("/offers/test")
    public List<Offer> getTestOffers() {
        return offersRepository.findAll();
    }
}
