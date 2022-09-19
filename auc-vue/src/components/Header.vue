<!------------------------------------------------------- HTML -------------------------------------------------------->
<template>
  <div class="flexbox-container-H">

    <div class="flexbox-item-H flexbox-item-1">
      <img class="leftPic" src="../assets/imgLeft.jpeg">
    </div>

    <div class="flexbox-item-H flexbox-item-2">
      <div class="title">
        <h1>The Auctioneer</h1>
      </div>
      <div class="sub-title">
        <div class="date-title">
          <p>Today is: {{getDate()}}</p>
        </div>
        <div class="text-title">
          <p>Offered to you by hva.nl</p>
        </div>
      </div>
    </div>

    <div class="flexbox-item-H flexbox-item-3">
      <img src="../assets/imgRight.jpeg" class="rightPic">
    </div>

  </div>

</template>
<!------------------------------------------------------- HTML -------------------------------------------------------->

<script>
export default { name: "HeaderVue",
                  methods: {
                    getDate() {
                      var today = new Date();
                      var options = { weekday: 'long', month: 'long',year: 'numeric', day: 'numeric' };
                      return today.toLocaleDateString("en-US", options);
                    }
                  }
}


</script>

<style scoped>
@import '../css/Header.css';
</style>