package com.keqi.forestgetui.forest.getui;

import cn.hutool.crypto.digest.DigestUtil;
import com.dtflys.forest.http.ForestResponse;
import com.keqi.forestgetui.forest.getui.domain.GeTuiResponse;
import com.keqi.forestgetui.forest.getui.domain.dto.AuthDto;
import com.keqi.forestgetui.forest.getui.domain.dto.PushSingleDto;
import com.keqi.forestgetui.forest.getui.domain.param.AuthParam;
import com.keqi.forestgetui.forest.getui.domain.param.PushSingleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GeTuiUtil {

    private static final String APP_ID = "2Dh5TCOEvB8nTHkOOhw046";
    private static final String APP_KEY = "9L6Q7pWhnvAdNT9YMssYX4";
    private static final String APP_SECRET = "Uu1I3xhIia5ego0TpMZNv9";
    private static final String MASTER_SECRET = "sJxVEDDtNR7p3Zars2tIf7";

    private static GeTuiHttp geTuiHttp;
    @Autowired
    public void setGeTuiHttp(GeTuiHttp geTuiHttp) {
        GeTuiUtil.geTuiHttp = geTuiHttp;
    }

    /**
     * 鉴权 API
     *
     * @return r
     */
    public static String auth() {
        long currentTimeMillis = System.currentTimeMillis();
        String sign = DigestUtil.sha256Hex(APP_KEY + currentTimeMillis + MASTER_SECRET);
        AuthParam param = new AuthParam();
        param.setAppkey(APP_KEY);
        param.setTimestamp(String.valueOf(currentTimeMillis));
        param.setSign(sign);
        ForestResponse<GeTuiResponse<AuthDto>> response = geTuiHttp.auth(param);
        if (response.isSuccess()) {
            GeTuiResponse<AuthDto> result = response.getResult();
            if (Objects.equals(result.getCode(), 0)) {
                return result.getData().getToken();
            }
        }
        return null;
    }

    /**
     * 向指定的 cid 推送透传消息
     *
     * @param cid          cid
     * @param transmission transmission
     * @param ttl          过期时间，传值 null 则默认为1小时，可按需确定过期时间，
     * @return r
     */
    public static boolean pushSingle(String cid, String transmission, Long ttl) {
        PushSingleParam param = new PushSingleParam();

        if (ttl != null) {
            PushSingleParam.Settings settings = new PushSingleParam.Settings();
            settings.setTtl(ttl);
            param.setSettings(settings);
        }

        PushSingleParam.Audience audience = new PushSingleParam.Audience();
        audience.setCid(new String[]{cid});
        param.setAudience(audience);

        PushSingleParam.PushMessage pushMessage = new PushSingleParam.PushMessage();
        pushMessage.setTransmission(transmission);
        param.setPush_message(pushMessage);

        ForestResponse<GeTuiResponse<PushSingleDto>> response = geTuiHttp.pushSingle(param);
        if (response.isSuccess()) {
            GeTuiResponse<PushSingleDto> result = response.getResult();
            return Objects.equals(result.getCode(), 0);
        }

        return false;
    }
}
