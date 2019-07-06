import Vue from 'vue';
import Vuex from 'vuex';

import newsList from './modules/newslist'


Vue.use(Vuex)


export default new Vuex.Store({
    modules:{
        newsList,

    }
})
