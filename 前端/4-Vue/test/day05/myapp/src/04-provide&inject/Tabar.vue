<style scoped>
ul{
    display: flex;
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 50px;
    line-height: 50px;
}
li{
    flex: 1;
    text-align: center;
}
</style>

<script>
export default{
    data(){
        return{
            dataList:["首页","列表","我的"]
        }
    }
}
</script>

<template>
    <div>
        <li v-for="data in dataList" :key="data">
            {{ data }}
        </li>
    </div>
</template>