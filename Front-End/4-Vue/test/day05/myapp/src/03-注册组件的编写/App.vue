<template>
    <div>
        <Flied
            ref="username" label="用户名" type="text"/>
        <Flied 
            ref="password" label="密码" type="password"/>
        <Flied
            ref="age" label="年龄" type="number"/>
        <button @click="handlerZhuce">注册</button>
        <button @click="handlerChongzhi">重置</button>
    </div>
</template>
<script>
import Flied from './components/Flied.vue';
export default{
    components:{
        Flied,
    },
    methods:{
        handlerZhuce(){
            console.log(this.$refs.Target);
        },
        handlerChongzhi(){
            console.log("点击重置");
        }
    }
}
</script>