<template>

</template>

<script>
export default {
  name: "OffersOverview31",
  created() {
    this.lastId = 30000;
    for (let i = 0; i < 10; i++) {
      this.lastId++;
      this.offers.push({
        id: this.lastId,
        title: "Offer " + this.lastId,
        description: "Description " + this.lastId,
        price: this.lastId * 100,
        image: "https://picsum.photos/200/300?random=" + this.lastId
      });
    }
  }
}
</script>

<style scoped>

</style>