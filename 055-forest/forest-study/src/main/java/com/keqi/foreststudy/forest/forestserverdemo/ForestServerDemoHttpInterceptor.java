package com.keqi.foreststudy.forest.forestserverdemo;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ForestServerDemoHttpInterceptor implements Interceptor<ResultEntity<?>> {

    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        if (response.isSuccess()) {
            // HTTP 请求成功后，还要接着判断业务上是否成功了
            ResultEntity<?> resultEntity = (ResultEntity<?>) response.getResult();
            Integer status = resultEntity.getStatus();

            if (!Objects.equals(status, 200)) {
                // 业务上 status 不等于 200，则表示失败了
                if (Objects.equals(status, 401)) {
                    // 进行登录，后再次进行执行请求
                    // 登录 ...
                    request.execute();
                    return;
                }
                // 此处目的是为了让 isSuccess() 方法返回值为 false
                response.setException(new RuntimeException());
            }
        }
    }
}
