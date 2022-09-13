<template>
  <div class="flexbox-container">
    <div class="flexbox-item imgLeft">
      <img src="../assets/imgLeft.jpeg" class="responsive">
    </div>
    <div class="textTitle">
      <div class="flexbox-item title">
        <h1>The Auctioneer</h1>
      </div>
      <div class="flexbox-item sub-title">
        <p>Offered to you by hva.nl</p>
      </div>
    </div>
    <div class="flexbox-item imgRight">
      <img src="../assets/imgRight.jpeg" class="responsive">
    </div>
  </div>
</template>

<script>
export default {
  name: "HeaderVue"
}
</script>

<style scoped>

h1 {
  font-family: Arial, "Times New Roman";
  text-align: center;
  font-size: 50px;
  font-weight: 100;
  text-shadow: 2px 2px #7F00FF;
  color: 	white;
}

p {
  font-family: Arial, "Times New Roman";
  text-align: right;
  font-size: 30px;
  font-weight: 100;
  text-shadow: 2px 2px #7F00FF;
  color: 	white;
}

.flexbox-container {
  display: flex;
}

.flexbox-item {
  min-height: 120px;
  margin: 10px;
  box-shadow: 4px 4px #CF9FFF;
}

.imgLeft {
  justify-content: center;
  height: auto;
  width: 300px;
}

.title {
  text-decoration-color: antiquewhite;
  width: 800px;
  background-color: #F98B88;
}

.sub-title {
  width: 800px;
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