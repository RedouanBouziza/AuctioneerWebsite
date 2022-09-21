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
        <td v-if="offer.status === 'NEW' ? '' :offer ">{{ offer.sellDate }}</td>
        <td v-else>0</td>
        <td>{{ offer.valueHighestBid + " €"}}</td>
      </tr>
    </table>
    <button @click="newOffer" class="offerButton"> New Offer</button>
  </div>

</template>

<script>
import {Offer} from "@/models/offer.js";

export default {
  name: "Overview31",
  methods: {
    newOffer(){
      this.offers.push(Offer.createSampleOffer(this.lastUsedId))
    }
  },
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
.offer-table{
  flex: 4;
  flex-wrap: wrap;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

th {
  background-color: darkgoldenrod;
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

td {
  border: 1px solid black;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

button.offerButton{
  flex: 1;
  flex-wrap: wrap;
  float: right;
  background-color: yellow;
  color: red;
  border-color: yellow;
}
</style>