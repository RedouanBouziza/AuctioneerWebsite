import {Offer} from "@/models/offer";

export class OffersAdaptor {
    resourceUrl;
    constructor(resourceUrl) {
        this.resourceUrl = resourceUrl;
        console.log("Created OffersAdaptor for " + resourceUrl);
    }

    async fetchJson (url, options = null){
        let response = await fetch(url, options)
        if(response.ok){
            return await response.json();
        } else {
            console.log(response, !response.bodyUsed ? await response.text() : "");
            return null;
        }
    }

    async asyncFindAll(){
        const offers = await this.fetchJson(this.resourceUrl);
        return offers?.map(s => Offer.copyConstructor(s));
    }

    async asyncFindById(id){
        const offer = await this.fetchJson(this.resourceUrl + "/" + id, 'GET')
        return Offer.copyConstructor(offer)
    }

    async asyncSave(offer){
        const offerParam = await this.fetchJson(this.resourceUrl + "/" + offer.id, 'POST', offer)
    }
    async asyncDeleteById(id){
        return await this.fetchJson(this.resourceUrl + "/" + id, 'DELETE')
    }
}