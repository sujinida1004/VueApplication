import Vue from 'vue'
import App from './App.vue'
import router from './router' // router 설치시 인트턴스 자동 등록
import vuetify from './plugins/vuetify' // vuetify 설치시 자동 등록

Vue.config.productionTip = false

new Vue({
  router, // router 설치시 인트턴스 자동 등록
  vuetify, // vuetify 설치시 자동 등록
  render: h => h(App)
}).$mount('#app')
