# 使用WebMvcConfigurer配置SpringMVC

实际使用 Spring MVC 的过程中少不了一些配置，在 XML 还存在的时候，多数都是使用的 XML 进行配置。但是，在 SpringBoot 大行其道的时代，Java-based configuration 才是主流。好在 SpringMVC 提供了一个 WebMvcConfigurer 接口来供用户进行 MVC 配置，只需要实现对应的方法即可。

## WebMvcConfigurer 

这个接口一共有 18 个 default 方法，作用各不相同，也没有必要全部掌握，用到一个总结一个呗。更多信息参考官方文档！

### addInterceptors(InterceptorRegistry registry)

拦截器配置

### addCorsMappings(CorsRegistry registry)

跨域配置

## 参考链接

- https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-config