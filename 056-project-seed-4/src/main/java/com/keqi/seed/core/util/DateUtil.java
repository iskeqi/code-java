package com.keqi.seed.core.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * 日期图表工具类
 *
 * @author keqi
 */
public class DateUtil {
	
	/**
	 * 当前月份为 1 月份时，返回上年 1-12 月。当前月份不为 1 月份时，返回当年 1-当前月份的上月
	 *
	 * @param today today
	 * @return [去年1月, 去年12月] 或者 [今年1月,当前月份的上月]
	 */
	public List<String> rangeMonth(LocalDate today) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
		List<String> r;
		if (Month.JANUARY.equals(today.getMonth())) {
			r = new ArrayList<>(12);
			for (int i = 12; i > 0; i--) {
				r.add(today.minusMonths(i).format(formatter));
			}
		} else {
			int size = today.getMonthValue() - 1;
			r = new ArrayList<>();
			for (int i = size; i > 0; i--) {
				r.add(today.minusMonths(i).format(formatter));
			}
		}
		return r;
	}
	
	/**
	 * 获取指定日期之间的日期列表
	 *
	 * @param begin 开始日期
	 * @param end   结束日期
	 * @return [开始日期, 结束日期]
	 */
	public List<LocalDate> rangeDay(LocalDate begin, LocalDate end) {
		long until = begin.until(end, ChronoUnit.DAYS);
		List<LocalDate> r = new ArrayList<>((int) until);
		while (!begin.isAfter(end)) {
			r.add(begin);
			begin = begin.plusDays(1);
		}
		return r;
	}

	/**
	 * 将[begin,end]中存在的日期但 dateMap 中不存在的日期进行补全
	 *
	 * @param begin    开始日期
	 * @param end      结束日期
	 * @param dateMap  日期Map
	 * @param function dateList 中存在且dateMap 中不存在时，调用此方法进行对象补全
	 * @param <T>      泛型对象
	 * @return 补全后的对象列表
	 */
	public static <T> List<T> rangeDayFill(LocalDate begin, LocalDate end, Map<LocalDate, List<T>> dateMap, Function<LocalDate, T> function) {
		long until = begin.until(end, ChronoUnit.DAYS) + 1;
		List<T> r = new ArrayList<>((int) until);
		for (int i = 1; i <= until; i++) {
			List<T> ts = dateMap.get(begin);
			if (ts != null && ts.size() > 0) {
				r.add(ts.get(0));
			} else {
				r.add(function.apply(begin));
			}
			begin = begin.plusDays(1);
		}
		return r;
	}
}
