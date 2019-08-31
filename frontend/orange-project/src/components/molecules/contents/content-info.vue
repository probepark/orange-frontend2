<template>
  <!--이미지 위치-->
  <div id="content-info-box">
    <!--상위 카테고리-->
    <div id="parent-category">
        <span>
          <slot name="content-parent">상위 카테고리</slot>
        </span>
    </div>
    <!--글 제목-->
    <div id="content-title">
      <span>
        <slot name="content-title">Error</slot>
      </span>
    </div>
    <!--날짜, 댓글갯수-->
    <div id="content-info">
      <div></div>
      <!--날짜-->
      <div id="content-date">
        <template v-if="this.$store.state.board_info.date !== ''">
          <div class="icon-calendar-empty"></div>
          <span>
            <slot name="content-date">포스팅 날짜</slot>
          </span>
        </template>
      </div>
      <!--댓글 갯수-->
      <div id="content-comment">
        <template v-if="this.$store.state.board_info.comment !== ''">
          <div class="icon-comment"></div>
          <span>
            <slot name="content-comment">댓글 수</slot>
          </span>
        </template>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "board-info",
    }
</script>

<style scoped>
  #content-info-box{
    width: 700px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    display: flex;
    flex-direction: column;
    color: white;
    z-index: 1;
  }
  #content-info-box > div:nth-child(2){
    flex-basis: 50px;
  }
  #parent-category{
    width: 100px;
    margin: 0 auto 15px auto;
    font-size: 12px;
  }
  #content-title{
    font-size: 24px;
  }
  #content-info{
    display: flex;
    flex-direction: row;
    width: 160px;
    margin: 0 auto;
    font-size: 14px;
  }
  #content-info > div{
    flex-grow: 1;
    display: flex;
  }
  #content-info > div:nth-child(1){
    flex-basis: 3px;
  }
  #content-date > div{
    margin-right: 2px;
  }
  #content-comment > div{
    margin-right: 2px;
  }
</style>
