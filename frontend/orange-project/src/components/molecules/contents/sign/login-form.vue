<template>
  <div class="login-container">
    <router-link class="login-logoBox" to="/">
      <img class="login-logo" :src="this.$store.state.blog_info.imgPath">
    </router-link>
    <div class="login-inputBox">
      <div >
        <label>ID</label>
        <input id="login-id" type="text" v-model="id" v-on:keyup="{set_login_data_id}" autofocus>
        <div class="under-line"></div>
        <span :class="this.$store.state.sign_data.id_icon"></span>
      </div>
      <div>
        <label>PASSWORD</label>
        <input id="login-pw" type="password" v-model="pw" v-on:keyup="{set_login_data_pw}">
        <div class="under-line"></div>
      </div>
    </div>
    <div class="signup-box">
      <router-link to="/signup" class="signup">아이디가 없으신가요?</router-link>
    </div>
    <div class="login-buttonBox">
      <button>로그인</button>
    </div>
  </div>
</template>

<script>
    import {store} from "./../../../store";
    export default {
        name: "login-form",
        store,
        data(){
            return {
                id:"",
                pw:"",
            }
        },
        methods:{
            sign_standby(){
                this.$store.commit("sign_id_standby");
            }
        },
        computed:{
            set_login_data_id(){
                this.$store.state.sign_data.id = this.id;
                this.$store.commit("sign_id_standby");
                this.$store.commit('sign_count_id');
                console.log(`set_login_data_id[${this.$store.state.sign_data.id_count}]`);
                const self = this;
                setTimeout(function () {
                    console.log(`set_login_data_id in[${self.$store.state.sign_data.id_count}]`);
                    if(self.$store.state.sign_data.id_count <= 0){
                        console.log("set_login_data_id : sign_check_id 커밋 실행")
                        self.$store.commit("sign_check_id");
                    }
                },810);
                return this.$store.state.sign_data.id;
            },
            set_login_data_pw(){
                this.$store.state.sign_data.pw = this.pw;
                console.log(this.$store.state.sign_data.pw);
                return this.$store.state.sign_data.pw;
            },
        },
        created() {
            // 네비게이션 좌측 상단의 리다이렉트 버튼의 경로를 변경
            setTimeout(function () {
                this.$store.commit("page_redirect_update", "/");
            }, 100)
        }
    }
</script>

<style scoped>
  p{
    font-size: 14px;
    color: #42b983;
    transition: all .3s ease;
  }
  #login-page{
    width: 100%;
    display: table;
    min-height: 800px;
    position: relative;
  }
  .login-container{
    transform: translate(-50%, -50%);
    left: 50%;
    top: 50%;
    position: absolute;
    width: 450px;
    display: flex;
    flex-direction: column;
    border-radius: 5px;
    /*box-shadow: 0 0 5px 0px #adadad;*/
  }
  .login-logoBox{
    margin-top: -50px;
  }
  .login-logo{
    width: 100px;
    border-radius: 50%;
    height: 100px;
  }
  .login-inputBox{
    min-height: 150px;
    width: 380px;
    margin: 10px auto;
    display: flex;
    flex-direction: column;
  }
  .login-buttonBox{
    width: 380px;
    min-height: 50px;
    margin: 10px auto 30px auto;
    display: grid;

  }
  .login-inputBox > div{
    min-height: 80px;
    display: flex;
    flex-direction: column;
    position: relative;
  }
  .login-inputBox > div > span{
    position: absolute;
    color: orange;
    font-size: 20px;
  }

  #login-pw{
    letter-spacing: 10px;
  }
  #login-id{
    letter-spacing: 3px;
  }
  .icon-spin1{
    right: 15px;
    top:26px;
  }
  .icon-spin1:before{
    color:orange;
  }
  .icon-cancel{
    right: 15px;
    top:26px;
  }
  .icon-cancel:before{
    color: crimson;
  }
  .icon-ok{
    right: 15px;
    top:26px;
  }
  .icon-ok:before{
    color: #42b983;
  }
  .login-inputBox >div> label{
    font-size: 14px;
    text-align: left;
    margin: 0px 15px;
  }
  .login-inputBox >div> input{
    padding: 0px 10px;
    font-size: 18px;
    border: none;
    height: 38px;
    border-radius: 5px;
    /*background: #ddedf5;*/
    outline: none;
  }
  .login-inputBox >div> input:valid{
    transition: all .2s ease;
  }
  .login-inputBox >div> input:invalid{
    background: #0088cc;
    transition: all .2s ease;
  }
  .login-buttonBox > button{
    border-radius: 5px;
    border: none;
    cursor: pointer;
    outline: none;
    background: #141929;
    color:#cccccc;
    font-size: 20px;
  }
  .login-buttonBox :hover{
    background: #2c3e50;
    color: white;
    transition: all .2s ease;
  }
  .red{
    color: hotpink;
  }
  .orange{
    color: orange;
  }
  .spin{
    transform: rotate(1000rad);
    transition: all 300s linear;
    margin:0px;
    display: inline-flex;
  }
  #login-id:focus ~ .under-line, #login-pw:focus ~ .under-line{
    width: 360px;
    height: 2px;
    /*background: #42b983;*/
    background-image: linear-gradient(to right, #43e97b -50%, #38f9d7 100%);
    margin: 0px auto;
    transition: all 2s ease;
  }
  .under-line{
    width: 360px;
    height: 2px;
    /*background: #0088cc;*/
    background-image: linear-gradient(to left, #4facfe -50%, #00f2fe 100%);
    margin: 0px auto;
    transition: all 2s ease;
  }
  .signup-box{
    position: relative;
  }
  .signup{
    color: #666666;
    font-size: 14px;
    right: 40px;
    top: -10px;
    position: absolute;
    text-decoration: none;
  }

</style>
