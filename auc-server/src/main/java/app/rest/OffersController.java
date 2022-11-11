package app.rest;

import app.models.Offer;
import app.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static app.models.Offer.Status.NEW;

@CrossOrigin
@RestController
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private OffersRepository offersRepository;

    @GetMapping("/test")
    public List<Offer> getTestOffers(){
        return List.of((
                new Offer(0, "Test-Offer-A", null, null, NEW, 0.0)),
                new Offer(0, "Test-Offer-B", null, null, NEW, 0.0));
    }

    @GetMapping("")
    public List<Offer> getAllOffers() {
        return offersRepository.findAll();
    }

}
