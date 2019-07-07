<template>
  <div id="app">
    <h1>Main News</h1>

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
  background: #1abc9c;
  color: white;
  font-size: 30px;
}
</style>
