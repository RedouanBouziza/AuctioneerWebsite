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
          <p>Today is: {{getDate()}}, Welcome {{ userName }},</p>
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
export default {
  name: "HeaderSB",
  inject: ['SessionService'],

  data() { return {
    pageTitle: "Enlighten yourselves<br>with the books from our shelves!",
    today: new Date().toLocaleString("en-NL",
        {year: 'numeric', month: 'long'}),
    userName: 'Visitor'
  } },
  created() {
    this.userName = this.SessionService.currentAccount();
  },
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
.flexbox-container-H{
  display: flex;
  flex-direction: row;
  /*padding: 10px;*/
  width: 100%;
  height: 100%;
  /*height: 300px;*/
}

.flexbox-item-H{
  /*display: block;*/
  /*margin: 5px;*/
  /*border: 3px solid #73AD21;*/
  /*background-color: white;*/
  /*height: 300px;*/
}

.flexbox-item-1{
  /*max-width: 150px;*/
  /*min-height: 300px;*/
  /*min-width: 300px;*/
}

.flexbox-item-2{
  display: flex;
  flex-direction: column;
  /*align-content: center;*/
  justify-content: center;
  /*min-height: 300px;*/
  width: 70%;
  padding-right: 10px;
  padding-left: 10px;
}

.flexbox-item-3{
  /*width: 100px;*/
  /*min-height: 300px;*/
  /*min-width: 300px;*/
}

.leftPic{
  max-width: 100%;
  max-height: 100%;
  width: 300px;
}

.rightPic{
  max-width: 100%;
  max-height: 100%;
  width: 300px;
}

.title{
  justify-content: center;
  background-color: #F98B88;

  font-family: Arial, "Times New Roman";
  text-align: center;
  font-size: 25px;
  font-weight: 100;
  text-shadow: 2px 2px #7F00FF;
  color: 	white;

  height: 100px;
}

.sub-title {
  margin-top: 10px;
  display: flex;
  flex-direction: row;
  background-color: #F98B88;
  font-family: Arial, "Times New Roman";
  text-align: right;
  font-size: 30px;
  font-weight: 100;
  text-shadow: 2px 2px #7F00FF;
  color: 	white;
  height: 100px;
}

.date-title{
  margin-right: auto;
  font-size: 20px;

}

.text-title{
}







/*!**/
/*.container1{*/
/*    margin-bottom: 20px;*/
/*    margin-top: 20px;*/
/*}*/

/*.picture1{*/
/*    justify-content: center;*/
/*}*/

/*.col{*/
/*    border: red solid 1px;*/
/*}*/


/*.imgLeft {*/
/*    !*justify-content: center;*!*/
/*    !*height: auto;*!*/
/*    !*width: 300px;*!*/
/*}*/

/*.title {*/
/*    justify-content: center;*/
/*    background-color: #F98B88;*/

/*    font-family: Arial, "Times New Roman";*/
/*    text-align: center;*/
/*    font-size: 50px;*/
/*    font-weight: 100;*/
/*    text-shadow: 2px 2px #7F00FF;*/
/*    color: 	white;*/
/*}*/

/*.sub-title {*/
/*    justify-content: flex-end;*/
/*    padding-right: 10px;*/
/*    background-color: #F98B88;*/

/*    font-family: Arial, "Times New Roman";*/
/*    text-align: right;*/
/*    font-size: 30px;*/
/*    font-weight: 100;*/
/*    text-shadow: 2px 2px #7F00FF;*/
/*    color: 	white;*/
/*}*/

/*.imgRight {*/
/*    !*width: 300px;*!*/
/*}*/

/*.textTitle {*/
/*    min-height: 100px;*/
/*    display: flex;*/
/*    flex-direction: column;*/
/*}*/

/*.responsive {*/
/*    max-width: 300px;*/
/*    !*max-width: 400px;*!*/
/*    !*height: auto;*!*/
/*}*/

@media only screen and (max-width: 768px) {
  .title[data-v-61dd7a3d] {
    -webkit-text-decoration-color: antiquewhite;
    text-decoration-color: antiquewhite;
    width: 358px;
    background-color: #F98B88;
  }
  .sub-title[data-v-61dd7a3d] {
    width: 361px;
    display: flex;
    justify-content: flex-end;
    background-color: #F98B88;
  }
}

</style>