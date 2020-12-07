# Knife4j使用说明

## 前后端分离

在一个采用前后端分离开发模式的团队中，想要前后端人员高效合作，提高团队整体开发效率，通常都需要做好以下几点：

- 后端编写一份完善的接口文档，接口中的各种细节都要明确
- 开接口评审会，前后端达成一致后，再各自开始编码
- 严格约定开发和联调的边界，严禁一边开发一边联调
- 前后端各自测试好自己编写的功能后再联调，避免联调时问题频出

## 接口文档要素

想要编写一个完善的接口文档需要注意以下几点：

- 接口名称
- 接口地址
- 请求方式
- 请求参数
  - 参数名称
  - 参数类型
  - 参数说明
  - 是否必选
  - 参数示例
- 响应参数
  - 参数名称
  - 参数说明
  - 参数示例

## 后端编写接口文档的痛点

接口文档的要点并不多，但是想要拿出一份非常完善的文档也很困难，通常都需要花费很多时间。后端开发一个功能需要以下流程：

- 理解产品需求，根据需求设计数据库表接口
- 分析功能，确定有哪些接口
- 从数据库设计文档中挨个拷贝字段到 word 文档
- 从 word 文档中拷贝字段到代码中，编写代码
- 从 word 文档中拷贝字段到 postman 中，进行测试

以上步骤需要不断的重复，接口数量一多，就难免会出错。而且这个工作及其耗时，枯燥！

## swagger 的作用

通过在 Controller 中接口和请求/响应参数中，添加注解信息来描述接口。最后扫描对应注解，并统一生成接口文档，提供在线调试工具。这种方式能够极大的提升开发效率，某种程度上还起到了规范代码编写的作用。

## swagger、swagger-bootstrap-ui、knife4j 三者的关系及优缺点

swagger 是 SmartBear Software 组织开发的接口文档工具，后两者则是由国内的 [萧明](https://gitee.com/xiaoym) 在 swagger 的基础上改造的，提供了更多的功能，优化了使用方式。其中 knife4j 是 swagger-bootstrap-ui 的升级版。三者之中，尽管原理相同，但是推荐使用 knife4j。

swagger 的缺点：

- 无接口分组排序、分组中的接口排序功能
- 无接口模块区分，无法形成 模块-接口分组-接口 的三级排序
- 文档 UI 界面查看和调试不方便
- 无法导出文档

萧明在 swagger 的基础上提供了更多的功能，如下：

- 提供了 模块-分组-接口 三级接口组织接口文档
- 提供了分组排序、接口排序功能
- 更美观易用的 UI 界面、接口要素都能清晰展示
- 拥有侧边栏，调试也更为方便
- 导出文档功能已完善，格式良好，稍作修改即可作为对外发布文档

但是更为推荐使用 knife4j ，而不是 swagger-bootstrap-ui 的理由如下：

- UI 界面略丑
- 作者已不再更新和维护
- 导出文档功能格式没有达到稍作修改即可对外发布的标准

## 如何在项目中集成 knife4j

1. 导入依赖

   ```xml
   <dependency>
       <groupId>com.github.xiaoymin</groupId>
       <artifactId>knife4j-spring-boot-starter</artifactId>
       <version>2.0.7</version>
   </dependency>
   ```

2. 在 application.yml 文件中做出以下配置

   ```yaml
   knife4j:
       enable: true # 开启 knife4j 增强功能
       basic:
           enable: true # 开启文档访问权限（首次访问，会在浏览器开启弹框要求输入用户名密码）
           username: admin # 账号
           password: 123456 # 密码
   ```

3. 在拦截器或者过滤器中放行以下路径

   ```java
   String[] knife4jPaths = new String[]{
       "/doc.html",
       "/webjars/**",
       "/swagger-resources/**",
       "/swagger-ui.html/**",
       "/v2/**",
       "/favicon.ico",
       "/error"
   };
   ```

4. 创建 knife4j 配置类

   ```java
   @Configuration
   @EnableSwagger2WebMvc
   public class Knife4jConfiguration {
   
       /**
        * 如果对项目中的接口进行分组，拷贝多份即可
        *
        * @return r
        */
       @Bean
       public Docket sys() {
           return new Docket(DocumentationType.SWAGGER_2)
                   .useDefaultResponseMessages(false) // 关闭 swagger 默认响应状态码
                   .groupName("一、系统管理模块") // 指定模块名称
                   .apiInfo(systemMangerInfo())
                   .select()
                   .apis(RequestHandlerSelectors.basePackage("com.keqi.knife4j.sys")) // 扫描指定包路径下的接口
                   .paths(PathSelectors.any())
                   .build();
       }
   
       private ApiInfo systemMangerInfo() {
           return new ApiInfoBuilder()
                   .title("knife4j")
                   .description("knife4j 项目接口文档")
                   .termsOfServiceUrl("http://localhost:9090/knife4j")
                   .version("1.0")
                   .build();
       }
   }
   ```

   

    

   

   



