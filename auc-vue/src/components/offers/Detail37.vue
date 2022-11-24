<template>
  <div v-if="copyOffer !== null">
  <div class="detailBox">
    <form v-if="copyOffer">
      <label class="labelOne" for="title">Title</label>
      <input id="title" v-model="copyOffer.title" type="text"/><br>

      <label class="labelTwo" for="status">Status</label>
      <select id="status">
        <option :value="copyOffer.status"> {{ copyOffer.status }}</option>
        <option value="FOR_SALE">FOR_SALE</option>
        <option value="SOLD">SOLD</option>
        <option value="PAID">PAID</option>
        <option value="DELIVERED">DELIVERED</option>
        <option value="CLOSED">CLOSED</option>
        <option value="EXPIRED">EXPIRED</option>
        <option value="WITHDRAWN">WITHDRAWN</option>
      </select>
      <br>

      <label class="labelThree" for="description">Description</label>
      <input id="description" v-model="copyOffer.description" type="text"/><br>

      <label class="labelFour" for="sellDate">Sell Date</label>
      <input id="sellDate" v-model="copyOffer.sellDate" type="text"/><br>

      <label class="labelFive" for="valueHighestBid">Value Highest Bid</label>
      <input id="valueHighestBid" v-model="copyOffer.valueHighestBid" type="text"/><br>

    </form>
  </div>
  <div>
    <div class="form-buttons">
      <button class="btn" @click="deleteOffer">Delete</button>
      <button class="btn" @click="clearOffer">Clear</button>
      <button class="btn" @click="resetSelection">Reset</button>
      <button class="btn" @click="cancelSelection">Cancel</button>
      <button class="btn" @click="saveOffer">Save</button>
    </div>
  </div>
  </div>
</template>

<script>
import {Offer} from "@/models/offer";

export default {
  name: "Detail37Component",
  inject: ['offersService'],
  props: ['offer'],
  emits: ['refresh'],
  async created() {
        await this.initializeCopy();
  },
  data() {
    return {
      copyOffer: null
    }
  },
  watch: {
    'offer'() {
            this.initializeCopy();
        }
  },

    methods: {
      async initializeCopy() {
        this.selectedOffer = await this.offersService.asyncFindById(this.$route?.params?.id);
        this.copyOffer = Offer.copyConstructor(this.selectedOffer);
      },

      async deleteOffer() {
        if (confirm(`Do you really want to delete the offer?`)) {
          await this.offersService.asyncDeleteById(this.selectedOffer.id);
          this.copyOffer = null;
          this.$emit('refresh');
        }
      },

      async saveOffer() {
        if (confirm(`Do you really want to delete the offer?`)) {
          await this.offersService.asyncSave(this.copyOffer);
          this.$router.push('/offers/overview37');
          console.log("het werkt")
          this.$emit('refresh');
        } else {
          console.log("HEt werkt neit")
        }
      },
      clearOffer() {
        this.copyOffer.title = "";
        this.copyOffer.status = ""
        this.copyOffer.description= "";
        this.copyOffer.sellDate= "";
        this.copyOffer.valueHighestBid= "";
      },
      resetSelection() {
        this.initializeCopy();
      },
      cancelSelection() {
        this.$router.push('/offers/overview37');
      }
    }
}
</script>

<style scoped>
.detailBox{
  flex: 1;
  /*flex-wrap: wrap;*/
  margin: 50px;
}

.labelOne{
  margin-right: 103px;
}

.labelTwo{
  margin-right: 93px;
}

.labelThree{
  margin-right: 58px;
}

.labelFour{
  margin-right: 73px;
}

.labelFive{
  margin-right: 15px;
}

.form-buttons{
  padding-left: 5px;
}

.btn{
  margin: 5px;
  background-color: #E0B0FF;
  color: #7F00FF;
  border-radius: 5px;
  /*border: 2px solid #E0B0FF;*/
}

.btn:hover {
  background-color: #7F00FF;
  color: white;
}

</style>
