import Vue from "vue";
import Vuex from "vuex";
import axios from 'axios';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state:{
    page_status:{
      icon_redirect: {
        login_page: "/",
        other_page: "/login"
      },
      alert_data:{
        text:"알림",
      }
    },
    blog_info:{
      name:"Pollra 블로그",
      explanation: "잊을만 하면 찾아오는 기억 저장소",
      imgPath: "../static/test/icon/content02.png"
    },
    categories:[{
        num:1,
        owner:"pollra",
        name:"Hobby"
      }],
    board_info:{
      parent: "main",
      title: "포스팅을 확인할 수 없습니다.",
      date: "",
      comment: "",
      contents: ""
    },
    board_list:[
      // {
      //   title:"Java",
      //   date:"19.08.18",
      //   uri:"1",
      //   img_path:""
      // },
    ],
    currentPath:"",
    sign_data:{
      id:"",
      id_msg:"사용자의 입력을 기다리고있습니다...",
      id_count:0,
      id_class:"",
      id_icon: "",
      id_server_error:false,
      pw:"",
    }
  },
  mutations:{
    /**
     * 서버에 board_list 데이터를 요청하여 특정 카테고리 포스팅 리스트를 가져옵니다.
     * @param state       vuex store
     * @param currentPath 현재 페이지의 경로
     */
    set_board_list:(state, currentPath) =>{
      console.log(`set_board_list[${currentPath}]`);
      axios.get("http://110.12.8.172/boards/"+currentPath)
        .then(function (response) {
          state.board_list = response;
          console.log(`get_board_list[success]: ${response}`)
        })
        .catch(function (error) {
          state.board_list = [];
          console.log(`get_board_list[fail]: ${error}`);
        })
    },
    /**
     * 서버에 blog_info 데이터를 요청하여 블로그의 정보를 가져옵니다.
     * @param state       vuex store
     */
    set_blog_info:(state)=>{
      axios.get("http://110.12.8.172/blog/info")
        .then(function (response) {
          console.log("수신한 정보[get_blogInfo] : "+JSON.stringify(response.data));
          state.blog_info = response.data;
        })
        .catch(function (error) {
          /*에러 발생 시 서버로 에러 전송*/
          console.log("블로그 정보를 불러오는데 실패 했습니다.");
        })
    },
    /**
     *
     * @param state
     */
    set_categories_list:(state)=>{
      axios.get("http://110.12.8.172/categories/list")
        .then(function (response) {
          console.log(`수신한 정보[set_categories_list]: ${JSON.stringify(response.data)}`)
          state.categories = response.data;
        }).catch(function (error) {
          console.log('카테고리 데이터를 받아오는데 실패했습니다.');
          state.categories = [];
        })
    },
    /**
     * @param state   저장소
     * @param target  대상 ( id, pw )
     * @param value   변경하고자 하는 값
     */
    set_sign_data:(state, target_value)=>{
      const target = target_value[0];
      const value = target_value[1];
      console.log(`set_login_data : ${target}, ${value}`)
      if(target === "id"){
        state.sign_data.id = value;
      }
      if(target==="pw"){
        state.sign_data.pw = value;
      }
    },
    sign_check_id:(state)=>{
        state.sign_data.id_msg = "처리중...";
        state.sign_data.id_icon = "icon-spin1 spin";
        state.sign_data.id_server_error = true;
        axios.post("http://110.12.8.172/sign/check/id",{
          "sign_id":state.sign_data.id
        })
          .then(function (response) {
            console.log("수신 정보"+JSON.stringify(response));
            state.sign_data.id_icon = "icon-ok";
          })
          .catch(function (error) {
            console.log("아이디를 찾을 수 없습니다.")
            state.sign_data.id_msg = "아이디를 찾을 수 없습니다.";
            state.sign_data.id_icon = "icon-cancel";
          })
    },
    sign_id_standby:(state)=>{
      state.sign_data.id_icon = "";
    },
    sign_count_id:(state)=>{
      state.sign_data.id_count++;
      state.sign_data.id_msg = "사용자의 입력을 기다리고있습니다...";
      state.sign_data.id_class = "";

      setTimeout(function () {
        state.sign_data.id_count--;
      },500)
    },
    page_redirect_update:(state,payload)=>{
      state.page_status.icon_redirect = payload;
    }
  },
  actions:{
    set_sign_data:function (context, payload){
      context.commit('set_sign_data', payload);
    },
    check_sign_data_id:function (context, payload) {
      context.commit('sign_check_id', payload);
    }
  },
  getters:{
    get_sign_count:function() {
      return this.$store.state.sign_data.id_count;
    }
  }
});
