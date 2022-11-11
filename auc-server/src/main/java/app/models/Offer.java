package app.models;


import java.time.LocalDate;
import java.util.Date;

public class Offer {

    private long id;
    private String title;
    private String description;
    private LocalDate sellDate;
    private Status status;
    private double valueHighestBid;

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
}
