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
      <router-view v-else v-on:refresh="this.onRefresh" :offer="getSelectedOffer()" @deselect="selectedOffer = null">
      </router-view>
    </div>
  </div>
</template>

<script>
import {Offer} from "@/models/offer";

export default {
  name: "Overview37Component",
  inject: ['offersService'],

  data() {
    return {
      lastId: 30000,
      selectedOffer: null,
      selectedId: null,
      offers: [],

    }
  },
   async created() {
    this.offers = await this.offersService.asyncFindAll();
    await this.onRefresh()
  },
  watch: {
    '$route'() {
      this.selectedOffer = this.findSelectedFromRouteParams(this.$route?.params?.id);
    }
  },
  methods: {
    async onNewOffer(){
      let newOffer = new Offer();
      newOffer.id = 0;
      await this.offersService.asyncSave(newOffer).then((offer) => {
        this.$router.push(`/offers/detail37/${offer.id}`);
        this.onSelect(offer)
      });

      await this.onRefresh();
    },

    onSelect(offer) {
      this.selectedId = offer.id;
      if (offer !== this.selectedOffer) {
        this.selectedOffer = offer;
        this.$router.push(this.$route.matched[0].path + "/" + offer.id);
      } else if (this.selectedOffer != null) {
        this.$router.push(this.$route.matched[0].path + "/");
        this.selectedOffer = null;
      }
    },

    async onRefresh() {
      this.offers = await this.offersService.asyncFindAll();
      this.selectedOffer = this.findSelectedFromRouteParams(this.$route?.params?.id);
    },

    findSelectedFromRouteParams(id) {
        if (id > 0) {
          return this.offers.find(x => x.id === id);
        } else {
          return null;
        }
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