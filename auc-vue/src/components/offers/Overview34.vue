<template>
  <div class="content">
    <div class="left-section">
      <table>
        <tr class="topSide">
          <th>id:</th>
          <th>Title:</th>
        </tr>

        <tr class="show" v-for="(offer) in offers" :key="offer.id" @click="onSelect(offer)" :class="{ highlight: offer === this.getSelectedOffer() } ">

          <td> {{ offer.id }}</td>
          <td>{{ offer.title }}</td>
        </tr>
      </table>
      <button class="add-offer" @click="onNewOffer">New Offer</button>
    </div>
    <div class="right-section">
      <p v-if="selectedOffer === null">Select a offer from the list at the left</p>
      <router-view v-else :offer="getSelectedOffer()" @delete="deleteOffer(selectedOffer.title)"
                   @saveOffer="saveOffer" @deselect="selectedOffer = null">
      </router-view>
    </div>
  </div>
</template>

<script>
import {Offer} from "@/models/offer";

export default {
  name: "Overview33Component",

  data() {
    return {
      lastId: 30000,
      selectedOffer: null,
      selectedId: null,
      offers: [],

    }
  },
  created() {
    for (let i = 0; i < 8; i++) {
      this.offers.push(Offer.createSampleOffer(this.lastId++))
    }
  },
  watch: {
    '$route'() {
      // extracts the selected offer-id from the route, each time when the route has changed
      this.selectedOffer = this.findSelectedFromRouteParams(this.$route);
    }
  },
  methods: {
    onNewOffer(){
      let offer = Offer.createSampleOffer(this.lastId++);
      this.offers.push(offer);
      this.selectedOffer = offer;
      console.log(this.selectedOffer)
      this.$router.push(this.$route.matched[0].path + "/" + this.selectedOffer.id);

      // this.$router.push(('/overview34/' + this.selectedOffer.title))
    },

    onSelect(offer) {
      this.selectedId = offer.id;
      console.log(offer)
      console.log("dit is onselect")
      // let parentPath = this.$route?.fullPath.replace(new RegExp("/\\d*$"), '');
      if (offer !== this.selectedOffer) {
        this.selectedOffer = offer;
        this.$router.push(this.$route.matched[0].path + "/" + offer.id);
      } else if (this.selectedOffer != null) {
        this.$router.push(this.$route.matched[0].path + "/");
        this.selectedOffer = null;
      }
    },

    deleteOffer(title){
      if(confirm('Are you sure you want to delete this offer?')){
        this.offers = this.offers.filter(offer => offer.title !== title)
        this.selectedOffer = null
        this.$router.push(this.$route.matched[0].path + "/")
      }
    },

    saveOffer(copyOffer){
      let index = this.offers.findIndex(currentOffer => currentOffer.id === copyOffer.id);
      this.offers[index] = copyOffer;
      this.selectedOffer.title = copyOffer.title;
      this.selectedOffer.status = copyOffer.status;
      this.selectedOffer.description = copyOffer.description;
      this.selectedOffer.sellDate = copyOffer.sellDate;
      this.selectedOffer.valueHighestBid = copyOffer.valueHighestBid;
    },

    findSelectedFromRouteParams(route) {
            return this.offers.find(value => value.id === parseInt(route.params.id)) ;
    },

    getSelectedOffer() {
      return this.selectedOffer
    }
  },

}
</script>

<style scoped>

.content{
  display: flex;
}

.left-section{
  /*border: 2px solid black;*/
  flex: 1;
}

.right-section{
  /*border: 2px solid black;*/
  flex: 1;
}

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 25%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 3%;
}

th {
  background-color: #E0B0FF;
  text-align: center;
  padding: 8px;
}

.topSide {
  border: 1px solid black;
}

td {
  border: 1px solid black;
  text-align: center;
  padding: 8px;
}

.add-offer{
  background-color: #E0B0FF;
  color: #7F00FF;
  border-color: #E0B0FF;
  width: 20%;
  margin-left: 40%;
  margin-top: 5px;
  border-radius: 5px;
  margin-bottom: 15px;
}

.highlight {
  background-color: #7F00FF;
}

</style>