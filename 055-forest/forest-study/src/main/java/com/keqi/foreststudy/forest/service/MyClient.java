package com.keqi.foreststudy.forest.service;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.callback.OnError;
import com.dtflys.forest.callback.OnSuccess;
import com.dtflys.forest.http.ForestResponse;
import com.keqi.foreststudy.forest.interceptor.SimpleInterceptor;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

@BaseRequest(interceptor = SimpleInterceptor.class)
public interface MyClient {

    /*
        通过 header 、url、body 传递参数，是非常简单的，看些官方



     */

    @Get(url = "https://wwww.baiduw.com")
    String send(@Var("username") String username, OnSuccess<String> onSuccess, OnError onError);

    @Get(url = "https://wwww.baidu.com")
    String helloForest();

    // GET请求
    @Get("http://localhost:8080/hello")
    String simpleGet();

    // GET请求
    @GetRequest("http://localhost:8080/hello")
    String simpleGetRequest();

    // POST请求
    @Post("http://localhost:8080/hello")
    String simplePost();

    // POST请求
    @PostRequest("http://localhost:8080/hello")
    String simplePostRequest();

    // PUT请求
    @Put("http://localhost:8080/hello")
    String simplePut();

    // PUT请求
    @PutRequest("http://localhost:8080/hello")
    String simplePutRequest();

    // HEAD请求
    @HeadRequest("http://localhost:8080/hello")
    String simpleHead();

    // Options请求
    @Options("http://localhost:8080/hello")
    String simpleOptions();

    // Options请求
    @OptionsRequest("http://localhost:8080/hello")
    String simpleOptionsRequest();

    // Delete请求
    @Delete("http://localhost:8080/hello")
    String simpleDelete();

    // Delete请求
    @DeleteRequest("http://localhost:8080/hello")
    String simpleDeleteRequest();

    /**
     * 整个完整的URL都通过 @Var 注解或 @DataVariable 注解修饰的参数动态传入
     */
    //@Request("${myURL}")
    //String send1(@Var("myURL") String myURL);

    /**
     * 通过参数转入的值值作为URL的一部分
     */
    //@Request("http://${myURL}/abc")
    //String send2(@Var("myURL") String myURL);


    /**
     * 直接在url字符串的问号后面部分直接写上 参数名=参数值 的形式
     * 等号后面的参数值部分可以用 ${变量名} 这种字符串模板的形式替代
     * 在发送请求时会动态拼接成一个完整的URL
     */
    //@Request("http://localhost:8080/abc?a=${a}&b=${b}&id=0")
    //String send2(@Var("a") String a, @Var("b") String b);


    /**
     * 使用 @Query 注解，可以直接将该注解修饰的参数动态绑定到请求url中
     * 注解的 value 值即代表它在url的Query部分的参数名
     */
    //@Request("http://localhost:8080/abc?id=0")
    //String send2(@Query("a") String a, @Query("b") String b);



    /**
     * 使用 @Query 注解，可以修饰 Map 类型的参数
     * 很自然的，Map 的 Key 将作为 URL 的参数名， Value 将作为 URL 的参数值
     * 这时候 @Query 注解不定义名称
     */
    //@Get("http://localhost:8080/abc?id=0")
    //String send2(@Query Map<String, Object> map);


    /**
     * @Query 注解也可以修饰自定义类型的对象参数
     * 依据对象类的 Getter 和 Setter 的规则取出属性
     * 其属性名为 URL 参数名，属性值为 URL 参数值
     * 这时候 @Query 注解不定义名称
     */
    //@Get("http://localhost:8080/abc?id=0")
    //String send2(@Query UserInfo user);

    @Request(
            url = "http://localhost:8080/hello/user",
            headers = {
                    "Accept-Charset: utf-8",
                    "Content-Type: text/plain"
            }
    )
    String multipleHeaders();

    @Request(
            url = "http://localhost:8080/hello/user",
            headers = {
                    "Accept-Charset: ${encoding}",
                    "Content-Type: text/plain"
            }
    )
    String bindingHeader(@Var("encoding") String encoding);


    /**
     * 使用 @Header 注解将参数绑定到请求头上
     * @Header 注解的 value 指为请求头的名称，参数值为请求头的值
     * @Header("Accept") String accept将字符串类型参数绑定到请求头 Accept 上
     * @Header("accessToken") String accessToken将字符串类型参数绑定到请求头 accessToken 上
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void postUser1(@Header("Accept") String accept, @Header("accessToken") String accessToken);


    /**
     * 使用 @Header 注解可以修饰 Map 类型的参数
     * Map 的 Key 指为请求头的名称，Value 为请求头的值
     * 通过此方式，可以将 Map 中所有的键值对批量地绑定到请求头中
     */
    @Post("http://localhost:8080/hello/user?username=foo")
    void headHelloUser2(@Header Map<String, Object> headerMap);


    /**
     * 使用 @Header 注解可以修饰自定义类型的对象参数
     * 依据对象类的 Getter 和 Setter 的规则取出属性
     * 其属性名为 URL 请求头的名称，属性值为请求头的值
     * 以此方式，将一个对象中的所有属性批量地绑定到请求头中
     */
    //@Post("http://localhost:8080/hello/user?username=foo")
    //void headHelloUser3(@Header MyHeaderInfo headersInfo);

    /**
     * contentType 属性不设置默认为 application/x-www-form-urlencoded
     * 要以对象作为表达传输项时，其 @Body 注解的 value 名称不能设置
     */
    /*@Post(
            url = "http://localhost:8080/hello/user",
            headers = {"Accept:text/plain"}
    )*/
    //String send(@Body User user);

    /**
     * 被@JSONBody注解修饰的参数会根据其类型被自定解析为JSON字符串
     * 使用@JSONBody注解时可以省略 contentType = "application/json"属性设置
     */
    //@Post("http://localhost:8080/hello/user")
    //String helloUser(@JSONBody User user);

    /**
     * 发送Byte数组类型数据
     */
    @Post(
            url = "/upload/${filename}",
            contentType = "application/octet-stream"
    )
    String sendByteArryr(@Body byte[] body, @Var("filename") String filename);

    /**
     * 发送File类型数据
     */
    @Post(
            url = "/upload/${filename}",
            contentType = "application/octet-stream"
    )
    String sendFile(@Body File file, @Var("filename") String filename);

    /**
     * 发送输入流类型数据
     */
    @Post(
            url = "/upload/${filename}",
            contentType = "application/octet-stream"
    )
    String sendInputStream(@Body InputStream inputStream, @Var("filename") String filename);


    /**
     * ForestResponse 可以作为请求方法的返回类型
     * ForestResponse 为带泛型的类，其泛型参数中填的类作为其响应反序列化的目标类型
     */
    @Get("https://wwww.baidu.com")
    ForestResponse<String> getResponse();
}
