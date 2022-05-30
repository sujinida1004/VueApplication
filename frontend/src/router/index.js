import Vue from 'vue' //vue 선언
import VueRouter from 'vue-router' //router 선언
// import HomeView from '../views/HomeView.vue'
import Dashboard from '@/views/Dashboard' //dashboard 추가
import GridSystem from '@/views/GridSystem' //GridSystem 추가
import GridListPage from '@/views/GridListPage' //GridListPage 추가
import BreakPoints from '@/views/BreakPoints' //BreakPoints 추가
import Typography from '@/views/Typography' //Typography 추가

import PostList from '@/views/Post/List' //PostListPage 추가
import PostWrite from '@/views/Post/Write' //PostWritePage 추가
import PostDetail from '@/views/Post/Detail' //PostDetailPage 추가

import BoardList from '@/views/Board/List' //BoardListPage 추가
import BoardWrite from '@/views/Board/Write' //BoardWritePage 추가
import BoardDetail from '@/views/Board/Detail' //BoardDetailPage 추가

Vue.use(VueRouter)

// 렌더링 페이징 매핑
const routes = [
  {
    path: '/',
    name: 'Dashboard', // 키워드
    component: Dashboard // 컴포넌트 렌더링
  },
  {
    path: '/grid-system',
    name: 'GridSystem',
    component: GridSystem
  },
  {
    path: '/grid-list-page',
    name: 'GridListPage',
    component: GridListPage
  },
  {
    path: '/BreakPoints',
    name: 'BreakPoints',
    component: BreakPoints
  },
  {
    path: '/Typography',
    name: 'BreakPoints',
    component: Typography
  },
  {
    path: '/board/list',
    name: 'BoardList',
    component: BoardList
  },
  {
    path: '/board/detail/:id',
    name: 'BoardDetail',
    component: BoardDetail
  },
  {
    path: '/board/write/:id?',
    name: 'BoardWrite',
    component: BoardWrite
  },
  {
    path: '/post/list',
    name: 'PostList',
    component: PostList
  },
  {
    path: '/post/detail/:id',
    name: 'PostDetail',
    component: PostDetail
  },
  {
    path: '/post/write/:id?',
    name: 'PostWrite',
    component: PostWrite
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

// router 인스턴스 생성
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 생성한 인스턴스를 export
export default router
