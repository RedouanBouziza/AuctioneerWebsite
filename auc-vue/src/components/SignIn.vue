<template>
  <div class="modal-backdrop">
    <div class="modal">
      <button v-on:click="onClose()" class="close-button">X</button>
      <h3>Please provide your login credentials:</h3>
      <form method="post"
            v-on:submit.prevent="onSignIn()">
        <table class="wf-table">
          <tr>
            <td>Account e-mail:</td>
            <td><input type="email" name="email" v-model.trim="accountEmail" required
                       v-on:keydown.enter="$event.preventDefault()"
            ></td>
          </tr>
          <tr>
            <td>Password:</td>
            <td><input type="password" name="password" v-model="accountPassword" required minlength="3"></td>
          </tr>
        </table>
        <button type="submit" class="wf-button float-right">Sign In</button>
        <p class="error-message">{{ errorMessage }}</p>
        <h4>Current token:</h4>
        <div class="token-box">{{sessionService.currentToken}}</div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "SignIn",
  inject: ['sessionService'],
  props: {
    targetRoute: { type: String, default: "HOME" },
    cancelRoute: { type: String }
  },
  data() {
    return {
      accountEmail: null,
      accountPassword: null,
      errorMessage: null
    }
  },
  methods: {
    onClose(targetRoute) {
      if (targetRoute === undefined) targetRoute = this.$route.query?.cancelRoute;
      if (targetRoute === undefined) targetRoute = this.cancelRoute;
      if (targetRoute !== undefined) this.$router.push({ name: targetRoute});
      this.$emit('close')
    },
    async onSignIn() {
      this.errorMessage = null;
      let account = await this.sessionService.asyncSignIn(this.accountEmail, this.accountPassword);
      if (account == null) {
        this.errorMessage = "Could not authenticate with provided credentials";
      } else {
        let targetRoute = this.$route.query?.targetRoute;
        if (targetRoute == undefined) targetRoute = this.targetRoute;
        this.onClose(targetRoute);
      }
    }
  }
}
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  background: #FFFFFF;
  position: relative;
  margin: 10%;
  padding: 2em;
  min-width: 25em;
  max-width: 40em;
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
}

.close-button {
  position: absolute;
  top: 2px;
  right: 2px;
  background-color: red;
  color: black;
  font-weight: bolder;
}
.token-box {
  font-size: smaller;
  overflow-wrap: anywhere;
}

.wf-table > tr > td:first-child {
  background-color: lightblue;
  text-align: right;
  width: 35%;
  min-width: 50px;
}

.wf-table input {
  width: 98%;
}

.error-message {
  width: 100%;
  color: lightblue;
}

</style>