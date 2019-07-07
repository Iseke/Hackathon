<template>
  <div class="hello">
    <span>Write site<input type="text" v-model="site"></span><br>
    <span>Write title<input type="text" v-model="word"></span><br>
    <button @click="search" class="button">Search</button><br>
    <h3>Download as: </h3>
    <button @click="dowloadCSV" class="button">CSV</button>
    <button @click="dowloadJSON" class="button">JSON</button>
    <button @click="dowloadExcell" class="button">Excell</button>

    <div v-for="n in news">
      <p>{{n.pagefrom}}</p>
      <h1>{{n.title}}</h1>
      <p>{{n.description}}</p>
    </div>

  </div>
</template>

<script>
  const SITE_STORE = 'cons-site'
  const WORD_STORE = 'cons-word'
export default {
  data(){
    return{
      site: '',
      word: ''
    }
  },
  created() {
    this.$store.dispatch('loadNews');
  },
  computed:{
    news(){
      return this.$store.getters.News
    }
  },
  methods:{
    dowloadCSV(){
      this.$store.dispatch('loadCSVFormat');
    },
    dowloadJSON(){
      this.$store.dispatch('loadJSONFormat');
    },
    dowloadExcell(){
      this.$store.dispatch('loadExcellFormat');
    },
    search(){
      localStorage.setItem(SITE_STORE,JSON.stringify(this.site));
      localStorage.setItem(WORD_STORE,JSON.stringify(this.word));

      this.$store.dispatch('loadNews');
      this.$store.dispatch('loadFilters');
      this.site = '';
      this.word = '';
    }

  }


}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >

  .button {
    background-color: #4CAF50; /* Green */
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
  }
</style>
