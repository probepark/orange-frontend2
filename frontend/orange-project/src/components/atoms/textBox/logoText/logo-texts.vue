<template>
    <div class="logo-texts">
      <span class="logo-title">
        <slot name="logo-title"></slot>
      </span>
      <span class="logo-explanation">
        <slot name="logo-explanation"></slot>
      </span>
    </div>
</template>

<script>
    export default {
        name: "a_LogoTexts"
    }
</script>

<style scoped>
  .logo-texts{
    float: left;
    text-align: left;
    left: 22px;
    position: relative;
    top: 9px;
  }
  .logo-title{
    color: #2c3e50;
    font-size: 16px;
    font-weight: bold;
    display: block;
  }
  .logo-explanation{
    color: #0088cc;
    font-size: 12px;
  }
</style>
