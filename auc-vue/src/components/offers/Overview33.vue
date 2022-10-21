<template>
  <div class="content">
    <div class="left-section">
      <table>
        <tr class="topSide">
          <th>id:</th>
          <th>Title:</th>
        </tr>
        <tr class="show" v-on:click="onSelect(offer)" v-for="(offer) in offers" :key="offer.id" @click.prevent="selectOffer(offer.title)" :class="{ highlight: offer === this.getSelectedOffer() } ">

          <td> {{ offer.id }}</td>
          <td> {{ offer.title }}</td>

        </tr>
      </table>
      <button class="add-offer" @click="onNewOffer">New Offer</button>
    </div>
    <div class="right-section">
      <p v-if="selectedOffer === null">Select a Offer from the list at the left</p>
      <Detail33 v-else :selected-offer="selectedOffer" @delete-offer="deleteOffer"></Detail33>
    </div>
  </div>
</template>

<script>

import Detail33 from "@/components/offers/Detail33";
import {Offer} from "@/models/offer";

export default {
  name: "Overview33",
  components: {Detail33},

  data() {
    return {
      lastId: 30000,
      selectedOffer: null,
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
      this.selectedOffer = this.findSelectedFromRouteParams(this.$route?.params?.id);
    }
  },
  methods: {
    onNewOffer() {
      let offer = Offer.createSampleOffer(this.lastId++);
      this.offers.push(offer);
      this.selectedOffer = offer;
      console.log(this.selectedOffer)
    },

    selectOffer(title) {
      let offer = this.offers.find(offer => offer.title === title);
      if (this.selectedOffer && offer.tag === this.selectedOffer.title) {
        this.selectedOffer = null;
      } else {
        this.selectedOffer = offer
      }
    },

    onSelect(offer) {
      let parentPath = this.$route?.fullPath.replace(new RegExp("/\\d*$"), '');
      if (offer != null && offer !== this.selectedOffer) {
        this.$router.push(parentPath + "/" + offer.id);
      } else if (this.selectedOffer != null) {
        this.$router.push(parentPath);
      }
    },

    deleteOffer(title) {
      let parentPath = this.$route?.fullPath.replace(new RegExp("/\\d*$"), '');

      this.offers = this.offers.filter(offer => offer.title !== title)
      this.selectedOffer = null

      this.$router.push(parentPath + "/");
    },

    findSelectedFromRouteParams(id) {
      if (id > 0) {
        return this.offers.find(x => x.id == id);
      }
      return null;
    },


    getSelectedOffer() {
      return this.selectedOffer
    }

  }
}
</script>

<style scoped>
.content {
  display: flex;
}

.left-section {
  /*border: 2px solid black;*/
  flex: 1;
}

.right-section {
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

.add-offer {
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