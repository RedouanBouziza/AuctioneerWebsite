export class Offer {
    id;
    title;
    status;
    description;
    sellDate;
    valueHighestBid;

    constructor(id) {
        this.id = id;
        this.title = Offer.title;
        this.status = Offer.status;
        this.description = Offer.description;
        this.sellDate = Offer.sellDate;
        this.valueHighestBid = Offer.valueHighestBid;
    }

    static createSampleOffer(pId) {

        this.title = Math.random().toString(36).slice(4)
        let randomNumber = Math.floor(Math.random() * 9);

        this.description = (Math.random() + 1).toString(36).substring(7);
        if (randomNumber === 1) {
            this.status = 'NEW'
        } else if (randomNumber === 2) {
            this.status = 'FOR_SALE'
        } else if (randomNumber === 3) {
            this.status = 'SOLD';
        } else if (randomNumber === 4) {
            this.status = 'PAID';
        } else if (randomNumber === 5) {
            this.status = 'DELIVERED';
        } else if (randomNumber === 6) {
            this.status = 'CLOSED';
        } else if (randomNumber === 7) {
            this.status = 'EXPIRED';
        }else if (randomNumber === 8) {
            this.status = 'WITHDRAWN';
        }


        this.sellDate = new Date().toDateString()


        this.valueHighestBid = Math.floor(Math.random() * 1000);

        return new Offer(pId, this.title, this.status, this.description, this.sellDate, this.valueHighestBid)
    }

    static StatusEnum = {
        NEW: 'NEW',
        FOR_SALE: 'FOR_SALE',
        SOLD: 'SOLD',
        PAID: 'PAID',
        DELIVERED: 'DELIVERED',
        CLOSED: 'CLOSED',
        EXPIRED: 'EXPIRED',
        WITHDRAWN: 'WITHDRAWN'
    }

}