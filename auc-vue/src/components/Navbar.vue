<template>
  <div class="navbar">
    <router-link active-class="onpage" to="/home">Home</router-link>
    <a href="#news">My Offers</a>
    <div class="dropdown">
      <button class="dropbtn">My Bids
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <router-link to="/offers/overview31" exact-active-class="onpage" >All Offers overview</router-link>
        <router-link class="menu-link" to="/offers/overview32" exact-active-class="onpage">Offers details (comp)</router-link>
        <router-link class="menu-link" to="/offers/overview33" exact-active-class="onpage">Offers edit (router)</router-link>
        <router-link class="menu-link" to="/offers/overview34" exact-active-class="onpage">Offers edit (managed)</router-link>
        <router-link class="menu-link" to="/offers/overview37" exact-active-class="onpage">Offers details (rest backend)</router-link>
      </div>
    </div>
    <a href="#news">My Account</a>
    <div class="signup">
      <a href="#signup">Signup</a>
    </div>
    <div class="login">
      <a href="#login">Login</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "NavbarVue"
}
</script>

<style scoped>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  font-family: Arial, "Times New Roman";
  overflow: hidden;
  background-color: #F98B88;
  display: block;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.login {
  float: right;
  overflow: hidden;
}

.signup {
  float: right;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #E0B0FF;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>