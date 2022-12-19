package app.models;

import app.views.ViewClasses;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@NamedQueries({
        @NamedQuery(name="Offer_find_by_status",
                query = "select b from Offer b where b.status = ?1"),
        @NamedQuery(name="Offer_find_by_title",
                query = "select b from Offer b where b.title = ?1"),
        @NamedQuery(name="Offer_find_by_status_and_minBidValue",
                query = "select b from Offer b where b.status = ?1 and b.valueHighestBid > ?2"),
})
@Entity
@Table(name="OFFER")
public class Offer {

    @JsonView(ViewClasses.Summary.class)
    @Id
    @SequenceGenerator(name="offer_id_seq", initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_id_seq")
    private long id;
    @JsonView(ViewClasses.Summary.class)
    private String title;
    private String description;
    private LocalDate sellDate;
    @JsonView(ViewClasses.Summary.class)
    @Enumerated(EnumType.STRING)
    private Status status;
    private double valueHighestBid;

    @JsonManagedReference
    @OneToMany(mappedBy="offers", cascade = CascadeType.ALL)
    private List<Bid> bids = new ArrayList<>();

    public List<Bid> getBids() {
        return bids;
    }

    public Offer() {}

    public boolean associateBid(Bid bid) {
        if (bid == null || this.getBids().contains(bid)) {
            return false;
        }

        this.getBids().add(bid);
        bid.associateOffer(this);
        return true;
    }

    public boolean dissociateBid(Bid bid) {
        if (bid == null || this.getBids().contains(bid)) {
            return false;
        }

        this.getBids().remove(bid);
        return true;
    }

    public void addBid(Bid bid) {
        this.getBids().add(bid);
    }


    public enum Status{
        NEW, FOR_SALE, SOLD, PAID, DELIVERED, CLOSED, EXPIRED, WITHDRAWN;

        public static boolean isValid(String status) {
            for (Status s : Status.values()) {
                if (s.name().equals(status)) {
                    return true;
                }
            }
            return false;
        }
    }

    public Offer(long id, String title, String description, LocalDate sellDate, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.sellDate = sellDate;
        this.status = status;
    }

    public static Offer createSampleOffer(long id) {
        double min = 1.00;
        double max = 10.00;

        final String title = UUID.randomUUID().toString().substring(0, 10);
        final String description = "Some Article Sold at 202";
        final LocalDate sellDate = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
//        final double valueHighestBid = Math.floor(Math.random() * ((max - min) + 1)) + min;

        return new Offer(id, title, description, sellDate, getRandomStatus());
    }

    private static Offer.Status getRandomStatus() {
        double randomNumber = Math.floor(Math.random() * 9);
        return switch ((int) randomNumber) {
            case 1 -> Status.NEW;
            case 2 -> Status.FOR_SALE;
            case 3 -> Status.SOLD;
            case 4 -> Status.PAID;
            case 5 -> Status.DELIVERED;
            case 6 -> Status.CLOSED;
            case 7 -> Status.EXPIRED;
            default -> Status.WITHDRAWN;
        };
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public Status getStatus() {
        return status;
    }

    public double getValueHighestBid() {
        return valueHighestBid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setValueHighestBid(double valueHighestBid) {
        this.valueHighestBid = valueHighestBid;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }


}
