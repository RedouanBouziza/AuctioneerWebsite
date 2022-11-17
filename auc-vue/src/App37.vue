<template>
  <HeaderVue></HeaderVue>
  <NavbarVue></NavbarVue>
  <router-view></router-view>
</template>

<script>

import HeaderVue from './components/Header.vue'
import NavbarVue from './components/Navbar.vue'

export default {
  name: "App37.vue",
  components: {
    HeaderVue, NavbarVue
  }

}
</script>

<style scoped>

</style>