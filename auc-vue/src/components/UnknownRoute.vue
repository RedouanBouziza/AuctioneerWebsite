<template>
  <div class="popup" id="error">
    <div class="error-popup-content">
      <div class="titleError">
        <h3>Sorry :(</h3>
      </div>
      <p class="para">Something went wrong. Please try again!</p>
      <form action="">
        <a href="#" class="button" id="e_button">TRY AGAIN</a>
      </form>
    </div>
  </div>


</template>

<script>
export default {
  name: "UnknownRoute"
}
</script>

<style scoped>

#error{
  display: flex;
  justify-content: center;
}

.titleError{
  font-family: Arial, Helvetica, sans-serif;
  font-weight: 500;
  font-size: 24px;
  letter-spacing: 0.05em;
  text-align: center;
  margin: auto;
}

#error .titleError{
  color: #ff3636;
}

.para{
  font-family: Arial, Helvetica, sans-serif;
  font-weight: 500;
  width: 80%;
  font-size: 18px;
  line-height: 30px;
  letter-spacing: 0.05em;
  text-align: center;
  margin: auto;

}
.button{
  font-family: Arial, Helvetica, sans-serif;
  width: 50%;
  display: block;
  margin: 20px auto;
  border-radius: 25px;
  padding: 10px;
  text-decoration: none;
  color: white;
  text-align: center;
  letter-spacing: 0.05em;
}

#e_button{
  font-family: Arial, Helvetica, sans-serif;
  background: #ff3636;
}

</style>