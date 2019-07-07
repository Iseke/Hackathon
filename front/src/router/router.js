import Vue from 'vue';
import VueRouter from 'vue-router';

import Main from '../components/Main.vue'
import nn from  '../components/Lorem'

Vue.use(VueRouter);

export default new VueRouter({
    routes:[
        {path: '/main', component: Main},
        {path: '/news', component: nn},

    ],
    mode: 'history',
})
