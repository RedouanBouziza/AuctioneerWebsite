package app.rest;

import app.exceptions.PreConditionFailed;
import app.exceptions.ResourceNotFoundException;
import app.models.Offer;
import app.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public Offer getOffersById(@PathVariable long id) {
        Offer scooter = offersRepository.findById(id);
        if (scooter == null){
            throw new ResourceNotFoundException("OfferId: " + id + " not found!");
        }

        return offersRepository.findById(id);
    }

    @PostMapping("")
    public Offer addOffer(@RequestBody Offer offer){

        if (Objects.equals(offer.getId(), "0")){
            offer.setId(Long.parseLong(UUID.randomUUID().toString()));
        }

        offersRepository.save(offer);
        return offer;
    }

    @PutMapping("/{id}")
    public Offer saveOffer(@PathVariable long id, @RequestBody Offer offer){
        Offer findOffer = offersRepository.findById(id);

        if (findOffer == null){
            throw new ResourceNotFoundException("OfferId: " + id + " not found!");
        }

        if (!(Objects.equals(findOffer.getId(), id))){
            throw new PreConditionFailed("OfferId: " + id + " not found!");
        }

        offersRepository.save(offer);
        return offer;
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable long id){
        Offer offer = offersRepository.findById(id);
        if (offer == null){
            throw new ResourceNotFoundException("OfferId: " + id + " not found!");
        }
        offersRepository.deleteById(id);
    }
}
