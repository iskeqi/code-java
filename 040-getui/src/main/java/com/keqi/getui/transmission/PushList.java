package com.keqi.getui.transmission;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;

import java.util.ArrayList;
import java.util.List;

public class PushList {
    // 详见【概述】-【服务端接入步骤】-【STEP1】说明，获得的应用配置
    private static String appId = "2Dh5TCOEvB8nTHkOOhw046";
    private static String appKey = "9L6Q7pWhnvAdNT9YMssYX4";
    private static String masterSecret = "sJxVEDDtNR7p3Zars2tIf7";

    static String CID1 = "2930119df12a5c611aa76455d1e91580";
    static String CID2 = "2930119df12a5c611aa76d55d1e91580";
    // 别名推送方式
    // static String Alias1 = "";
    // static String Alias2 = "";
    // 如果需要使用HTTPS，直接修改url即可
    // static String host = "https://api.getui.com/apiex.htm";
    static String host = "http://api.getui.com/apiex.htm";
    public static void main(String[] args) throws Exception {
        // 配置返回每个用户返回用户状态，可选
        System.setProperty("gexin_pushList_needDetails", "true");
        // 配置返回每个别名及其对应cid的用户状态，可选
        // System.setProperty("gexin_pushList_needAliasDetails", "true");
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        // 通知透传模板
        TransmissionTemplate template = notificationTemplateDemo();
        ListMessage message = new ListMessage();
        message.setData(template);
        // 设置消息离线，并设置离线时间
        message.setOffline(true);
        // 离线有效时间，单位为毫秒
        message.setOfflineExpireTime(24 * 1000 * 3600);
        // 厂商通道下发策略
        message.setStrategyJson("{\"default\":4,\"ios\":4,\"st\":4}");

        // 配置推送目标
        List targets = new ArrayList();
        Target target1 = new Target();
        Target target2 = new Target();
        target1.setAppId(appId);
        target1.setClientId(CID1);
        // target1.setAlias(Alias1);
        target2.setAppId(appId);
        target2.setClientId(CID2);
        // target2.setAlias(Alias2);
        targets.add(target1);
        targets.add(target2);
        // taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);
        System.out.println(ret.getResponse().toString());
    }
    public static TransmissionTemplate notificationTemplateDemo() {
        TransmissionTemplate template = new TransmissionTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        /*Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("请输入通知栏标题");
        style.setText("请输入通知栏内容");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        style.setChannel("通知渠道id");
        style.setChannelName("通知渠道名称");
        style.setChannelLevel(3); //设置通知渠道重要性
        template.setStyle(style);*/

        // 透传消息接受方式设置，1：立即启动APP，2：客户端收到消息后需要自行处理
        template.setTransmissionType(2);
        String json = "{\n" +
                "    \"user\": \"用户ID\",\n" +
                "    \"action\": \"task或者event或者warning\",\n" +
                "    \"data\": {\n" +
                "        \"id\": \"任务ID或者事件ID或者报警ID\"\n" +
                "    }\n" +
                "}";
        template.setTransmissionContent(json);

        //template.setAPNInfo(getAPNPayload()); //详见【推送模板说明】iOS通知样式设置
        return template;
    }
}

