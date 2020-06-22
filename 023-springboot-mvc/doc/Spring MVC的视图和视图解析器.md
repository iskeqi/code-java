# Spring MVC的视图和视图解析器

**在没有使用前后端分离架构的时代，后端程序是要负责页面的转发的。这个时候，就涉及到如何处理 HTTP 响应数据（包含了 HTML 页面和实际的数据模型对应的数据）**。Spring MVC 中提供了多种方式来输出模型数据（实际上就是存储在了 request 对象中），分别介绍如下：

- ModelAndView：当控制器中的处理方法返回值类型为 ModelAndView 时，方法体即可通过该对象添加模型数据中
- @ModelAttribute：在方法入参标注改注解后，入参的对象就会被放到模型数据中
- Map 及 Model：如果方法入参为 java.util.Map 或者是 org.springframework.ui.Model、org.springframework.ui.ModelMap ，则当处理方法返回时，Map 中的数据就会自动添加到模型数据中
- @SessionAttribute：将模型中的某个属性暂时存到 HttpSession 中，以便多个请求之间可以共享这个属性

**以上，看着好像有 4 种方法，其实只有一种，就是 ModelAndView 。视图和视图解析器技术只有在前后端不分离的情况下才用到，前后端分离时，根本就不走这个流程。**

## 视图

视图的作用就是渲染模型数据，将模型中的数据以某种形式呈现给客户（通过 response 对象哦）。Spring MVC 中提供了一个视图接口 View，该接口中有两个方法，如下：

- String getContentType()：返回该视图能够处理的MIME 类型，比如 text/html、images/jpeg 等
- void render(@Nullable Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)：将模型数据以某种 MIME 类型渲染出来，然后再通过 response 对象输出到到客户端

Spring MVC 中内置了很多视图对象，比如能够渲染 JSP 视图的 InternalResourceView 对象，能够渲染 Thymeleaf 模板的 ThymeleafView 对象（需要额外导入依赖）。了解即可，因为目前业界大部分项目都是采用的前后端分离技术，压根就用不到这些。

## 视图解析器

Spring MVC 会根据视图解析器的配置来选择使用不同的视图解析器来解析逻辑视图，然后把逻辑视图转换成真正的视图对象。如果有多个视图解析器需要配置，就需要实现 Order 接口，Spring MVC 会根据视图解析器的配置顺序来依次解析逻辑视图，一旦解析成功，就不再继续后面的视图解析器。ViewResolver 接口有一个抽象方法，如下：

- View resolveViewName(String viewName, Locale locale)：该接口负责把逻辑视图名称转换成真正的视图对象

## 视图和视图解析器的工作流程

Controller 中的请求方法执行完成之后，最终都会返回一个 ModelAndView 对象。对于那些返回值是 String、View、或者 ModelMap 等类型的处理方法，Spring MVC 也会在内部将他们封装成一个 ModelAndView 对象，**该对象包含了视图逻辑名称和模型对象的信息**。

Spring MVC 借助视图解析器（ViewResolver）得到最终的视图对象（View），这可能是我们常见的 JSP 视图，也有可能是一个基于 Thymeleaf 模板技术的视图，也可能是 PDF、Excel 等视图。**对于最终究竟采用哪种视图对模型数据进行渲染，Controller 并不关心，这个完全由开发人员对视图解析器的配置决定。**

也就是说，Spring MVC 中的视图和视图解析器的工作流程如下：**Spring MVC 在调用了控制器中的方法执行业务逻辑之后，得到了一个 ModelAndView 对象作为方法返回值。然后它会调用系统中配置好的 ViewResolver 对象列表依次解析 ModelAndView 对象中包含的逻辑视图名称，直到找到一个可以解析该视图的视图解析器。然后，使用这个视图解析器来获得对象的视图对象，最后再使用视图对象去渲染具体的模型数据，最终将响应信息输出给客户端。**

## 最佳实践

- 前后端不分离：对于前端的每个页面，后台都有一个专门的接口和它一一对应（通常都是同时负责页面的转发和数据的响应，直接使用 ModelAndView 对象即可）。其它的接口全部采用 JSON 的方式进行请求和响应，前端则通过 AJAX 技术进行异步请求。
- 前后端分离：页面的跳转逻辑放在前端控制，后台系统只负责对外提供 JSON 请求接口。**也就是说，在前后端分离的情况下，是根本就用不到视图和视图解析器的。**

 