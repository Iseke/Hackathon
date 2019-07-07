<template>

  <div class="hello">
<!--    <div class="sample-header">-->
<!--      <div class="sample-header-section">-->
<!--&lt;!&ndash;        <h1 id="newsHeader">Самые актуальные новости</h1>&ndash;&gt;-->
<!--      </div>-->
<!--    </div>-->

    <div class="sample-section-wrap">
        <strong><span class = "write" > TYPE A WEB-SITE<input class="inp" type="text" v-model="site"></span></strong><br>
        <strong><span class = "write" >TYPE AN ARTICLE<input class="inp" type="text" v-model="word"></span></strong><br>
        <button @click="search" class="button">Search</button><br>
        <button @click="loadResult" class="button">Prepare Results</button><br>

      <h3>DOWNLOAD AS: </h3>
        <button @click="dowloadCSV" class="button">CSV</button>
        <button @click="dowloadJSON" class="button">JSON</button>
        <button @click="dowloadExcell" class="button">Excel</button>

        <div class="articles" v-for="n in news">
          <p><img src=n.photolink></p>
          <p>{{n.pagefrom}}</p>
          <h1 class="headerOfArticle">{{n.title}}</h1>
          <p class="des">{{n.description}}</p>
        </div>
    </div>
    <footer>
      <div>
        <p class="ft">
          <strong>About Project</strong>
        </p>
      </div>
      <div>
        <p class="ft">
          <strong>Advertisment On Our Site</strong><br>
          fantasticfour@gmail.com
        </p>
      </div>
      <div class="ft">
        <p>
          <strong>Contacts</strong><br>
          Kazakhstan, Almaty<br>
          Method Pro<br>
          +7 777 777 77 77

        </p>
      </div>
      <div class="ft">
        <p>
          <strong>Privacy Policy</strong>
        </p>
      </div>
      <div>
        <p class="ft">
          <strong>Development and Maintenance</strong><br>
          <a href="https://github.com/Iseke/Hackathon">Fantastic Four Team</a>
        </p>
      </div>

    </footer>
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
    },
    loadResult(){
      this.$store.dispatch('loadFinished');
    }


  }


}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >

  .sample-header {
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    height: 20%;
    background-image: url("http://webmadewell.com/wp-content/uploads/2018/01/img-bg-sample-parallax-header.jpg");
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
  }
  .sample-header::before {
    content: "";
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-color: MidnightBlue;
    opacity: 0.3;
  }
  .sample-header-section {
    position: relative;
    padding: 15% 0 10%;
    max-width: 640px;
    margin-left: auto;
    margin-right: auto;
    color: white;
    text-shadow: 1px 1px 4px rgba(0, 0, 0, 0.5);
    font-family: "Lucida Sans Unicode";
  }


  #newsHeader {
    margin-bottom: 250px;
  }
  h1 {
    font-weight: 500;
    margin-inline: 50%;
  }
  h3 {
    font-family: "Lucida Sans Unicode";
  }
  .sample-section-wrap {
    position: relative;
    max-width: 80%;
    margin-left: auto;
    margin-right: auto;
    padding: 40px;
  }
  .button {
    /*background-color: #fafff4; !* Green *!*/
    color: black;
    border-color: #ffba78;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    font-family: "Lucida Sans Unicode";

  }

  .write{
    margin-top: 150px;
    font-family: "Lucida Sans Unicode";
    font-size: 100%;
  }
  .write .inp {
    width: 35%;
    height: 30px;
    margin: 15px 15px;
  }

  .articles {
    border: 2px #ffd29b solid;
    margin: 20px 0;
    padding: 0 20px;
  }

  .headerOfArticle {
    font-family: "Lucida Sans Unicode";
  }
  .des {
    text-align: left;
    font-family: "Lucida Sans Unicode";
  }

  footer {
    margin-top: 50%;
    padding:15px 5px;
    background-color: #ffba78;
    display: grid;
    grid-template-columns: 20% 20% 20% 20% 20%;
    width: 100%;
  }
  .ft {
    font-family: "Lucida Sans Unicode";
    font-size: 25px;
    color: #ffffff;;
    text-align: center;
  }


  a:visited {
    color: #494949;
  }

</style>
