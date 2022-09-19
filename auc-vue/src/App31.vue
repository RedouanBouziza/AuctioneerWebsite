<template>
  <HeaderVue></HeaderVue>
  <NavbarVue></NavbarVue>
  <WelcomeVue></WelcomeVue>
</template>

<script>
import HeaderVue from './components/Header.vue'
import WelcomeVue from './components/Welcome.vue'
import NavbarVue from './components/Navbar.vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

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