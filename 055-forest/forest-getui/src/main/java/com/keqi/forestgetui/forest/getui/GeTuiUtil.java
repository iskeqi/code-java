package com.keqi.forestgetui.forest.getui;

import cn.hutool.crypto.digest.DigestUtil;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class GeTuiUtil {

    private static String appKey;
    private static String masterSecret;
    private static GeTuiHttp geTuiHttp;

    @Autowired
    public void setGeTuiHttp(GeTuiHttp geTuiHttp) {
        GeTuiUtil.geTuiHttp = geTuiHttp;
    }
    @Value("${getui.appKey}")
    public void setAppKey(String appKey) {
        GeTuiUtil.appKey = appKey;
    }
    @Value("${getui.masterSecret}")
    public void setMasterSecret(String masterSecret) {
        GeTuiUtil.masterSecret = masterSecret;
    }

    /**
     * 鉴权 API
     *
     * @return r
     */
    static String auth() {
        long currentTimeMillis = System.currentTimeMillis();
        String sign = DigestUtil.sha256Hex(appKey + currentTimeMillis + masterSecret);
        AuthParam param = new AuthParam();
        param.setAppkey(appKey);
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
     * @param ttl          过期时间，传值 null 则默认为1小时，可按需确定过期时间
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

    /**
     * 向多个 cid 推送相同的消息
     *
     * @param cids         cids
     * @param transmission transmission
     * @param ttl          过期时间，传值 null 则默认为1小时，可按需确定过期时间，
     * @param isAsync      是否异步发送，传值 null 表示同步发送，true 表示异步发送（HTTP请求发送后，立即返回，不会等待消息全部推送完成）
     * @return
     */
    public static boolean pushList(String[] cids, String transmission, Long ttl, Boolean isAsync) {
        PushListMessageParam msgParam = new PushListMessageParam();
        if (ttl != null) {
            PushListMessageParam.Settings settings = new PushListMessageParam.Settings();
            settings.setTtl(ttl);
            msgParam.setSettings(settings);
        }
        PushListMessageParam.PushMessage pushMessage = new PushListMessageParam.PushMessage();
        pushMessage.setTransmission(transmission);
        msgParam.setPush_message(pushMessage);
        ForestResponse<GeTuiResponse<PushListMessageDto>> msgResponse = geTuiHttp.pushListMessage(msgParam);
        if (msgResponse.isSuccess()) {
            GeTuiResponse<PushListMessageDto> result = msgResponse.getResult();
            String taskid = result.getData().getTaskid();

            PushListCidParam param = new PushListCidParam();
            PushListCidParam.Audience audience = new PushListCidParam.Audience();
            audience.setCid(cids);
            param.setAudience(audience);
            param.setTaskid(taskid);
            if (isAsync != null) {
                param.setIs_async(isAsync);
            }
            ForestResponse<GeTuiResponse<PushListCidDto>> pushListCidResponse = geTuiHttp.pushListCid(param);
            return pushListCidResponse.isSuccess();
        }

        return false;
    }
}
