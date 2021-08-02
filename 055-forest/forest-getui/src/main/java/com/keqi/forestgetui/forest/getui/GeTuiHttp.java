package com.keqi.forestgetui.forest.getui;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.http.ForestResponse;
import com.keqi.forestgetui.forest.getui.domain.GeTuiResponse;
import com.keqi.forestgetui.forest.getui.domain.dto.AuthDto;
import com.keqi.forestgetui.forest.getui.domain.dto.PushListCidDto;
import com.keqi.forestgetui.forest.getui.domain.dto.PushListMessageDto;
import com.keqi.forestgetui.forest.getui.domain.dto.PushSingleDto;
import com.keqi.forestgetui.forest.getui.domain.param.AuthParam;
import com.keqi.forestgetui.forest.getui.domain.param.PushListCidParam;
import com.keqi.forestgetui.forest.getui.domain.param.PushListMessageParam;
import com.keqi.forestgetui.forest.getui.domain.param.PushSingleParam;

@BaseRequest(baseURL = "https://restapi.getui.com/v2/appId", interceptor = GeTuiHttpInterceptor.class)
public interface GeTuiHttp {

    @Post("/auth")
    ForestResponse<GeTuiResponse<AuthDto>> auth(@JSONBody AuthParam param);

    @Post("/push/single/cid")
    ForestResponse<GeTuiResponse<PushSingleDto>> pushSingle(@JSONBody PushSingleParam param);

    @Post("/push/list/message")
    ForestResponse<GeTuiResponse<PushListMessageDto>> pushListMessage(@JSONBody PushListMessageParam param);

    @Post("/push/list/cid")
    ForestResponse<GeTuiResponse<PushListCidDto>> pushListCid(@JSONBody PushListCidParam param);
}
