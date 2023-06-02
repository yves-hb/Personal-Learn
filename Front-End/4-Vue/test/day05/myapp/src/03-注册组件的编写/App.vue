<template>
    <div>

        <Flied label="用户名" type="text"/>
        <Flied label="密码" type="password"/>
        <Flied label="年龄" type="number"/>
    </div>
</template>
<script>
import Flied from './components/Flied.vue';
export default{

    components:{
        Flied,
    }
}
</script>