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
        const offer = await this.fetchJson(this.resourceUrl + "/" + id);
        return Offer.copyConstructor(offer)
    }

    async asyncSave(offer){
        const offerParam = await this.fetchJson(this.resourceUrl + "/" + offer.id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(offer)
        });

        return Offer.copyConstructor(offerParam)
    }
    async asyncDeleteById(id){
        const offerParam = await this.fetchJson(this.resourceUrl + "/" + id, {
            method: 'DELETE'
        });

        return Offer.copyConstructor(offerParam)
    }
}