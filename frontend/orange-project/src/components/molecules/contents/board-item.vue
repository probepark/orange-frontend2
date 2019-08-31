<template>
  <div class="item">
    <router-link :to="'/post/'+this.uri" class="item-link">
      <div class="item-view">
        <template v-if="this.imgPath !== ''">
          <img class="item-image" :src="this.imgPath">
        </template>
        <div class="item-date">
          <div class="date-icon icon-calendar-empty"></div>
          <span class="date-text">
            <!-- 해당 데이터는 사용처에서 입력 -->
            <slot name="item-date"></slot>
          </span>
        </div>
      </div>
      <div class="item-title">
        <span>
          <slot name="item-title"></slot>
        </span>
      </div>
    </router-link>
  </div>
</template>

<script>
    export default {
        props:['imgPath','uri'],
        name: "board-item",
    }
</script>

<style scoped>
  .item{
    flex-basis: 220px;
    margin: 10px;
    background: #dddddd;
    height: 220px;
    border-radius: 3px;
  }
  .item:hover{
    margin: 0px;
    flex-basis: 240px;
    height: 240px;
    transition: all .2s ease;
  }
  .item-view{
    width: 100%;
    margin-bottom: 10px;
    height: 160px;
    background: rgb(41, 128, 185);
    border-radius: 3px 3px 0 0;
    position: relative;
  }
  .item-title{
    font-size: 18px;
    height: 50px;
  }
  .item-link{
    text-decoration: none;
    color: black;
  }
  .item-date{
    width: 90px;
    padding: 2px 5px;
    background: #f9f9f9;
    position: absolute;
    top: 5px;
    right: 5px;
    border-radius: 3px;
    font-size: 14px;
    text-align: right;
    display: flex;
  }
  .date-icon{
    margin-right: 7px;
    color: #666666;
  }
  .date-text{
    color: #666666;
  }
</style>
