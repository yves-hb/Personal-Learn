<template>
    <div>app</div>
    <Child>
        <div>我是在app的一段html代码</div>
    </Child>
</template>
<script>
import Child from './Child.vue';
export default{
    components:{
        Child,
    }
}
</script>