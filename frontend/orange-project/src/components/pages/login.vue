<template>
  <div id="login-page">
    <login-form></login-form>
  </div>
</template>

<script>

  import LoginForm from "../molecules/contents/sign/login-form";
  export default {
      name: "login",
      components: {LoginForm},
  }
</script>

<style scoped>
  #login-page{
    width: 100%;
    display: table;
    min-height: 800px;
    position: relative;
  }
</style>
