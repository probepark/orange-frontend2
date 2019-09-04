<template>
  <div>
    <input type="checkbox" class="alert-check" checked>
    <div class="custom-alert">
      <div class="alert-box">
        <div class="icon-cancel cancel"></div>
        <p class="alert-text">
          <slot name="text">알림</slot>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "custom-alert",
        methods:{
            open_alert(){

            }
        }
    }
</script>

<style scoped>
  .custom-alert{
    position: absolute;
    right: 30px;
    bottom: 30px;
    padding: 25px 50px;
    background: #4facfe;
    border-radius: 5px;
  }
  .alert-check{
    position: absolute;
    left:-9999px;
  }
  .alert-check:checked ~ .custom-alert{
    display: none;
  }
  .alert-box{
    position: relative;
    width: 100%;
    height: 100%;
  }
  .alert-text{
    color: white;
  }
  .cancel{
    position: absolute;
    right: -45px;
    top: -18px;
    color: white;
    cursor:pointer;
  }
</style>
