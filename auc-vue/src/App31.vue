<template>
  <HeaderVue></HeaderVue>
  <NavbarVue></NavbarVue>
<!--  <WelcomeVue></WelcomeVue>-->
  <Overview31></Overview31>
</template>

<script>
import HeaderVue from './components/Header.vue'
import WelcomeVue from './components/Welcome.vue'
import NavbarVue from './components/Navbar.vue'
import Overview31 from './components/offers/Overview31';


export default {
  name: "App31Vue",
  components: {
    HeaderVue,
    NavbarVue,
    // WelcomeVue
    Overview31
  }

}
</script>

<style scoped>

</style>