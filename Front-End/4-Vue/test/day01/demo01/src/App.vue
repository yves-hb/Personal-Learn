<script>
export default {
  data() {
    return {
      isActive: true,
      error: {}
    }
  },
  computed: {
    classObject() {
      return {
        active: this.isActive && !this.error,
        'text-danger': this.error
      }
    }
  }
}
</script>
<template>
  <div class="static" :class="classObject">
    这是内容
  </div>
</template>
<style scoped>
.active{
  font-size: 50px;
}
</style>
