<template>
  <div id="signup">
    <sign-form></sign-form>
  </div>
</template>

<script>
    import SignForm from "../molecules/contents/sign/sign-form";
    export default {
        name: "signup",
        components: {SignForm}
    }
</script>

<style scoped>
  #signup{
    width: 100%;
    display: table;
    min-height: 800px;
    position: relative;
  }
</style>
