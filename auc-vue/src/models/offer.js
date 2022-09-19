export class Offer {
    id;
    title;
    status;
    description;
    sellDate;
    valueHighestBid;

    constructor(id, title, status, description, sellDate, valueHighestBid) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.description = description;
        this.sellDate = sellDate;
        this.valueHighestBid = valueHighestBid;
    }

    static createSampleOffer(pId = 0) {
        const title = Offer ${pId};
        const status = ["NEW", "FOR_SALE", "SOLD", "PAID", "DELIVERED", "CLOSED", "EXPIRED", "WITHDRAWN"];
        const description = (Math.random() + 1).toString(36).substring(7);
        const sellDate = new Date();
        const valueHighestBid = Math.floor(Math.random() * 1000);

        return new Offer(pId, title, status[Math.floor(Math.random() * status.length)], description, sellDate, valueHighestBid);
    }

// (Math.random() + 1).toString(36).substring(7);

    static StatusEnum = {
        NEW: "NEW",
        FOR_SALE: "FOR_SALE",
        SOLD: "SOLD",
        PAID: "PAID",
        DELIVERED: "DELIVERED",
        CLOSED: "CLOSED",
        EXPIRE: "EXPIRE",
        WITHDRAWN: "WITHDRAWN"
    }
}