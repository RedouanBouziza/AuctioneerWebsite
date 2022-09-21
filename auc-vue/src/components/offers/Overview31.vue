<template>

  <div class="offer-table">
    <h1>All Scooters</h1>
    <table>
      <tr>
        <th>Id:</th>
        <th>Title:</th>
        <th>Status:</th>
        <th>Description:</th>
        <th>Sell Date:</th>
        <th>Value Highest Bid:</th>
      </tr>
      <tr v-for="(offer) in offers" :key="offer.id">
        <td>{{ this.lastUsedId++ }}</td>
        <td>{{ offer.title }}</td>
        <td>{{ offer.status }}</td>
        <td>{{ offer.description}}</td>
        <td v-if="offer.status === 'NEW' ? '' :offer ">{{ offer.status }}</td>
        <td v-else>0</td>
        <td>{{ offer.valueHighestBid + " €"}}</td>
      </tr>
    </table>
  </div>

</template>

<script>
import {Offer} from "@/models/offer.js";

export default {
  name: "Overview31",
  data() {
    return {
      offers: [],
      lastUsedId: null
    }

  },
  created() {
    this.lastUsedId = 30000;
    for (let i = 0; i < 8; i++) {
      this.lastUsedId = this.lastUsedId + 3;
      this.offers.push(Offer.createSampleOffer(this.lastUsedId))
    }
  }
}
</script>

<style scoped>

</style>