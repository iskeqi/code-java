package com.keqi.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;

import java.util.ArrayList;
import java.util.List;

/**
 * 个推工具类
 *
 * @author keqi
 */
public class GeTuiUtil {

	private static String appId = "2Dh5TCOEvB8nTHkOOhw046";
	private static String appKey = "9L6Q7pWhnvAdNT9YMssYX4";
	private static String masterSecret = "sJxVEDDtNR7p3Zars2tIf7";
	private static String host = "http://api.getui.com/apiex.htm";

	/**
	 * 推送给单个用户
	 *
	 * @param cid   cid
	 * @param title title
	 * @param text  text
	 */
	public static void pushToSingle(String cid, String title, String text) {
		IGtPush push = new IGtPush(host, appKey, masterSecret);
		NotificationTemplate template = getNotificationTemplate(title, text);

		SingleMessage message = new SingleMessage();
		message.setOffline(true);
		message.setOfflineExpireTime(24 * 3600 * 1000);
		message.setData(template);
		message.setPushNetWorkType(0);
		message.setStrategyJson("{\"default\":4,\"ios\":4,\"st\":4}");
		Target target = new Target();
		target.setAppId(appId);
		target.setClientId(cid); // 设置客户端ID
		IPushResult ret;
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

	/**
	 * 推送给多个用户
	 *
	 * @param cidList cidList
	 * @param title   title
	 * @param text    text
	 */
	public static void pushToList(List<String> cidList, String title, String text) {
		System.setProperty("gexin_pushList_needDetails", "true");
		IGtPush push = new IGtPush(host, appKey, masterSecret);
		NotificationTemplate template = getNotificationTemplate(title, text);
		ListMessage message = new ListMessage();
		message.setData(template);
		message.setOffline(true);
		message.setOfflineExpireTime(24 * 1000 * 3600);
		message.setStrategyJson("{\"default\":4,\"ios\":4,\"st\":4}");

		// 配置推送目标
		List targets = new ArrayList();
		for (String cid : cidList) {
			Target target = new Target();
			target.setAppId(appId);
			target.setClientId(cid);
			targets.add(target);
		}

		String taskId = push.getContentId(message);
		IPushResult ret = push.pushMessageToList(taskId, targets);
		System.out.println(ret.getResponse().toString());
	}

	private static NotificationTemplate getNotificationTemplate(String title, String text) {
		NotificationTemplate template = new NotificationTemplate();
		template.setAppId(appId);
		template.setAppkey(appKey);

		Style0 style = new Style0();
		// 设置通知栏标题与内容
		style.setTitle(title);
		style.setText(text);

		// 设置通知是否响铃，震动，或者可清除
		style.setRing(true);
		style.setVibrate(true);
		style.setClearable(true);
		template.setStyle(style);
		return template;
	}
}
