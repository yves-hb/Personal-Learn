<script>
export default {
  data() {
    return {
      styleObj:{
        color: 'red',
        fontSize: '30px'
      }
    }
  }
}
</script>
<template>
  <div :style="styleObj">
    这是内容
  </div>
</template>
<style>
.active{
  font-size: 50px;
}
</style>
