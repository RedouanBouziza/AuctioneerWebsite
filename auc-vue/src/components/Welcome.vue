<template>
  <div class="flexbox-container">
    <div class="flexbox-item left">
      <div class="column">
        <p> Pick a date: </p>
        <input type="date" id="datePicker">
      </div>
      <div class="column">
        <p> Pick a category:</p>
        <a href="https://www.w3.org/Provider/Style/dummy.html">- Antiques</a><br>
        <a href="https://www.w3.org/Provider/Style/dummy.html">- Cars</a><br>
        <a href="https://www.w3.org/Provider/Style/dummy.html">- Event Tickets</a><br>
        <a href="https://www.w3.org/Provider/Style/dummy.html">- Holidays</a><br>
        <a href="https://www.w3.org/Provider/Style/dummy.html">- Collectables</a>
      </div>
    </div>
    <div class="flexbox-item center">
      <p> Auctions that expire today: </p>
      <a href="https://onlineveilingmeester.nl/nl/veilingen/4708/kavels/10">
        <img src="../assets/eetTafel.jpeg" class="responsive"></a>
      <a href="https://onlineveilingmeester.nl/nl/veilingen/4757/kavels/7-cartier-calibre-de-cartier-3729">
      <img src="../assets/rolex.jpeg" class="responsive"></a>
      <a href="https://onlineveilingmeester.nl/nl/veilingen/4708/kavels/12-replica">
      <img src="../assets/velvetBank.jpeg" class="responsive"></a>
      <a href="https://onlineveilingmeester.nl/nl/veilingen/4708/kavels/13-by-italia">
      <img src="../assets/marbleTafel.jpeg" class="responsive"></a>
    </div>
    <div class="flexbox-item right">
      <p>Original Race Truck Paris-Dakar</p>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit.
      Aenean vel est eleifend, fringilla purus non, blandit nibh.
      Maecenas lacinia lacinia eros non gravida. Proin porttitor sem in lacus dictum elementum.
      Aenean vel lorem convallis, vulputate risus non, iaculis nunc.<br><br>Proin nunc arcu,
      pretium vel lorem ut, pellentesque pellentesque elit. Morbi blandit sit amet sem vel ornare.
      Sed et diam congue, placerat justo in, sodales est. <br><br>Nunc tincidunt lectus at accumsan semper.
      Pellentesque nec condimentum mi. Nulla gravida, magna et rhoncus accumsan, ex velit posuere mi,
      vitae imperdiet sem leo ac nisi. In malesuada nunc nec mi blandit, aliquam maximus ex.
    </div>
  </div>
</template>

<script>
export default {
  name: "WelcomeVue"
}
</script>

<style scoped>

.flexbox-container {
  display: flex;
  align-content: center;
}

.flexbox-item {
  height: 700px;
  flex-grow: 0;
  width: 100%;
  padding: 10px;
  margin: 10px;
}

.responsive {
  width: 100%;
  max-width: 150px;
  max-height: 300px;
}

.column {
  width: 100%;
  height: 20%;
}

p {
  font-family: Arial, "Times New Roman";
  text-align: center;
  font-size: 30px;
  font-weight: 100;
  text-shadow: 2px 2px #7F00FF;
  color: black;
}

a {
  color: black;
  margin-left: 140px;
  font-size: 20px;

}

#datePicker {
  width: 100%;
  height: 50px;
}

.left {
  background-image: linear-gradient(to right, #7F00FF, #E0B0FF);
  width: 800px;
}

.center {

}

.right {
  background-image: linear-gradient(to left, #7F00FF, #E0B0FF);
  width: 800px;
  font-family: Arial, "Times New Roman";
  font-size: 15px;

}

</style>