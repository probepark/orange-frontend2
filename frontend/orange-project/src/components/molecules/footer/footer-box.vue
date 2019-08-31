<template>
  <div class="footer">
    <!--사이트 정보 입력-->
    <div class="footer-info">
      <span>
        <slot name="introduce-text">introduce-text</slot>
      </span>
      <span>.</span>
      <span>
        @<slot name="introduce-date">date</slot>
      </span>
      <span>.</span>
      <span>
        <slot name="introduce-name">name</slot>
      </span>
    </div>
  </div>
</template>

<script>
    export default {
        name: "footer-box"
    }
</script>

<style scoped>
  .footer{
    width: 100%;
    height: 50px;
  }
  .footer-info{
    margin: 10px auto;
    font-size: 14px;
  }
  .footer-info > span:nth-child(1){
    color: #999999;
  }
  .footer-info > span:nth-child(2){
    color: #999999;
  }
  .footer-info > span:nth-child(3){
    color: #0088cc;
  }
  .footer-info > span:nth-child(4){
    color: #0088cc;
  }
  .footer-info > span:nth-child(5){
    color: #0088cc;
  }
</style>
