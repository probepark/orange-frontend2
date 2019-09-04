import Vue from 'vue';
import Router from 'vue-router';
import Post from '@/components/pages/post';
import BoardList from '@/components/pages/board-list'
import Login from '@/components/pages/login'
import SignUp from '@/components/pages/signup'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Post',
      component: Post
    },
    {
      path: '/post/:num',
      name: 'Post',
      component: Post
    },
    {
      path: '/list/:category',
      name: 'BoardList',
      component: BoardList
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    // {
    //   path: '/signup',
    //   name: 'SignUp',
    //   component: SignUp
    // }
  ]
})
