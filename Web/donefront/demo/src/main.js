// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import router from './router';
import ElementUI from 'element-ui'
import axios from 'axios'
import VueJsonp from 'vue-jsonp'
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI,{size : 'small', zIndex : 3000});
Vue.config.productionTip = false
Vue.use(router);
Vue.use(VueJsonp);
Vue.prototype.$axios = axios
axios.defaults.baseURL = "http://localhost:8080/donessm_war_exploded"

/* eslint-disable no-new */
new Vue({
  render: h=>h(App),
}).$mount('#app')
