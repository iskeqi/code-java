package com.keqi.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ApplicationTests {

	// 使用 jsoup 解析中央气象台网站 天气实况 栏目中的各个 HTML 页面，并提取出当前页面中的图片
	// 总结，除了 HTML 页面对应的地址不一样，其它都是相同的，代码写的越规范，越是难以防止爬虫

	@Test
	void contextLoads() {
	}

	@Test
	void weatherMap() throws IOException {
		// 天气图的更新规则为每日 02:00 开始，每隔 3 小时更新一次，当天最后一次更新时间为 23:00
		// [02:00, 05:00, 08:00, 11:00, 14:00, 17:00, 20:00, 23:00]
		Document document = Jsoup.connect("http://www.nmc.cn/publish/observations/china/dm/weatherchart-h000.htm").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/WESA/SEVP_NMC_WESA_SFER_EGH_ACWP_L00_P9_20210408030000000.jpg?v=1617855044870 : 04/08 11:00
		// http://image.nmc.cn/product/2021/04/08/WESA/SEVP_NMC_WESA_SFER_EGH_ACWP_L00_P9_20210408000000000.jpg?v=1617848314953 : 04/08 08:00
	}

	@Test
	void satelliteImages() throws IOException {
		// 卫星云图的更新规则为连续两次4分钟更新，接着一次7分钟更新，以此循环，偶尔不一定按照这个规律
		// [13:15, 13:19, 13:23, 13:30, 13:34, 13:38, 13:45]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/satellite/FY4A-true-color.htm").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/WXBL/medium/SEVP_NSMC_WXBL_FY4A_ETCC_ACHN_LNO_PY_20210408063400000.JPG?v=1617864750334 : 04/08 14:34
		// http://image.nmc.cn/product/2021/04/08/WXBL/medium/SEVP_NSMC_WXBL_FY4A_ETCC_ACHN_LNO_PY_20210408061500000.JPG?v=1617863857418 : 04/08 14:15
	}

	@Test
	void radarChart() throws IOException {
		// 雷达图的更新规则为每6分钟更新一次
		// [13:54, 14:00, 14:06, 14:12, 14:18, 14:24, 14:30]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/radar/chinaall.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/RDCP/medium/SEVP_AOC_RDCP_SLDAS_EBREF_ACHN_L88_PI_20210408065400001.PNG?v=1617865525903 : 04/08 14:54
		// http://image.nmc.cn/product/2021/04/08/RDCP/medium/SEVP_AOC_RDCP_SLDAS_EBREF_ACHN_L88_PI_20210408064800001.PNG?v=1617865167331 : 04/08 14:48
	}

	@Test
	void precipitation() throws IOException {
		// 降水量每天 00:00 开始，每隔 1 小时更新一次
		// [00:00, 01:00, 02:00, 03:00, 04:00, 05:00, 06:00, 07:00]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/observations/hourly-precipitation.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/STFC/medium/SEVP_NMC_STFC_SFER_ER1_ACHN_L88_PB_20210408060000000.jpg?v=1617862513317 : 04/08 14:00
		// http://image.nmc.cn/product/2021/04/08/STFC/medium/SEVP_NMC_STFC_SFER_ER1_ACHN_L88_PB_20210408050000000.jpg?v=1617861280813 : 04/08 13:00
	}

	@Test
	void airTemperature() throws IOException {
		// 气温每天 00:00 开始，每隔 1 小时更新一次
		// [00:00, 01:00, 02:00, 03:00, 04:00, 05:00, 06:00, 07:00]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/observations/hourly-temperature.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/STFC/medium/SEVP_NMC_STFC_SFER_ET0_ACHN_L88_PB_20210408060000000.jpg?v=1617862493111 : 04/08 14:00
		// http://image.nmc.cn/product/2021/04/08/STFC/medium/SEVP_NMC_STFC_SFER_ET0_ACHN_L88_PB_20210408050000000.jpg?v=1617861325822 : 04/08 13:00
	}

	@Test
	void wind() throws IOException {
		// 风每天 00:00 开始，每隔 1 小时更新一次
		// [00:00, 01:00, 02:00, 03:00, 04:00, 05:00, 06:00, 07:00]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/observations/hourly-winds.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/STFC/medium/SEVP_NMC_STFC_SFER_EDA_ACHN_L88_PB_20210408060000000.jpg?v=1617865780392 : 04/08 14:00
		// http://image.nmc.cn/product/2021/04/08/STFC/medium/SEVP_NMC_STFC_SFER_EDA_ACHN_L88_PB_20210408050000000.jpg?v=1617861228481 : 04/08 13:00
	}

	@Test
	void visibility() throws IOException {
		// 能见度每天 00:00 开始，每隔 1 小时更新一次
		// [00:00, 01:00, 02:00, 03:00, 04:00, 05:00, 06:00, 07:00]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/sea/seaplatform1.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/APWF/medium/SEVP_NMC_APWF_SOB_EQ2_ACHN_L89_P9_20210408140000000.jpg?v=1617863998161 : 04/08 14:00
		// http://image.nmc.cn/product/2021/04/08/APWF/medium/SEVP_NMC_APWF_SOB_EQ2_ACHN_L89_P9_20210408130000000.jpg?v=1617860409326 : 04/08 13:00
	}

	@Test
	void strongConvection() throws IOException {
		// 强对流每天 00:00 开始，每隔 1 小时更新一次
		// [00:00, 01:00, 02:00, 03:00, 04:00, 05:00, 06:00, 07:00]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/observations/lighting.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/WEAP/medium/SEVP_NMC_WEAP_SOB_ELTN_ACHN_LNO_PE_20210408140000000.jpg?v=1617865669761 : 04/08 14:00
		// http://image.nmc.cn/product/2021/04/08/WEAP/medium/SEVP_NMC_WEAP_SOB_ELTN_ACHN_LNO_PE_20210408130000000.jpg?v=1617860982379 : 04/08 13:00
	}

	@Test
	void soilMoisture() throws IOException {
		// 土壤水分每天 08:00 测试一次
		// [08:00]

		Document document = Jsoup.connect("http://www.nmc.cn/publish/soil-moisture/10cm.html").get();

		Elements rowTimeWrap = document.getElementsByClass("row timeWrap");
		Element first = rowTimeWrap.first();
		Elements childrens = first.children();
		for (Element element : childrens) {
			Attributes attributes = element.attributes();
			String dataImg = attributes.get("data-img");
			String dataTime = attributes.get("data-time");
			System.out.println(dataImg + " : " + dataTime);
		}
		// 输出内容格式如下：
		// http://image.nmc.cn/product/2021/04/08/AMSM/medium/SEVP_NMC_AMSM_CAGMSS_ESRH_ACHN_L10CM_PS_20210408000000000.jpg?v=1617862237150 : 04/08 08:00
		// http://image.nmc.cn/product/2021/04/07/AMSM/medium/SEVP_NMC_AMSM_CAGMSS_ESRH_ACHN_L10CM_PS_20210407000000000.jpg?v=1617775849128 : 04/07 08:00
	}
}
