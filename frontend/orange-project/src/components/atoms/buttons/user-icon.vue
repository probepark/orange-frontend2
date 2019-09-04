<template>
  <router-link class="userIcon" to="/login">
    <img :src="imgPath"/>
  </router-link>
</template>

<script>
    export default {
        props:['imgPath'],
        name: "UserIcon",
    }
</script>

<style scoped>
  .userIcon{
    position: relative;
    border-radius: 50%;
    background: white;
    border: 2px solid rgba(255,255,255,0.1);
    transition: color 0.2s ease;
    cursor: pointer;
  }
  .userIcon > img{
    border-radius: 50%;
    width: 100%;
    height: 100%;
  }
</style>

