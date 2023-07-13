# 缓存

 ==缓存是每一个系统都应该考虑的功能，它用来加速系统的访问，提升系统的性能。== 比如说一些经常需要访问的高频热点数据，例如：电商网站的商品信息。 如果商品信息存储在数据库中，每次来查询商品信息都要来查询数据库的话，这样的操作耗时太大，代价也相对太大。 此时我们可以引入一个缓存中间件，将商品信息存放在缓存中，就不需要直接来查询数据库了。 先来查询缓存中是否有该商品的信息，如果有就直接拿来使用；如果没有的话，然后再去数据库中查询，然后再将数据放回到缓存。==因为应用程序与缓存的交互是非常快的，这样的话就可以大大减缓数据库的压力。==
       再比如：一些临时性的数据，为某个用户的手机号发送了验证码，三分钟有效，过期删除。如果将这些数据存储在数据库中，也是非常有压力的。我们也可以将这些数据存储在缓存中间件中。系统直接从缓存中获取数据即可。

缓存在系统中用的还是非常多的。所以为了统一缓存的开发规范，提升系统的扩展性。J2EE 发布了 JSR-107规范。主要提供了5个接口。

# JSR-107

## 1. 什么是JSR-107

参考: [JSR-107缓存规范介绍](https://blog.csdn.net/lzb348110175/article/details/105341703)

`JSR`是`Java Specification Requests`的缩写，意思是Java 规范提案。2012年10月26日JSR规范委员会发布了JSR 107（JCache API的首个早期草案）。JCache 规范定义了一种对Java对象临时在内存中进行缓存的方法，包括对象的创建、共享访问、假脱机（spooling）、失效、各JVM的一致性等，可被用于缓存JSP内最经常读取的数据。
       Java Caching 定义了5个核心接口，分别是CachingProvider、CacheManager、Cache、Entry 和 Expiry。

| 接口              | **介绍**                                                     |
| ----------------- | ------------------------------------------------------------ |
| `CachingProvider` | **缓存提供者。** 定义了创建、配置、获取、管理和控制多个 CacheManager。一个应用可以在运行期访问多个 CachingProvider。 |
| `CacheManager`    | **缓存管理器。** 定义了创建、配置、获取、管理和控制多个唯一命名的 Cache，这些 Cache 存在于 CacheManager 的上下文中。一个 CacheManager 仅被一个 CachingProvider 所拥有。 |
| `Cache`           | **缓存组件。** 是一个类似 Map 的数据结构并临时存储以 key 为索引的值。一个 Cache 仅被一个 CacheManager 所拥有。 |
| `Entry`           | **键值对。** 是一个存储在 Cache 中的 key-value 对。          |
| `Expiry`          | **有效期。** 每一个存储在 Cache 中的条目有一个定义的有效期。一旦超过这个时间，条目为过期的状态。一旦过期，条目将不可访问、更新和删除。缓存有效期可以通过 ExpiryPolicy 设置。 |

## 2. 应用调用缓存图示

应用来调用缓存，首先会先调用CachingProvider(缓存提供者)，缓存提供者管理了多个CacheManager(缓存管理器)，缓存管理器中才真正的Cache缓存。缓存管理器中可以管理不同类型的缓存，比如：Redis、EhCache 等。

在具体缓存组件中，我们还可以设置不同模块的缓存，比如：Redis 中我们可以来缓存 商品信息、热点数据 等不同模块数据，每个缓存都是Entry<K,V>键值对类型。并且我们可以对缓存设置Expiry过期时间，指定缓存存活的时间。

缓存在我们应用开发中的调用步骤，如下图所示：

![在这里插入图片描述](img/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2x6YjM0ODExMDE3NQ==,size_16,color_FFFFFF,t_70.png)

# Spring 缓存机制

参考:[Spring 缓存在项目中的使用](https://blog.csdn.net/lzb348110175/article/details/105342363)

## 1. Spring缓存机制介绍

Spring 从 3.1开始，针对缓存定义了org.springframework.cache.Cache和org.springframework.cache.CacheManager接口，来统一不同的缓存技术。并支持使用 JCache（JSR-107规范）注解来简化项目的开发:

- Cache接口为缓存的组件规范定义，包含缓存的各种操作集合;
- Cache接口下Spring提供了各种xxxCache的实现;如RedisCache，EhCacheCache ,ConcurrentMapCache等;
- 每次调用需要缓存功能的方法时，Spring会检查指定参数的指定的目标方法是否已经被调用过﹔如果有就直接从缓存中获取方法调用后的结果，如果没有就调用方法并缓存结果后返回给用户。下次调用直接从缓存中获取。
- 使用Spring缓存抽象时我们需要关注以下两点;
  - 确定方法需要被缓存以及它们的缓存策略
  - 从缓存中读取之前缓存存储的数据

   Spring 的缓存机制非常灵活，可以对容器中任意 Bean 或者 Bean 的方法进行缓存，因此这种缓存机制可以在 JavaEE 应用的任何层次上进行缓存。在缓存的具体实现上，Spring 缓存底层也是借助其他缓存工具来实现的，例如 EhCache(Hibernate缓存工具），上层则以统一 API 编程。

## 2. spring缓存相关概念

1. 两个接口

`Cache`：缓存接口，用来定义缓存的各种操作。Spring提供的具体实现有：RedisCache、EhCacheCache、ConcurrentMapCache等；

`CacheManager`：缓存管理器，管理各种缓存（Cache）组件

2. 三个注解(方法层次)

`@Cacheable`：标注在方法上，能够根据方法的请求参数等对其结果进行缓存。代表一个方法能被缓存

`@CacheEvict`：清空缓存(标注在删除方法上，用来清空缓存)

`@CachePut`：更新缓存。保证方法被调用，同时更新后的结果被缓存。

3. 一个注解(功能层次)

`@EnableCaching`：开启基于注解的缓存（想要使用缓存，就需要开启缓存注解）

4. 两个自定义

`keyGenerator`：缓存数据时key生成策略

`serialize`：缓存数据时 value 值序列化策略

## 3. SpringCache在项目中的使用

项目由Spring Boot + MyBatis-Plus 框架组成 , 展示一下缓存在项目中的使用。

[User实体类](..\cache\src\main\java\com\yves\cache\entity\User.java)

[UserMapper类](..\cache\src\main\java\com\yves\cache\mapper\UserMapper.java)

[UserService类](..\cache\src\main\java\com\yves\cache\service\UserService.java)

[UserServiceImpl类](..\cache\src\main\java\com\yves\cache\service\UserService.java)

[UserController类](..\cache\src\main\java\com\yves\cache\web\UserController.java)

### (1) @EnableCaching 开启基于注解的缓存

```java
@SpringBootApplication
@MapperScan("com.yves.cache.mapper")
@EnableCaching
public class SpringCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCacheApplication.class, args);
        System.out.println("启动成功!");
    }
}
```

### (2) @Cacheable

注解表示这个方法有了缓存的功能，方法的返回值会被缓存下来，下一次调用该方法前，会去检查是否缓存中已经有值，如果有就直接返回，不调用方法。如果没有，就调用方法，然后把结果缓存起来。这个注解**一般用在查询方法上**。

```java
// 在UserService或 UserServiceImpl的方法上添加注解
@Cacheable(value = "user")
public User findById(Integer userId);
```

@Cacheable注解共有9个属性可配置，这些属性的配置可参考：**[@Cacheable注解属性介绍](https://blog.csdn.net/lzb348110175/article/details/105349109)**。

### (3) @CachePut

加了`@CachePut`注解的方法，会把方法的返回值put到缓存里面缓存起来，供其它地方使用。它**通常用在新增或更新方法上**。

### (4)@CacheEvict

使用了`CacheEvict`注解的方法，会清空指定缓存。**一般用在更新或者删除的方法上**。

### (5)@Caching

Java注解的机制决定了，一个方法上只能有一个相同的注解生效。那有时候可能一个方法会操作多个缓存（这个在删除缓存操作中比较常见，在添加操作中不太常见）。

Spring Cache当然也考虑到了这种情况，`@Caching`注解就是用来解决这类情况的，源码如下:

```java
public @interface Caching {
    Cacheable[] cacheable() default {};
    CachePut[] put() default {};
    CacheEvict[] evict() default {};
}
```

### (6)@CacheConfig

前面提到的四个注解，都是Spring Cache常用的注解。每个注解都有很多可以配置的属性，这个我们在下一节再详细解释。但这几个注解通常都是作用在方法上的，而有些配置可能又是一个类通用的，这种情况就可以使用`@CacheConfig`了，它是一个类级别的注解，可以在类级别上配置cacheNames、keyGenerator、cacheManager、cacheResolver等。

### (7) 注解参数解读

| 参数名               | 参数方法                                                     |
| -------------------- | ------------------------------------------------------------ |
| `value`/`cacheNames` | 缓存容器名 , 可同时定义多个 如 value={"user"} , 将方法结果保存在名为"user"的缓存容器中 |
| `key`                | 可以通过 key 属性来指定缓存数据所使用的的 key，默认使用的是方法调用传过来的参数作为 key。**`最终缓存中存储的内容格式为：Entry<key,value> 形式。`**<br />  如果请求没有参数：`key=new SimpleKey()；`<br />  如果请求有一个参数：`key=参数的值` <br />  如果请求有多个参数：`key=newSimpleKey(params)；`<br />key值的编写，可以使用 ***SpEL*** 表达式的方式来编写；除此之外，我们同样可以使用 `keyGenerator` 生成器的方式来指定 key，我们只需要编写一个 keyGenerator ，将该生成器注册到 IOC 容器即可。 |
| `keyGenerator `      | key 的生成器。如果觉得通过参数的方式来指定比较麻烦，我们可以自己指定 key 的生成器的组件 id。key/keyGenerator属性：二选一使用。我们可以通过自定义配置类方式，将 keyGenerator 注册到 IOC 容器来使用。<br />参考代码: [MyCacheConfig](..\cache\src\main\java\com\yves\cache\config\MyCacheConfig.java) |
|                      |                                                              |



# 参考资料

[09 Cacheable用法_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1ex411d7ky/?p=9&spm_id_from=pageDriver&vd_source=73148abc9bb63ed9ac03e82f65b68312)

[Spring Cache，从入门到真香 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/266804094)
