<template>
  <div class="detailBox">
    <form v-if="selectedOffer">
      <label class="labelOne" for="form_title">Title</label>
      <input id="form_title" v-model="selectedOffer.title" type="text"/><br>

      <label class="labelTwo" for="form_status">Status</label>
      <select id="form_status" v-model="selectedOffer.status" >
        <option v-for="status in statusValues" :value="status" :key="status"
                :selected="status === selectedOffer.status ? 'true' : 'false'"> {{status}}</option>
      </select>
      <br>

      <label class="labelThree" for="form_description">Description</label>
      <input id="form_description" v-model="selectedOffer.description" type="text"/><br>

      <label class="labelFour" for="form_sellDate">Sell Date</label>
      <input id="form_sellDate" v-model="selectedOffer.sellDate" type="text"/><br>

      <label class="labelFive" for="form_valueHighestBid">Value Highest Bid</label>
      <input id="form_valueHighestBid" v-model="selectedOffer.valueHighestBid" type="text"/><br>

    </form>
  </div>
  <div>
    <button class="deleteButton" v-if="selectedOffer"
            @click="$emit('delete-offer', selectedOffer.title)">Delete </button>
  </div>
</template>

<script>
import {Offer} from "@/models/offer.js";

export default {
  data() {
    return {
      statusValues: null,
    }
  },
  props: {selectedOffer:{
      required:false
    }},
  emits:['delete-offer'],
  created() {
    this.setStatusValues();
  },
  methods: {
    setStatusValues(){
      this.statusValues =  [Offer.StatusEnum.NEW,
        Offer.StatusEnum.FOR_SALE,
        Offer.StatusEnum.SOLD,
        Offer.StatusEnum.PAID,
        Offer.StatusEnum.DELIVERED,
        Offer.StatusEnum.CLOSED,
        Offer.StatusEnum.EXPIRED,
        Offer.StatusEnum.WITHDRAWN];
    },

  }
}
</script>

<style scoped>

.detailBox{
    flex: 1;
    /*flex-wrap: wrap;*/
    margin: 50px;
  }

.deleteButton{
  background-color: #E0B0FF;
  color: #7F00FF;
  border-color: #E0B0FF;
  border-radius: 5px;
  }

.labelOne{
  margin-right: 110px;
}

.labelTwo{
  margin-right: 97px;
}

.labelThree{
  margin-right: 59px;
}

.labelFour{
  margin-right: 77px;
}

.labelFive{
  margin-right: 15px;
}

</style>