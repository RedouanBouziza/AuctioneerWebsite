<template>
  <HeaderVue></HeaderVue>
  <NavbarVue></NavbarVue>
  <Overview32></Overview32>
</template>

<script>
import HeaderVue from './components/Header.vue'
import NavbarVue from './components/Navbar.vue'
import Overview32 from './components/offers/Overview32';


export default {
  name: "App32Vue",
  components: {
    HeaderVue,
    NavbarVue,
    Overview32
  }

}
</script>

<style scoped>

</style>