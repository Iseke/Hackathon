<template>
  <div class="hello">
    <button @click="dowloadCSV" class="button">CSV download</button>
    <button @click="dowloadJSON"class="button">JSON download</button>
    <button @click="dowloadExcell"class="button">Excell download</button><br><br>
    <span>Write from which site you want parse<input v-model="site"></span><br><br>
    <span>Write word<input v-model="word"></span>
    <div v-for="n in news">
      <div class="neww">
        <p>{{n.pagefrom}}</p>
        <h2>{{n.title}}</h2>
        <p>{{n.description}}</p>
      </div>
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
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.neww {
  background-color: cornflowerblue;
  color: white;
  margin: 20px;
  padding: 20px;
}
#rcorners2 {
  border-radius: 25px;
  border: 2px solid #73AD21;
  padding: 20px;
  width: 200px;
  height: 150px;
}
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
