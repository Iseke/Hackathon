import axios from 'axios'

export default {
    state:{
        newsList:[],
    },
    getters:{
        News: state=> state.newsList
    },
    mutations:{
        SET_NEWS(state, news){
            state.newsList = news
        }
    },
    actions:{
        loadNews({commit}){
            axios.get('http://localhost:8000/api/news/')
                 .then(res=>{
                     commit('SET_NEWS',res.data)
                 });
        },
        loadCSVFormat({}){
            axios({
                url: 'http://localhost:8000/api/export/csv/',
                method: 'GET',
                responseType: 'blob', // important
            }).then((response) => {
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', 'news.csv'); //or any other extension
                document.body.appendChild(link);
                link.click();
            });
        },
        loadJSONFormat({}){
            axios({
                url: 'http://localhost:8000/api/export/json/',
                method: 'GET',
                responseType: 'blob', // important
            }).then((response) => {
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', 'news.json'); //or any other extension
                document.body.appendChild(link);
                link.click();
            });
        },
        loadExcellFormat({}){
            axios({
                url: 'http://localhost:8000/api/export/excell/',
                method: 'GET',
                responseType: 'blob', // important
            }).then((response) => {
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', 'news.xlsx'); //or any other extension
                document.body.appendChild(link);
                link.click();
            });
        }
    },
}
