<!-- <script setup>
/**
 * import 引入其他组件配置
 * 语法: import 组件名 form 组件相对路径
 */
import HelloWorld from './components/HelloWorld.vue'
</script> -->

<script>
export default{
  data(){
    return{
      name:"张三",
      age:20
    }
  }
}

</script>

<template>
  <div class="logo">
    <p>你好: {{name}}</p>
    <span>{{age}}</span>
  </div>
</template>

<!-- <template>
  <div>
    <a href="https://vitejs.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div>
  <HelloWorld msg="HelloWorld" />
</template> -->

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
