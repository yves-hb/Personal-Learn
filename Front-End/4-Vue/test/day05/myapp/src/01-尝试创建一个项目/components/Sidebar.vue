<template>
    <div>
        <ul>
            <li v-for="(data,index) in dataList" :key="index">{{data}}</li>
        </ul>
    </div>
</template>
<script>
export default{
    data(){
        return{
            dataList:["首页","权限管理","用户管理","个人中心"]
        }
    }
}
</script>



<style scoped>
div{
    width: 100px;
}
li{
    padding: 10px;
    text-align: center;
}
</style>