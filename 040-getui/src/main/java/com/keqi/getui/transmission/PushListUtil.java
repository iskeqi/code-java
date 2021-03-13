package com.keqi.getui.transmission;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 透传消息推送工具类
 *
 * @author keqi
 */
public class PushListUtil {

    private static final String appId = "2Dh5TCOeqEvB8nTHkOOhw046";
    private static final String appKey = "9L6Q7peqeWhnvAdNT9YMssYX4";
    private static final String masterSecret = "sJxVEDDt43NR7p3Zars2tIf7";
    private static final String host = "http://api.getui.com/apiex.htm";

    /**
     * 批量推送透传消息
     *
     * @param cids    cids
     * @param transmissionMessage transmissionMessage
     */
    public static Map<String, Object> pushTransmissionMessageToList(List<String> cids, String transmissionMessage) {
        System.setProperty("gexin_pushList_needDetails", "true");
        IGtPush push = new IGtPush(host, appKey, masterSecret);

        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionType(2);
        template.setTransmissionContent(transmissionMessage);

        ListMessage message = new ListMessage();
        message.setData(template);
        message.setOffline(true);
        message.setOfflineExpireTime(3600000);

        List targets = new ArrayList();
        for (String cid : cids) {
            Target target = new Target();
            target.setAppId(appId);
            target.setClientId(cid);
            targets.add(target);
        }

        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);

        return ret.getResponse();
    }
}
