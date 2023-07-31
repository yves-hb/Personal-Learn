<template>
    <div>
        <button @click="openNavber">展开、折叠侧边栏</button>
        <div>Vue3的单文件Navber</div>
    </div>
</template>

<script>
export default{
    methods:{
        openNavber(){
            console.log();
        }
    }
}

</script>
<style scoped>
div{
    background: gray;
}
</style>