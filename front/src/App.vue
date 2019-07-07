<template>
  <div id="app">
<!--    <h1>Main News</h1>-->
    <div class="headOfSite">
      <strong><h1>
        САМЫЕ АКТУАЛЬНЫЕ НОВОСТИ СО ВСЕГО МИРА
        </h1></strong>
    </div>
    <hr>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',

}
</script>

<style>

#app{
  padding: 60px;
  text-align: center;
  background: #d5996b;
  color: white;
  font-size: 30px;
}

  .headOfSite{
    font-family: "Lucida Sans Unicode";
  }
</style>
