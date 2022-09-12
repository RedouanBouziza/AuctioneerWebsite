<template>
  <div class="flexbox-container">
    <div class="flexbox-item imgLeft">
      <img src="../assets/imgLeft.jpeg" class="responsive" >
    </div>
    <div class="textTitle">
    <div class="flexbox-item title">
      The Auctioneer
    </div>
    <div class="flexbox-item sub-title">
      Offered to you by hva.nl
    </div>
    </div>
    <div class="flexbox-item imgRight">
      <img src="../assets/imgRight.jpeg" class="responsive" >
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderVue"
}
</script>

<style scoped>
.flexbox-container {
  display: flex;
}

.flexbox-item {
  min-height: 120px;
  margin: 10px;
}

.imgLeft {
  justify-content: center;
  width: 300px;

}

.title {
  text-decoration-color: antiquewhite;
  width: 1200px;
  background-color: #F98B88;
}

.sub-title {
  width: 1200px;
  display: flex;
  justify-content: flex-end;
  background-color: #F98B88;
}

.imgRight {
  width: 300px;

}

.textTitle {
  min-height: 100px;
  display: flex;
  flex-direction: column;
}

.responsive {
  width: 100%;
  max-width: 400px;
  height: auto;
}

</style>