package com.keqi.forestgetui.forest.getui;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.keqi.forestgetui.forest.getui.domain.GeTuiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GeTuiHttpInterceptor implements Interceptor<GeTuiResponse<?>> {

    private volatile String token;
    @Value("${getui.appId}")
    private String appId;

    @Override
    public boolean beforeExecute(ForestRequest request) {
        // 替换URL上的appId
        request.setUrl(request.getUrl().replaceFirst("appId", this.appId));
        // 给每个请求的 header 中加上 token 参数
        request.addHeader("token", token);
        return true;
    }

    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        if (Objects.equals(response.getStatusCode(), 401)) {
            // 进行登录，后再次进行执行请求
            // 登录 ...
            this.token = GeTuiUtil.auth();
            request.execute();
            return;
        }
        if (response.isSuccess()) {
            // HTTP 请求成功后，还要接着判断业务上是否成功了
            GeTuiResponse<?> resultEntity = (GeTuiResponse<?>) response.getResult();
            Integer code = resultEntity.getCode();
            if (!Objects.equals(code, 0)) {
                // 业务上 status 不等于 0，则表示失败了
                // 此处目的是为了让 isSuccess() 方法返回值为 false
                // 此处可以做更为细致的错误处理
                response.setException(new RuntimeException());
            }
        }
    }
}
