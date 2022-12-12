package app.rest;

import app.exceptions.PreConditionFailed;
import app.exceptions.BadRequest;
import app.exceptions.ResourceNotFoundException;
import app.models.Bid;
import app.models.Offer;
import app.repositories.EntityRepository;
import app.views.ViewClasses;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    EntityRepository<Bid> bidsRepository;

    @GetMapping("/test")
    public List<Offer> getTestOffers(){
        return List.of((
                new Offer(0, "Test-Offer-A", null, null, NEW)),
                new Offer(0, "Test-Offer-B", null, null, NEW));
    }

    @GetMapping(path = "", produces = "application/json")
    public List<Offer> getAllOffers(
            @RequestParam(name = "Status", required = false) String status,
            @RequestParam(name = "Title", required = false) String title,
            @RequestParam(name = "ValueHighestBid", required = false) Double valueHighestBid) {

        if (status != null) {
            if (!status.equals("NEW") &&
                    !status.equals("FOR_SALE") &&
                    !status.equals("SOLD") &&
                    !status.equals("PAID") &&
                    !status.equals("DELIVERED") &&
                    !status.equals("CLOSED") &&
                    !status.equals("EXPIRED") &&
                    !status.equals("WITHDRAWN")) {
                throw new BadRequest("Status: " + status + " is not a valid offer status");
            }
        }

        if (status != null && title != null && valueHighestBid != null) {
            throw new BadRequest("Cannot provide a combination of status, title and valueHighestBid query parameters");
        } else if (status != null && title != null) {
            throw new BadRequest("Cannot provide a combination of status and title query parameters");
        } else if (title != null && valueHighestBid != null) {
            throw new BadRequest("Cannot provide a combination of title and valueHighestBid query parameters");
        }

        if (status != null && title == null && valueHighestBid == null) {
            return offersRepository.findByQuery(
                    "Offer_find_by_status", Offer.Status.valueOf(status));
        } else if (title != null && valueHighestBid == null) {
            return offersRepository.findByQuery(
                    "Offer_find_by_title", title);
        } else if (status != null && valueHighestBid != null) {
            return offersRepository.findByQuery(
                    "Offer_find_by_status_and_minBidValue", Offer.Status.valueOf(status), valueHighestBid);
        } else {
            return offersRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    public Offer getOffersById(@PathVariable long id) {
        Offer offer = offersRepository.findById(id);
        if (offer == null){
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
        } else throw new ResourceNotFoundException("Offer with id " + id + " not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Offer> deleteOffer(@PathVariable long id){
        Offer offer = offersRepository.deleteById(id);
        if (offer != null) {
            return ResponseEntity.ok().body(offer);
        } else throw new ResourceNotFoundException("Offer with id " + id + " not found");
    }

    @JsonView(ViewClasses.Summary.class)
    @GetMapping("/summary")
    public List<Offer> getOffersSummary() {
        return offersRepository.findAll();
    }

    @Transactional
    @PostMapping(path = "/{id}/bids", produces = "application/json")
    public ResponseEntity<Bid> addBidToOffer (@PathVariable long id, @RequestBody Bid bid) {
        Offer offerToUpdate = offersRepository.findById(id);
        Bid newBid = bidsRepository.save(bid);

        if (!offerToUpdate.getStatus().equals(Offer.Status.FOR_SALE)){
            throw new PreConditionFailed("Offer with id " + id + " is already sold");
        }

        if (newBid.getBidValue() <= offerToUpdate.getValueHighestBid()){
            throw new PreConditionFailed("Bid amount is lower than current price");
        }

        newBid.associateOffer(offerToUpdate);
        offerToUpdate.setValueHighestBid(newBid.getBidValue());

        return ResponseEntity.ok().body(newBid);
    }

}
