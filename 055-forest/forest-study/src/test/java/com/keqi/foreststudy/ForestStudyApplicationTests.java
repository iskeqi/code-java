package com.keqi.foreststudy;

import com.dtflys.forest.http.ForestResponse;
import com.keqi.foreststudy.forest.forestserverdemo.ForestServerDemoHttp;
import com.keqi.foreststudy.forest.forestserverdemo.ResultEntity;
import com.keqi.foreststudy.forest.forestserverdemo.Test1Dto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ForestStudyApplicationTests {

    @Autowired
    private ForestServerDemoHttp forestServerDemoHttp;

    @Test
    void contextLoads() {
        ForestResponse<ResultEntity<Test1Dto>> response = forestServerDemoHttp.test1("keqi", "123456");
        if (!response.isSuccess()) {
            // 请求调用失败，根据业务情况决定如何进行处理
            System.out.println("请求调用失败");
            return;
        }
        System.out.println(response.getResult().getData().toString());
    }

    @Test
    void contextLoads2() {
        Test1Dto dto = new Test1Dto();
        dto.setUsername("keqi");
        dto.setPassword("123456");
        ForestResponse<ResultEntity<Test1Dto>> response = forestServerDemoHttp.test2(dto);
        if (!response.isSuccess()) {
            // 请求调用失败，根据业务情况决定如何进行处理
            System.out.println("请求调用失败");
            return;
        }
        System.out.println(response.getResult().getData().toString());
    }
}
