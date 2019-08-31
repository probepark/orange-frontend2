import Vue from "vue";
import Vuex from "vuex";
import axios from 'axios';

Vue.use(Vuex);

export const store = new Vuex.Store({
  state:{
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
      parent: "Error",
      title: "포스팅을 확인할 수 없습니다.",
      date: "",
      comment: "",
      contents: ""
    },
    board_list:[
      {
        title:"Java",
        date:"19.08.18",
        uri:"1",
        img_path:""
      },
    ],
    currentPath:""
  },
  mutations:{
    /**
     * 서버에 board_list 데이터를 요청하여 특정 카테고리 포스팅 리스트를 가져옵니다.
     * @param state       vuex store
     * @param currentPath 현재 페이지의 경로
     */
    set_board_list:(state, currentPath) =>{
      console.log(`set_board_list[${currentPath}]`);
      axios.get("http://localhost:8081/boards/"+currentPath)
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
      axios.get("http://localhost:8081/blog/info")
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
      axios.get("http://localhost:8081/categories/list")
        .then(function (response) {
          console.log(`수신한 정보[set_categories_list]: ${JSON.stringify(response.data)}`)
          state.categories = response.data;
        }).catch(function (error) {
          console.log('카테고리 데이터를 받아오는데 실패했습니다.');
          state.categories = [];
        })
    }
  }
})
