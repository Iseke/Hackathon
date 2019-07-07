<template>
  <div class="hello">
    <div v-for="n in news">
      <p>{{n.pagefrom}}</p>
      <h1>{{n.title}}</h1>
      <p>{{n.description}}</p>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      site:'',
      word:''
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

  }


}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >


</style>
