package com.keqi.forestgetui.forest.getui;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.http.ForestResponse;
import com.keqi.forestgetui.forest.getui.domain.GeTuiResponse;
import com.keqi.forestgetui.forest.getui.domain.dto.AuthDto;
import com.keqi.forestgetui.forest.getui.domain.dto.PushSingleDto;
import com.keqi.forestgetui.forest.getui.domain.param.AuthParam;
import com.keqi.forestgetui.forest.getui.domain.param.PushSingleParam;

@BaseRequest(baseURL = "https://restapi.getui.com/v2/2Dh5TCOEvB8nTHkOOhw046", interceptor = GeTuiHttpInterceptor.class)
public interface GeTuiHttp {

    @Post("/auth")
    ForestResponse<GeTuiResponse<AuthDto>> auth(@JSONBody AuthParam param);

    @Post("/push/single/cid")
    ForestResponse<GeTuiResponse<PushSingleDto>> pushSingle(@JSONBody PushSingleParam param);
}
