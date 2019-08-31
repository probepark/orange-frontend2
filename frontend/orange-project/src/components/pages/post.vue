<template>
  <content-box>
    <content-info slot="content-info">
      <span slot="content-parent">{{this.$store.state.board_info.parent}}</span>
      <span slot="content-title">{{this.$store.state.board_info.title}}</span>
      <span slot="content-date">{{this.$store.state.board_info.date}}</span>
      <span slot="content-comment">{{this.$store.state.board_info.comment}}</span>
    </content-info>
    <div id="content-board" slot="contents">
      <template v-if="this.$store.state.board_info.contents === ''">
        <content-none></content-none>
      </template>
      {{this.$store.state.board_info.contents}}
    </div>
  </content-box>
</template>

<script>
  import ContentBox from '@/components/molecules/contents/content-box';
  import ContentInfo from '@/components/molecules/contents/content-info';
  import ContentNone from "../molecules/contents/content-none";
  import Axios from "axios";

    export default {
        name: "post",
        components:{
            ContentNone,
            "content-box":ContentBox,
            "content-info":ContentInfo
        },
        methods:{
            // 블로그 정보를 가져옴
            get_blogInfo(){
                this.$store.commit("set_blog_info")
            },
            // 포스팅을 가져옴
            get_boardInfo(){
                const postNum = this.$route.params.num;
                this.$store.commit("set_board_info", postNum);
            },
            // 현재 경로를 업데이트 함
            update_currentPath(){
                this.$store.commit("update_currentPath", this.$route.params.category);
            }
        },
        created() {
            // 블로그와 포스팅 정보를 가져옴.
            this.get_blogInfo();
            // this.get_boardInfo();
            this.update_currentPath();
        }
    }
</script>

<style scoped>
  #content-board > p{
    margin-bottom: 10px;
  }
</style>
