package com.keqi.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量推送给多个用户（官方的代码直接拷贝过来就能用啊）
 */
public class PushList {
	private static String appId = "2Dh5TCOEvB8nTHkOOhw046";
	private static String appKey = "9L6Q7pWhnvAdNT9YMssYX4";
	private static String masterSecret = "sJxVEDDtNR7p3Zars2tIf7";
	static String CID1 = "e64a08fc64d9727defff30b8d7c3113d";
	static String CID2 = "4c19277058b37510b1bb6371e3cacee1";
	static String host = "http://api.getui.com/apiex.htm";

	public static void main(String[] args) throws Exception {
		// 配置返回每个用户返回用户状态，可选
		System.setProperty("gexin_pushList_needDetails", "true");
		// 配置返回每个别名及其对应cid的用户状态，可选
		// System.setProperty("gexin_pushList_needAliasDetails", "true");
		IGtPush push = new IGtPush(host, appKey, masterSecret);
		// 通知透传模板
		NotificationTemplate template = notificationTemplateDemo();
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

	public static NotificationTemplate notificationTemplateDemo() {
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(appId);
		template.setAppkey(appKey);

		Style0 style = new Style0();
		// 设置通知栏标题与内容
		style.setTitle("请输入通知栏标题");
		style.setText("请输入通知栏内容");

		// 设置通知是否响铃，震动，或者可清除
		style.setRing(true);
		style.setVibrate(true);
		style.setClearable(true);
		template.setStyle(style);

		return template;
	}
}

