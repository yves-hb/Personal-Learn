<template>
  <div id="root">
    <Navber class="navber"></Navber>
    <Layout class="layout"></Layout>
  </div>
</template>
<script>
import Navber from './components/Navber.vue';
import Layout from './components/Layout.vue';
export default {
  components: {
    Navber,
    Layout
  }
}
</script>
<style>
* {
  margin: 0px;
  padding: 0px;
}

#root {
  display: flex;
  height: 100px;
  flex-direction: column;
}

.navber {
  height: 50px;
  flex: 1;
}

.layout{
  flex: 1;
  display: flex;
}
</style>