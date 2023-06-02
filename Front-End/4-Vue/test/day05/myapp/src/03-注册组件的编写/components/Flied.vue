<template>
    <div>
        <label :for="label">{{label}}</label>
        <input :type="type" :id="label" placeholder="aaa">
    </div>
</template>
<script>
export default{
    props:{
        label:{
            type:[String,Number],
            required:true
        },
        type:{
            validator(value){
                return ['text', 'password', 'number'].includes(value)
            }
        }
    }
}
</script>