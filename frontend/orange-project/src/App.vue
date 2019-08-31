<template>
  <div id="app">
    <vue-headful
      :title="this.$store.state.blog_info.title"
    />
    <navigation>
      <user-icon slot="left" class="nav_user_icon" v-bind:imgPath="this.$store.state.blog_info.imgPath"></user-icon>
      <logo-texts slot="left">
        <template slot="logo-title">{{this.$store.state.blog_info.title}}</template>
        <template slot="logo-explanation">{{this.$store.state.blog_info.explanation}}</template>
      </logo-texts>
      <categories slot="center">
        <category
          slot="categories"
          v-for="(category,index) in (this.$store.state.categories)"
          :key="index"
          :uri="'/list/'+category.name"
        >
          {{category.name}}
        </category>
      </categories>
    </navigation>

    <router-view class="contents" slot="contents"/>

    <footer-box>
      <span slot="introduce-text">{{this.$store.state.blog_info.explanation}}</span>
      <span slot="introduce-date">2019</span>
      <span slot="introduce-name">pollra</span>
    </footer-box>
  </div>
</template>

<script>
import Vue from "vue"
import Vuex from "vuex"

import navigation from "./components/molecules/navigation/navigation";
import userIcon from "./components/atoms/buttons/user-icon";
import logoTexts from "./components/atoms/textBox/logoText/logo-texts";
import Categories from "./components/molecules/category/categories";
import Category from "./components/atoms/textBox/category";
import ContentBox from "./components/molecules/contents/content-box";
import ContentInfo from "./components/molecules/contents/content-info";
import FooterBox from "./components/molecules/footer/footer-box";
import { store } from "./components/store";
import vueHeadful from "vue-headful";

Vue.use(Vuex)

export default {
  name: 'App',
    store,
    components: {
      FooterBox,
      Category,
      Categories,
      "logo-texts":logoTexts,
      "user-icon":userIcon,
      "navigation":navigation,
      "content-box":ContentBox,
      "content-info":ContentInfo,
      "vue-headful":vueHeadful
    },
    created() {
      this.$store.commit("set_blog_info");
      this.$store.commit("set_categories_list");
    }
}
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  .nav_user_icon{
    width: 40px;
    height: 40px;
    top: 7px;
    left: 10px;
    display: inline-block;
    float: left;
  }
</style>
