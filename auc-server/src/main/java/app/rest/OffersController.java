package app.rest;

import app.exceptions.PreConditionFailed;
import app.exceptions.ResourceNotFoundException;
import app.models.Offer;
import app.repositories.EntityRepository;
import app.views.ViewClasses;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    EntityRepository<Offer> offersRepository;

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


    @PutMapping(value = "{id}")
    public ResponseEntity<Offer> saveOffer(@PathVariable long id ,@RequestBody Offer offer) {

        Offer savedOffer = offersRepository.save(offer);

        if (id != offer.getId()) {
            throw new PreConditionFailed("Offer id " + id + " does not match the id of the game in the body");
        }

        if (savedOffer != null) {
            return ResponseEntity.ok().body(savedOffer);
        } else throw new ResourceNotFoundException("Game with id " + id + " not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Offer> deleteOffer(@PathVariable long id){
        Offer offer = offersRepository.deleteById(id);
        if (offer != null) {
            return ResponseEntity.ok().body(offer);
        } else throw new ResourceNotFoundException("Game with id " + id + " not found");
    }

    @JsonView(ViewClasses.Summary.class)
    @GetMapping("/summary")
    public List<Offer> getOffersSummary() {
        return offersRepository.findAll();

    }

}
