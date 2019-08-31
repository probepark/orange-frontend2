<template>
  <div id="navigation">
    <div class="navigation-left">
      <slot name="left"></slot>
    </div>
    <div class="navigation-center">
      <slot name="center"></slot>
    </div>
    <div class="navigation-right">
      <slot name="right"></slot>
    </div>
  </div>
</template>

<script>
    export default {
        name: "navigation"
    }
</script>

<style scoped>
  #navigation {
    width: 100%;
    height: 60px;
    position: fixed;
    top: 0px;
    display: flex;
    border-bottom: 1px solid #cccccc;
    background: white;
    z-index: 99;
  }
  .navigation-left{
    left: 0px;
    width: 260px;
    min-width: 260px;
    height: 60px;
    display: flex;
    /*background: #999999;*/
  }
  .navigation-center{
    height: 60px;
    width: 960px;
    float: left;
    margin: 0px auto;
  }
  .navigation-right{
    /*background: #0088cc;*/
    right: 0px;
    width: 300px;
    height: 60px;
    display: flex;
  }
</style>
