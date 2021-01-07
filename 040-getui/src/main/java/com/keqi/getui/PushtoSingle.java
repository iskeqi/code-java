package com.keqi.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.Constants;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

/**
 * 推送给单个用户（官方的代码直接拷贝过来就能用啊）
 */
public class PushtoSingle {
	// 详见【概述】-【服务端接入步骤】-【STEP1】说明，获得的应用配置
	private static String appId = "2Dh5TCOEvB8nTHkOOhw046";
	private static String appKey = "9L6Q7pWhnvAdNT9YMssYX4";
	private static String masterSecret = "sJxVEDDtNR7p3Zars2tIf7";

	static String CID = "e64a08fc64d9727defff30b8d7c3113d";
	// 别名推送方式
	// static String Alias = "";
	// 如果需要使用HTTPS，直接修改url即可
	//private static String url = "https://api.getui.com/apiex.htm";
	static String host = "http://api.getui.com/apiex.htm";

	public static void main(String[] args) throws Exception {
		// 设置后，根据别名推送，会返回每个cid的推送结果
		System.setProperty(Constants.GEXIN_PUSH_SINGLE_ALIAS_DETAIL, "true");
		IGtPush push = new IGtPush(host, appKey, masterSecret);
		NotificationTemplate template = getNotificationTemplate();
		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		// 离线有效时间，单位为毫秒
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setData(template);
		// 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
		message.setPushNetWorkType(0);
		// 厂商通道下发策略
		message.setStrategyJson("{\"default\":4,\"ios\":4,\"st\":4}");
		Target target = new Target();
		target.setAppId(appId);
		target.setClientId(CID);
		//target.setAlias(Alias);
		IPushResult ret = null;
		try {
			ret = push.pushMessageToSingle(message, target);
		} catch (RequestException e) {
			e.printStackTrace();
			ret = push.pushMessageToSingle(message, target, e.getRequestId());
		}
		if (ret != null) {
			System.out.println(ret.getResponse().toString());
		} else {
			System.out.println("服务器响应异常");
		}
	}

	public static NotificationTemplate getNotificationTemplate() {
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(appId);
		template.setAppkey(appKey);

		Style0 style = new Style0();
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
		template.setStyle(style);

		template.setTransmissionType(1);  // 透传消息接受方式设置，1：立即启动APP，2：客户端收到消息后需要自行处理
		template.setTransmissionContent("请输入您要透传的内容");

		//template.setAPNInfo(getAPNPayload()); //详见【推送模板说明】iOS通知样式设置
		return template;
	}
}
