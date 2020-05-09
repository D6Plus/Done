import Vue from 'vue'
import Router from 'vue-router'
import MainContainer from "../components/MainContainer/MainContainer";
import SystemInformation from "../components/MainContainer/SystemInformation/SystemInformation";

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [{
        path: '/',
        name: 'MainContainer',
        component: MainContainer
    }, {
        path: '/',
        name: 'SystemInformation',
        component: SystemInformation
    }]
})