import Vue from 'vue'
import Router from 'vue-router'
import FrontMain from '../components/MainContent/FrontMain'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [{
    path: '/',
    name: 'frontmain',
    component: FrontMain
  }]
})
