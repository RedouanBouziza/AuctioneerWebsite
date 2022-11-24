package app.models;

import app.views.ViewClasses;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.UUID;

@Entity
public class Offer {

    @JsonView(ViewClasses.Summary.class)
    @Id
    @GeneratedValue
    private long id;
    @JsonView(ViewClasses.Summary.class)
    private String title;
    private String description;
    private LocalDate sellDate;
    @JsonView(ViewClasses.Summary.class)
    private Status status;
    private double valueHighestBid;

    public Offer() {

    }

    public enum Status{
        FOR_SALE, WITHDRAWN, NEW
    }

    public Offer(long id, String title, String description, LocalDate sellDate, Status status, double valueHighestBid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.sellDate = sellDate;
        this.status = status;
        this.valueHighestBid = valueHighestBid;
    }

    public static Offer createSampleOffer(long id) {

        double min = 0.0;
        double max = 50.0;

        final String title = UUID.randomUUID().toString().substring(0, 10);
        final String description = "Some Article Sold at 202";
        final LocalDate sellDate = LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
        final double valueHighestBid = (Math.random() * ((max - min) + 1)) + min;

        return new Offer(id, title, description, sellDate, getRandomStatus(), valueHighestBid);
    }

    private static Offer.Status getRandomStatus() {
        double randomNumber = Math.floor(Math.random() * 9);
        // change status
        if (randomNumber < 3) {
            return Offer.Status.FOR_SALE;
        } else if (randomNumber < 6 && randomNumber > 3) {
            return Offer.Status.NEW;
        }
        return Offer.Status.WITHDRAWN;
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
}
