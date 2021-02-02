package com.keqi.getui.notification;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String kq = "508d3a3516e4d917c3c66a1978021cf9";
		String cxf = "87a6b36ff6074e0740f44cc7444b44cc";

		List<String> cidList = new ArrayList<String>();
		cidList.add(kq);
		cidList.add(cxf);

		// 单推
		GeTuiUtil.pushToSingle(kq, "这不仅仅是标题", "这不仅仅是内容");

		// 群推
		// GeTuiUtil.pushToList(cidList, "这不仅仅是标题", "这不仅仅是内容");
	}
}
