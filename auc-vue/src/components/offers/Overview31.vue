<template>

  <div class="offer-table">
    <h1>Offers</h1>
    <table>
      <tr >
        <th>Id:</th>
        <th>Title:</th>
        <th>Status:</th>
        <th>Description:</th>
        <th>Sell Date:</th>
        <th>Value Highest Bid:</th>
      </tr>
      <tr v-for="offer in offers" :key="offer.id">
        <td>{{ offer.id }}</td>
        <td>{{ offer.title }}</td>
        <td>{{ offer.status }}</td>
        <td>{{ offer.description}}</td>
        <td>{{ offer.sellDate}}</td>
        <td v-if="offer.status === 'NEW' ? '' :offer ">{{ offer.valueHighestBid }}</td>
        <td v-else>-</td>
      </tr>
    </table>
    <button @click="onNewOffer" class="offerButton">New Offer</button>
  </div>

</template>

<script>
import {Offer} from "@/models/offer.js";

export default {
  name: "Overview31",
  methods: {
    onNewOffer(){
      this.lastUsedId += 3;
      this.offers.push(Offer.createSampleOffer(this.lastUsedId))
    }
  },
  data() {
    return {
      offers: [],
      lastUsedId: 30000
    }

  },
  created() {
    for (let i = 0; i < `8`; i++) {
      this.lastUsedId += 3;
      this.offers.push(Offer.createSampleOffer(this.lastUsedId))
    }
  }
}
</script>

<style scoped>
.offer-table{
  flex: 4;
  flex-wrap: wrap;
  margin: 10px;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

th {
  background-color: #E0B0FF;
  /*border: 1px solid #dddddd;*/
  text-align: left;
  padding: 8px;
}

td {
  border: 1px solid black;
  text-align: center;
  padding: 3px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

button.offerButton{
  flex: 1;
  flex-wrap: wrap;
  float: right;
  background-color: #E0B0FF;
  color: #7F00FF;
  border-color: #E0B0FF;
  border-radius: 5px;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>