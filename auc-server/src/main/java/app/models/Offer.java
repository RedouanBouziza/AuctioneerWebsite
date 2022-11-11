package app.models;


import java.util.Date;

public class Offer {

    private String id;
    private String title;
    private String description;
    private Date sellDate;
    private Status status;
    private double valueHighestBid;

    public enum Status{
        FOR_SALE, WITHDRAWN, NEW
    }

    public Offer(String id, String title, String description, Date sellDate, Status status, double valueHighestBid) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.sellDate = sellDate;
        this.status = status;
        this.valueHighestBid = valueHighestBid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public Status getStatus() {
        return status;
    }

    public double getValueHighestBid() {
        return valueHighestBid;
    }
}
