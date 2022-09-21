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

        // function randomDate(start, end) {
        //     return new Date(start.getTime() + Math.random() * (end.getTime() - start.getTime()));
        // }

        //return random title with math.random
        this.title = Math.random().toString(36).substring(7);
        this.status = ["NEW", "FOR_SALE", "SOLD", "PAID", "DELIVERED", "CLOSED", "EXPIRED", "WITHDRAWN"];
        this.description = (Math.random() + 1).toString(36).substring(7);
        // random date
        this.sellDate = new Date();
        // this.sellDate = randomDate(new Date(2012, 0, 1), new Date());
        this.valueHighestBid = Math.floor(Math.random() * 1000);

        return Object.assign(new Offer(), this.id , this.title, this.status[Math.floor(Math.random() * status.length)],
            this.description, this.sellDate, this.valueHighestBid)
    }


    // static StatusEnum = {
    //     NEW: "NEW",
    //     FOR_SALE: "FOR_SALE",
    //     SOLD: "SOLD",
    //     PAID: "PAID",
    //     DELIVERED: "DELIVERED",
    //     CLOSED: "CLOSED",
    //     EXPIRE: "EXPIRE",
    //     WITHDRAWN: "WITHDRAWN"
    // }
}