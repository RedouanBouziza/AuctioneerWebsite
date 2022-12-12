package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="BID")
public class Bid {

    @Id
    @SequenceGenerator(name="bid_id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bid_id_seq")
    private long id;
    private double bidValue;

    @JsonBackReference
    @ManyToOne
    private Offer offers;

    public Offer getOffers() {
        return offers;
    }

    public Bid() {}

    public boolean associateOffer(Offer offer) {
        if (offer == null || this.getOffers() != null) {
            return false;
        }

        offer.associateBid(this);
        this.setOffers(offer);
        return true;
    }

    public Bid(double bidValue) {
        this.bidValue = bidValue;
    }

    public Bid(long id, double bidValue) {
        this.id = id;
        this.bidValue = bidValue;
    }

    public static Bid createSampleBid(long id) {
        double min = 1.0;
        double max = 50.0;

        final double bidValue = Math.floor(Math.random() * ((max - min) + 1)) + min;
        return new Bid(id, bidValue);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBidValue() {
        return bidValue;
    }

    public void setBidValue(double bidValue) {
        this.bidValue = bidValue;
    }

    public void setOffers(Offer offers) {
        this.offers = offers;
    }

}
