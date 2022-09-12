<template>
  <HeaderVue></HeaderVue>
  <WelcomeVue></WelcomeVue>
  <NavbarVue></NavbarVue>
</template>

<script>
import HeaderVue from './components/Header.vue'
import WelcomeVue from './components/Welcome.vue'
import NavbarVue from './components/Navbar.vue'

export default {
  name: "App31Vue",
  components: {
    HeaderVue,
    NavbarVue,
    WelcomeVue
  }
}
</script>

<style scoped>

</style>