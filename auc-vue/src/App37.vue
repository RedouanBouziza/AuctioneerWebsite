<template>
  <HeaderVue></HeaderVue>
  <NavbarVue></NavbarVue>
  <router-view></router-view>
</template>

<script>

import {OffersAdaptor} from "@/services/offers-adaptor";
import CONFIG from './app-config.js'
import HeaderVue from './components/Header.vue'
import NavbarVue from './components/Navbar.vue'

export default {
  name: "App37.vue",
  components: {
    HeaderVue, NavbarVue
  },
  provide: {
    offersService: new OffersAdaptor(CONFIG.BACKEND_URL+"/offers"),
  }


}
</script>

<style scoped>

</style>