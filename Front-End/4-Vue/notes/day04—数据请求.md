# 一、数据请求

## （一）Fetch请求

### 1. Fetch简介

`Fetch API`提供了一个 JavaScript 接口，用于访问和操纵HTTP的请求和响应等。提供了一个全局 `fetch() `方法来跨网络异步获取资源。

### 2. Fetch示例

给`fetch()` 提供一个参数指明资源路径，会返回一个包含响应结果的promise。当然它只是一个 HTTP 响应，为了获取JSON的内容，我们需要使用 [`json()`](https://link.juejin.cn/?target=https%3A%2F%2Fdeveloper.mozilla.org%2Fzh-CN%2Fdocs%2FWeb%2FAPI%2FBody%2Fjson) 方法：

#### （1）默认发送Get请求

```js
fetch('http://example.com/movies.json')	
  .then(response => response.json())
  .then(data => console.log(data));
```

#### （2）带参数的Get请求

```js
var id=1
fetch(`https://www.easy-mock.com/mock/5f507e38a758c95f67d6eb42/fetch/getmsg?id=${id}`)	
.then(response => response.json())
.then(data => console.log(data));
```

#### （3）Post请求

```js
var data={
    id:'1',
}
fetch('https://www.easy-mock.com/mock/5f507e38a758c95f67d6eb42/fetch/postmsg',{
    method:'POST',
    body:data
})	
.then(response => response.json())
.then(data => console.log(data));
```

其他参考：[Fetch API介绍及使用Fetch发送请求 - 掘金 (juejin.cn)](https://juejin.cn/post/6868138631714848775)

## （二）axios

Axios 是一个基于 promise 的网络请求库，可以用于浏览器和 node.js

### 1. 安装方法

[起步 | Axios 中文文档 | Axios 中文网 (axios-http.cn)](https://www.axios-http.cn/docs/intro)

```html
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

### 2. 使用

[Axios API | Axios 中文文档 | Axios 中文网 (axios-http.cn)](https://www.axios-http.cn/docs/api_intro)

# 二、过滤器

在vue2中，开发者可以使用过滤器来处理通用文本格式，但vue3不再支持过滤器。

取而代之的是，建议用方法调用或计算属性来替换过滤器。

过滤器参考：[过滤器 — Vue.js (vuejs.org)](https://v2.cn.vuejs.org/v2/guide/filters.html)

# 三、组件基础

## （一）定义一个组件

```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>组件1</title>
    <script src="vue.js"></script>
</head>

<body>
    <div id="box">
        <test-a></test-a>
    </div>

    <script>
        let box = {
            data() {
                return {}
            }
        }
        let app = Vue.createApp(box)
        // 定义组件 component方法可以多次使用
        app.component("test-a", {
            // 输入模板
            template: `
                <nav style="color:red">
                    <p v-for="item of dataList">{{item}}</p>
                    <test-b></test-b>
                </nav>
            `,
            // 局部组件定义
            components: {
                "test-b": {
                    template: `<div style="background-color: red;">
        <button>点击</button>
    </div>`
                }
            },
            // 可以结合vue模板语法创造组件
            data() {
                return {
                    dataList: ["首页", "新闻", "产品"]
                }
            }
        })
        app.mount('#box');
    </script>
</body>
</html>
```

写法缺点：

- dom高亮和代码提示缺失
- css只能行内设置
- 多层嵌套导致结构混乱

## （二）单文件组件（SFC）

当使用构建步骤时，我们一般会将 Vue 组件定义在一个单独的 `.vue` 文件中，这被叫做[单文件组件](https://cn.vuejs.org/guide/scaling-up/sfc.html) (简称 SFC)：

```html
<script>
export default {
  data() {
    return {
      count: 0
    }
  }
}
</script>

<template>
  <button @click="count++">You clicked me {{ count }} times.</button>
</template>
```

