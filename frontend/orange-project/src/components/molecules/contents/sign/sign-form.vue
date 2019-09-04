<template>
    <div id="signup-form">
      <div class="signup-logo"></div>
      <button @click=""></button>
      <custom-alert>
        <template slot="text">알림</template>
      </custom-alert>
    </div>
</template>

<script>
    import CustomAlert from "../popup/custom-alert";
    export default {
        name: "sign-form",
        components: {CustomAlert},
        methods:{
            o_alert(){

            }
        }
    }
</script>

<style scoped>
  #signup-form{
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    border: 1px solid #cccccc;
    border-radius: 5px;
    width: 500px;
    min-height: 700px;
  }
</style>
