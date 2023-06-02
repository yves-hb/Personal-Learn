<template>
    <div>
        <label :for="label">{{ label }}</label>
        <input :type="type" :id="label" v-model="myvalue">
        <span>展示輸入內容: {{myvalue}}</span>
    </div>
</template>
<script>
export default {
    data() {
        return {
            myvalue:""
        }
    },
    props: {
        label: {
            type: [String, Number],
            required: true
        },
        type: {
            validator(value) {
                return ['text', 'password', 'number'].includes(value)
            }
        }
    }
}
</script>