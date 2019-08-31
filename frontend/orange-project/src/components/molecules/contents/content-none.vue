<template>
  <div class="content-none">
    <div class="none">
      <div class="icon-help-circled icon"></div>
      <span class="none-text">포스팅의 내용이 존재하지 않습니다.</span>
      <router-link to="/" class="link">
        <span class="icon-home"></span>
        <span class="go-to-home">홈으로 돌아가기</span>
      </router-link>
    </div>
  </div>
</template>

<script>
    export default {
        name: "content-none"
    }
</script>

<style scoped>
  .content-none{
    width: 100%;
    min-height: 400px;
    position: relative;
  }
  .none{
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    position: absolute;
    display: flex;
    flex-direction: column;
  }
  .icon{
    font-size: 200px;
    color: #0088cc;
  }
  .link{
    text-decoration: none;
    color: #42b983;
    font-size: 16px;
  }
  .none-text{
    font-size: 22px;
  }
  .go-to-home{
  }
</style>
