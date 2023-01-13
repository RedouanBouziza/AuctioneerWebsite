<template>
  <HeaderVue></HeaderVue>
  <NavbarVue></NavbarVue>
  <router-view></router-view>
</template>

<script>

import {OffersAdaptor} from "@/services/offers-adaptor";
import CONFIG from './app-config.js'
import HeaderVue from './components/HeaderSB.vue'
import NavbarVue from './components/Navbar.vue'
import {shallowReactive} from "vue";
import {SessionService} from "@/services/session-service";
import {FetchInterceptor} from "@/services/fetch-interceptor";

export default {
  name: "App44.vue",
  components: {
    HeaderVue, NavbarVue
  },
  provide() {
    // TODO Use a dynamic (hashed) JWT_STORAGE_ITEM name for greater security
    this.theSessionService = shallowReactive(
        new SessionService(CONFIG.BACKEND_URL + "/authentication", CONFIG.JWT_STORAGE_ITEM));
    this.theFetchInterceptor =
        new FetchInterceptor(this.theSessionService, this.$router);
    return {
      // stateless data services adaptor singletons
      offersService: new OffersAdaptor(CONFIG.BACKEND_URL+"/offers"),

      // reactive, state-full services
      sessionService: this.theSessionService
    }
  },
  beforeUnmount() {
    this.theFetchInterceptor.unregister();
  }


}
</script>

<style scoped>

</style>