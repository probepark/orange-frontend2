<template>
  <div id="content-box">
    <div id="content-info">
      <slot name="content-info"></slot>
    </div>
    <!--글 써질 위치-->
      <!--글 내용-->
    <div id="content-contents">
      <slot name="contents"></slot>
    </div>
  </div>
</template>

<script>
    export default {
        name: "content"
    }
</script>

<style scoped>
  #content-box{
    width: 100%;
    min-height: 500px;
    display: table;
  }
  #content-info{
    width: 100%;
    min-height: 300px;
    background: rgb(41, 128, 185);
    position: relative;
  }
  #content-contents{
    width: 960px;
    margin: 10px auto 10px auto;
    /*background: #cccccc;*/
    min-height: 500px;
  }
</style>
