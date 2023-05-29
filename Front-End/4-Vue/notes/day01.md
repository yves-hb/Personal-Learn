# 一、Vue简介

## （一） 什么是Vue

​		Vue是一套用于构建用户界面的**渐进式框架**。它基于标准 HTML、CSS 和 JavaScript 构建，并提供了一套声明式的、组件化的编程模型。

​		与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。另一方面，当与[现代化的工具链](https://v2.cn.vuejs.org/v2/guide/single-file-components.html)以及各种[支持类库](https://github.com/vuejs/awesome-vue#libraries--plugins)结合使用时，Vue 也完全能够为复杂的单页应用提供驱动。		

## （二）Vue的特点

### 1. 渐进式

### 2. 响应式编程

​		**MVVM** 是 vue 实现数据驱动视图和双向数据绑定的核心原理。MVVM指的是 Model、View 和 ViewModel，它把每个 HTML 页面都拆分成了这三个部分

- m:model:数据
- v:view:视图模板
- vm:ViewModel（Vue实例）

​		通过Vue实例来实现数据和模板的关联。在vue中如果更新的数据，页面中对应的渲染内容也会自动的更新。让我们以后可以将精力专注于数据处理，避免繁琐的dom操作。

![img](https://s2.loli.net/2023/05/25/IpAuqjTPm9cZYtE.png)

​		当**数据源发生变化**时，会被 `ViewModel`监听到，`VM` 会根据最新的数据源自动更新页面的结构。

​		当**表单元素的值发生变化**时，也会被`VM` 监听到，`VM`会把变化过后最新的值自动同步到 Model 数据源中 

### 3. 组件化

​		Vue将组成一个页面的HTML，CSS和JS合并到一个组件中，可以被其他组件或页面引入而重复利用。通常每个.Vue文件作为一个组件导出，组件可以作为基础组件（如按钮）或一个页面（如登录页面）。组件化很好的将一个庞大复杂的前端工程拆分为一个个组件，重复利用的性质也大大提高了开发的效率。

​		**组件化开发的优点：提高开发效率、方便重复使用、简化调试步骤、提升整个项目的可维护性、便于协同开发。**

# 二、安装Vue

## （一）script引用

```js
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
```



## （二）npm安装

### 1. 安装Node.js

**步骤 1：下载Node.js**

1. 在浏览器中打开 Node.js 的官方网站：[https://nodejs.org。](https://nodejs.org./)
2. 在首页上，选择推荐版本（LTS版本）或者其他您希望安装的版本。
3. 点击下载按钮，选择适合您的Windows系统的安装包（32位或64位）。

**步骤 2：安装Node.js**

1. 打开下载的安装包（.msi文件）。
2. 欢迎界面出现后，点击 "Next"。
3. 阅读许可协议并接受，然后点击 "Next"。
4. 选择安装路径，一般情况下可以保留默认设置，然后点击 "Next"。
5. 选择您希望安装的组件，通常建议保留默认设置并勾选 "Automatically install the necessary tools..."（自动安装所需的工具），然后点击 "Next"。
6. 选择开始菜单文件夹，然后点击 "Next"。
7. 勾选 "Automatically install the necessary tools..."（自动安装所需的工具）并选择 "Run npm install..."（运行 npm install 命令），然后点击 "Next"。
8. 确认安装设置，然后点击 "Install" 开始安装。
9. 安装完成后，点击 "Finish"。

**步骤 3：配置环境变量**

1. 右键点击 "此电脑"（或 "计算机"），然后选择 "属性"。
2. 在左侧导航栏中，点击 "高级系统设置"。
3. 在弹出的 "系统属性" 窗口中，点击 "环境变量" 按钮。
4. 在 "用户变量" 部分，点击 "新建"。
5. 在 "变量名" 输入框中输入 "NODE_HOME"。
6. 在 "变量值" 输入框中输入 Node.js 的安装路径，例如 "C:\Program Files\nodejs"。
7. 在 "系统变量" 部分，找到 "Path" 变量，双击进行编辑。
8. 在弹出的 "编辑环境变量" 窗口中，点击 "新建"。
9. 输入 "%NODE_HOME%"，然后点击 "确定"。
10. 点击 "确定" 关闭所有打开的窗口。

**步骤 4：验证安装**

1. 打开命令提示符（或 PowerShell）。
2. 输入以下命令来验证 Node.js 是否安装成功，并显示版本号：

```
node -v
```

1. 输入以下命令来验证 npm 是否安装成功，并显示版本号：

```
npm -v
```

如果您看到了 Node.js 和 npm 的版本号信息，则说明安装和配置都已成功完成。

**步骤 五：配置安装目录**

1. 打开资源管理器，并转到您希望用于全局安装和缓存的位置。
2. 在该位置创建两个文件夹：`node_global` 和 `node_cache`。

![img](https://s2.loli.net/2023/05/25/Wl42AF6EeouICRc.png)

**步骤 2：配置环境变量**

1. 右键点击 "此电脑"（或 "计算机"），然后选择 "属性"。
2. 在左侧导航栏中，点击 "高级系统设置"。
3. 在弹出的 "系统属性" 窗口中，点击 "环境变量" 按钮。
4. 在 "用户变量" 部分，找到 `NODE_GLOBAL` 变量，点击 "编辑"。
5. 在 "变量值" 输入框中，输入全局安装文件夹的路径，例如 `C:\node_global`。
6. 点击 "确定"。
7. 在 "用户变量" 部分，点击 "新建"。
8. 在 "变量名" 输入框中输入 `NODE_CACHE`。
9. 在 "变量值" 输入框中，输入缓存文件夹的路径，例如 `C:\node_cache`。
10. 点击 "确定"。
11. 点击 "确定" 关闭所有打开的窗口。

**步骤 3：更新 npm 配置**

1. 打开命令提示符（或 PowerShell）。
2. 运行以下命令来配置全局安装和缓存的路径：

```
npm config set prefix "%NODE_GLOBAL%"
npm config set cache "%NODE_CACHE%"
```

参考文档： [Node.js下载安装及环境配置教程【超详细】_nodejs下载安装教程_WHF__的博客-CSDN博客](https://blog.csdn.net/WHF__/article/details/129362462)

## （三）Vite安装

​		Vite是个Web开发构建工具，由于其原生ES模块导入方式，可以实现闪电般的冷服务启动。通过在终端运行以下命令，可以使用Vite快速构建Vue项目

### 方法一：npm安装

​		`my-vue-app` 为自定义项目名称

```js
# npm 6.x
npm create vite@latest my-vue-app --template vue

# npm 7+, extra double-dash is needed:
npm create vite@latest my-vue-app -- --template vue
```

### 方法二：yarn安装

```js
# yarn
yarn create vite my-vue-app --template vue
```

## 三、初始化一个Vue项目

## （一）项目结构

```text
├── build --------------------------------- 项目构建(webpack)相关配置文件，配置参数什么的，一般不用动 
│   ├── build.js --------------------------webpack打包配置文件
│   ├── check-versions.js ------------------------------ 检查npm,nodejs版本
│   ├── dev-client.js ---------------------------------- 设置环境
│   ├── dev-server.js ---------------------------------- 创建express服务器，配置中间件，启动可热重载的服务器，用于开发项目
│   ├── utils.js --------------------------------------- 配置资源路径，配置css加载器
│   ├── vue-loader.conf.js ----------------------------- 配置css加载器等
│   ├── webpack.base.conf.js --------------------------- webpack基本配置
│   ├── webpack.dev.conf.js ---------------------------- 用于开发的webpack设置
│   ├── webpack.prod.conf.js --------------------------- 用于打包的webpack设置
├── config ---------------------------------- 配置目录，包括端口号等。我们初学可以使用默认的。
│   ├── dev.env.js -------------------------- 开发环境变量
│   ├── index.js ---------------------------- 项目配置文件
│   ├── prod.env.js ------------------------- 生产环境变量
│   ├── test.env.js ------------------------- 测试环境变量
├── node_modules ---------------------------- npm 加载的项目依赖模块
├── src ------------------------------------- 我们要开发的目录，基本上要做的事情都在这个目录里。
│   ├── assets ------------------------------ 静态文件，放置一些图片，如logo等
│   ├── components -------------------------- 组件目录，存放组件文件，可以不用。
│   ├── main.js ----------------------------- 主js
│   ├── App.vue ----------------------------- 项目入口组件，我们也可以直接将组件写这里，而不使用 components 目录。
│   ├── router ------------------------------ 路由
├── static ---------------------------- 静态资源目录，如图片、字体等。
├── index.html ------------------------------ 	首页入口文件，你可以添加一些 meta 信息或统计代码啥的。
├── package.json ---------------------------- node配置文件，记载着一些命令和依赖还有简要的项目描述信息 
├──  .README.md------------------------------- 项目的说明文档，markdown 格式。想怎么写怎么写，不会写就参照github上star多的项目，看人家怎么写的
├── .xxxx文件：这些是一些配置文件，包括语法配置，git配置等
│   ├── .babelrc--------------------------------- babel配置文件
│   ├──  .editorconfig---------------------------- 编辑器配置
│   ├──  .eslintignore------------------------------- 配置需要或略的路径，一般build、config、dist、test等目录都会配置忽略
│   ├──  .eslintrc.js ------------------------------- 配置代码格式风格检查规则
│   ├──  .gitignore------------------------------- 配置git可忽略的文件
│   ├──  .postcssrc.js ------------------------------- css转换工具

```



# 四、Vue模板语法

​		Vue.js 使用了基于 HTML 的模板语法，允许开发者声明式地将 DOM 绑定至底层 Vue 实例的数据。所有 Vue.js 的模板都是合法的 HTML，所以能被遵循规范的浏览器和 HTML 解析器解析。

​		在底层的实现上，Vue 将模板编译成虚拟 DOM 渲染函数。结合响应系统，Vue 能够智能地计算出最少需要重新渲染多少组件，并把 DOM 操作次数减到最少。

## （一）插值

### 1. 文本

​		数据绑定最常见的形式就是使用“Mustache”语法 (双大括号) 的文本插值：

```html
<span>Message: {{ msg }}</span>
```

​		Mustache 标签将会被替代为对应数据对象上 `msg` property 的值。无论何时，绑定的数据对象上 `msg` property 发生了改变，插值处的内容都会更新。

​		示例：

```html
<!DOCTYPE html>
<html lang="zh_CN">
	<head>
		<meta charset="utf-8">
		<title>外部引入vue</title>
		<script src="./vue.js"></script>
	</head>
	<body>
		<div id="app">
			<h1>{{message}}</h1>
		</div>
		<script>
			const Counter={
				data(){
					return{
						message:"HelloWord"
					}
				}
			}
			/* 创建一个Vue对象并把Counter装填进去并挂载到id=app的元素上 */
			Vue.createApp(Counter).mount('#app');
		</script>
	</body>
</html>
```



​		通过使用 [v-once 指令](https://v2.cn.vuejs.org/v2/api/#v-once)，你也能执行一次性地插值，当数据改变时，插值处的内容不会更新。但请留心这会影响到该节点上的其它数据绑定：

```html
<span v-once>这个将不会改变: {{ msg }}</span>
```

```html
<body>
    <div id="app">
        <span v-once>{{num}}</span>
        <button @click="changeNum">功德+1</button>
    </div>
    <script>
        const Counter={
            data(){
                return{
                    num: 1
                }
            },
            methods:{
                changeNum:function(){
                    // this指向Vue实例
                    this.num++;
                }
            }
        }
        /* 创建一个Vue对象并把Counter装填进去并挂载到id=app的元素上 */
        Vue.createApp(Counter).mount('#app');
    </script>
</body>
```



### 2. 原始HTML

​	双大括号会将数据解释为普通文本，而非 HTML 代码。为了输出真正的 HTML，你需要使用 [v-html](https://v2.cn.vuejs.org/v2/api/#v-html)

```html
<p>Using mustaches: {{ rawHtml }}</p>
<p>Using v-html directive: <span v-html="rawHtml"></span></p>
```

​		这个 `span` 的内容将会被替换成为 property 值 `rawHtml`，直接作为 HTML——会忽略解析 property 值中的数据绑定。注意，你不能使用 `v-html` 来复合局部模板，因为 Vue 不是基于字符串的模板引擎。反之，对于用户界面 (UI)，组件更适合作为可重用和可组合的基本单位。

​		在不添加`v-html` 的情况下：输入的文本并不会直接被转换为html 

![aaa](https://s2.loli.net/2023/05/26/vz9nA76wy8tKJjE.png)![](https://s2.loli.net/2023/05/26/qz4nmZDas1ltkEM.png)

​		如果在父元素上添加`v-html` ,会覆盖其他内容

![image-20230526113705000](https://s2.loli.net/2023/05/26/gd9oveZwiXThuyj.png)![image-20230526113716698](https://s2.loli.net/2023/05/26/ARYoubwIiJTMd5a.png)

​		正确写法：

![image-20230526115149923](https://s2.loli.net/2023/05/26/t2DZa3B4Y9cNFUX.png)![image-20230526115158985](https://s2.loli.net/2023/05/26/wVBAQvM6h9ZoR1d.png)

​		**注意：在网站上动态渲染任意 HTML 是非常危险的，因为这非常容易造成 [XSS 漏洞](https://en.wikipedia.org/wiki/Cross-site_scripting)。请仅在内容安全可信时再使用 `v-html`，并且永远不要使用用户提供的 HTML 内容。**

## （二）Attribute 绑定

​		html 标签的预定义和自定义属性统一称为 `attribute` ，比如：input的type和name都可被成为attribute

```html
 <input type="checkbox" name="input-name"/>
```

### 1. 基本用法

​		由上文`v-html`可知，双大括号不能在 HTML attributes 中使用。想要响应式地绑定一个 attribute，应该使用 [`v-bind` 指令](https://cn.vuejs.org/api/built-in-directives.html#v-bind)：

```html
<body>
    <div id="app">
        <img v-bind:src="url" alt="">
    </div>
    <script>
        const Counter={
            data(){
                return{ url:"https://s2.loli.net/2023/05/26/t2DZa3B4Y9cNFUX.png" }
            },
        }
        Vue.createApp(Counter).mount('#app');
    </script>
</body>
```

**==注意，`v-bind`可以简写为 ':'，例如 v-bind:src="xxx"等价于 :src="xxx"==** 

### 2. 布尔型 Attribute

​		网页的布尔型 attribute 依据 true / false 值来决定 attribute 是否应该存在于该元素上，但Vue的判断方法存在不同之处。例如：

```html
<button :disabled="isButtonDisabled">Button</button>
```

​		当 isButtonDisabled 为真值或一个空字符串 (即 "") 时，元素会包含这个 `disabled` attribute。而当其为其他假值时 attribute 将被忽略。

### 3. 动态绑定多个值

​		通过一个包含多个 attribute 的 JavaScript 对象，就可以通过不带参数的 v-bind，将它们绑定到单个元素上，示例如下：

```html
<!DOCTYPE html>
<html lang="zh_CN">
	<head>
		<meta charset="utf-8">
		<title>外部引入vue</title>
		<script src="./vue.js"></script>
		<style>
			#id1{
				color: red;
			}
		</style>
	</head>
	<body>
		<div id="app">
			<p :=obj>111</p>
		</div>
		<script>
			const Counter={
				data(){
					return{
						obj:{
							id:"id1",
							class:"test"
						},
					}
				},
			}
			Vue.createApp(Counter).mount('#app');
		</script>
	</body>
</html>
```

![image-20230529160541751](https://s2.loli.net/2023/05/29/8mLs4WJGgjPdn9r.png)

## （三）使用 JavaScript 表达式

### 1. 普通的JavaScript表达式

​		Vue在所有的数据绑定中都支持完整的 JavaScript 表达式：

```vue
{{ number + 1 }}

{{ ok ? 'YES' : 'NO' }}

{{ message.split('').reverse().join('') }}

<div :id="`list-${id}`"></div>
```

​		这些表达式都会被作为 JavaScript ，以当前组件实例为作用域解析执行。

​		在 Vue 模板内，JavaScript 表达式可以被使用在如下场景上：

>   - 在文本插值中 (双大括号) 
>   - 在任何 Vue 指令 (以 `v-` 开头的特殊 attribute) attribute 的值中

**==注意：每个绑定仅支持【单一表达式】，也就是一段能够被求值的 JavaScript 代码。一个简单的判断方法是是否可以合法地写在 return 后面==** 

​		类似于下面的都是不可以的：

```html
<!-- 这是一个语句，而非表达式 -->
{{ var a = 1 }}

<!-- 条件控制也不支持，请使用三元表达式 -->
{{ if (ok) { return message } }}
```

### 2. 调用函数

​		可以在绑定的表达式中使用一个组件暴露的方法，也就是说可以在{{ }}、Attribute 绑定中进行函数的调用，示例如下：：

```html
<time :title="toTitleDate(date)" :datetime="date">
  {{ formatDate(date) }}
</time>
```

​		例如：

```html
<!DOCTYPE html>
<html lang="zh_CN">
	<head>
		<meta charset="utf-8">
		<title>外部引入vue</title>
		<script src="./vue.js"></script>
		<style></style>
	</head>
	<body>
		<div id="app">
			<span :title="toTitleDate(date)">
				{{ formatDate(date) }}
			</span>
		</div>
		<script>
			const Counter={
				data(){
					return{
						date:"张三",
						toTitleDate(date){
							return date+"你好";
						},
						formatDate(date){
							return date+"再见";
						}
					}
				},
			}
			Vue.createApp(Counter).mount('#app');
		</script>
	</body>
</html>
```

![image-20230529165636191](https://s2.loli.net/2023/05/29/42bZVnPRsKEhlYN.png)

### 3. 受限的全局访问

​		模板中的表达式将被沙盒化，仅能够访问到有限的全局对象列表。该列表中会暴露常用的内置全局对象，比如 Math 和 Date。

​		没有显式包含在列表中的全局对象将不能在模板内表达式中访问，例如用户附加在 window 上的属性。然而，你也可以自行在 app.config.globalProperties 上显式地添加它们，供所有的 Vue 表达式使用。



## （四）指令 Directives

​		指令是带有 v- 前缀的特殊 attribute。指令用于在表达式的值改变时，将某些行为应用到 DOM 上。Vue 提供了许多内置指令，包括上面我们所介绍的 v-bind 和 v-html。举例：

​		指令 attribute 的期望值为一个 JavaScript 表达式 (除了少数几个例外，即之后要讨论到的 <u>v-for</u>、<u>v-on</u> 和 <u>v-slot</u>)。一个指令的任务是在其表达式的值变化时响应式地更新 DOM。以 v-if 为例：

```html
<p v-if="seen">Now you see me</p>
```

这里，`v-if` 指令会基于表达式 `seen` 的值的真假来移除/插入该 `<p>` 元素。
