package com.keqi.easyexcel.write.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 导出日历视图 Excel 工具类
 *
 * @author keqi
 */
public class CalendarViewExcelUtil {

    /**
     * 部门/个人视图 Excel 头部数据
     *
     * @param name  name
     * @param year  year
     * @param month month
     * @return r
     */
    public static List<List<String>> headList(String name, int year, int month) {
        List<List<String>> list = new ArrayList<>();

        String mainTitle = name + " " + year + " 年 " + month + " 月排班表";

        List<String> head1 = new ArrayList<>();
        head1.add(mainTitle);
        head1.add("一");
        List<String> head2 = new ArrayList<>();
        head2.add(mainTitle);
        head2.add("二");
        List<String> head3 = new ArrayList<>();
        head3.add(mainTitle);
        head3.add("三");
        List<String> head4 = new ArrayList<>();
        head4.add(mainTitle);
        head4.add("四");
        List<String> head5 = new ArrayList<>();
        head5.add(mainTitle);
        head5.add("五");
        List<String> head6 = new ArrayList<>();
        head6.add(mainTitle);
        head6.add("六");
        List<String> head7 = new ArrayList<>();
        head7.add(mainTitle);
        head7.add("日");

        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        list.add(head5);
        list.add(head6);
        list.add(head7);
        return list;
    }

    /**
     * 动态组装部门/视图个人数据
     *
     * @param scheduleInfoMap 指定年月对应的日历排班信息：key 为当天日期数字，value 为已经添加了换行符的 string 字符串
     *                        内容示例如下：
     *                        String wrap = "\r\n";
     *                        StringBuilder scheduleInfo = new StringBuilder(day + wrap);
     *                        scheduleInfo.append("早").append(":").append("李明,刘丹,柯南").append(wrap);
     *                        scheduleInfo.append("中").append(":").append("王革,李刚").append(wrap);
     *                        scheduleInfo.append("晚").append(":").append("刘祥").append(wrap);
     * @param year            year
     * @param month           month
     * @return r
     */
    public static List<List<String>> dataList(Map<Integer, String> scheduleInfoMap, int year, int month) {
        // 多行记录
        List<List<String>> result = new ArrayList<>();
        // 行记录
        List<String> rowList = new ArrayList<>();

        // 本月第一天
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        // 本月最后一天
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());

        // 把前面的空格预留出来
        DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();
        for (int i = 1; i < dayOfWeek.getValue(); i++) {
            rowList.add(null);
        }

        // 遍历这个月的每一天
        while (!firstDayOfMonth.isAfter(lastDayOfMonth)) {
            dayOfWeek = firstDayOfMonth.getDayOfWeek();
            rowList.add(scheduleInfoMap.get(firstDayOfMonth.getDayOfMonth()));

            // 如果这一天是周日，就换行
            if (DayOfWeek.SUNDAY.equals(dayOfWeek)) {
                result.add(rowList);
                rowList = new ArrayList<>();
            }

            // 加一天
            firstDayOfMonth = firstDayOfMonth.plusDays(1);
        }
        if (!DayOfWeek.SUNDAY.equals(lastDayOfMonth.getDayOfWeek())) {
            result.add(rowList);
        }

        return result;
    }

    public static void main(String[] args) {

        //=======================根据具体业务情况组装数据==========================//

        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 31; i++) {
            String wrap = "\r\n";
            /*String scheduleInfo = i + wrap +
                    "早" + ":" + "李明,刘丹,柯南" + wrap +
                    "中" + ":" + "王革,李刚" + wrap +
                    "晚" + ":" + "刘祥" + wrap;*/

            String scheduleInfo = i + wrap + "早";

            map.put(i, scheduleInfo);
        }

        List<List<String>> headList = CalendarViewExcelUtil.headList("刘明辉", 2020, 12);
        List<List<String>> dataList = CalendarViewExcelUtil.dataList(map, 2020, 12);


        //=======================导出Excel文件==========================//

        String fileName = "E:\\easyexcel\\" + System.currentTimeMillis() + ".xlsx";

        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setWrapped(true);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        EasyExcel.write(fileName).head(headList)
                // 自动填充字段（经测试，部门视图设置为自动填充效果更好，个人视图不设置自动填充效果更好）
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // 设置标题和内容策略
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("部门视图").doWrite(dataList);
    }
}
