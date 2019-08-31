<template>
  <div class="category">
    <router-link :to="this.uri" tag="span" class="to_redirect">
      <slot>Main</slot>
    </router-link>
  </div>
</template>

<script>
    export default {
        props:['uri'],
        name: "category",
    }
</script>

<style scoped>
  .category{
    font-size: 20px;
    bottom: 0px;
    margin-top: 20px;
    margin-left: 15px;
    cursor: pointer;
    color: #2c3e50;
  }
  .category:hover{
    transform: translateY(-5px);
    transition: all .2s ease;
    color: #0088cc;
  }
  .to_redirect:hover{
    color: #0088cc;
  }
  .to_redirect{
    padding: 10px 5px;
  }
  .router-link-active{
    color: #0088cc;
  }
</style>
