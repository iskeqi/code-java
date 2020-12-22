package com.keqi.easyexcel.write.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class CalendarViewTest {

    public static void main(String[] args) {
        CalendarViewTest t = new CalendarViewTest();
        List<List<String>> dataList = t.dataList(2020, 12);
        List<List<String>> headList = t.head();

        String fileName = "E:\\easyexcel\\" + System.currentTimeMillis() + ".xlsx";

        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        contentWriteCellStyle.setWrapped(true);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);


        EasyExcel.write(fileName).head(headList)
                // 自动填充字段
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                // 设置标题和内容策略
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("部门视图").doWrite(dataList);
    }

    /**
     * 动态组装头部
     *
     * @return r
     */
    private List<List<String>> head() {
        List<List<String>> list = new ArrayList<>();

        String mainTitle = "滕州市 2020 年 2 月排班表";
        
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
     * 动态组装数据
     *
     * @param year  year
     * @param month month
     * @return r
     */
    private List<List<String>> dataList(int year, int month) {
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
        StringBuilder scheduleInfo;
        while (!firstDayOfMonth.isAfter(lastDayOfMonth)) {
            dayOfWeek = firstDayOfMonth.getDayOfWeek();

            // 在这里补充对应日期的排班信息（班次名称：班次人员列表）
            String day = String.valueOf(firstDayOfMonth.getDayOfMonth());
            String wrap = "\r\n";

            // todo 这里需要居中显示
            scheduleInfo = new StringBuilder(day + wrap);
            scheduleInfo.append("早").append(":").append("李明,刘丹,柯南").append(wrap);
            scheduleInfo.append("中").append(":").append("王革,李刚").append(wrap);
            scheduleInfo.append("晚").append(":").append("刘祥").append(wrap);

            rowList.add(scheduleInfo.toString());


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

    public void monthlyCalendarView(int year, int month) {
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());

        // 打印标题
        System.out.print("一" + "\t");
        System.out.print("二" + "\t");
        System.out.print("三" + "\t");
        System.out.print("四" + "\t");
        System.out.print("五" + "\t");
        System.out.print("六" + "\t");
        System.out.print("七" + "\t");
        System.out.println();

        // 前面的空格先打印出来
        DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();
        int value = dayOfWeek.getValue();
        for (int i = 1; i < value; i++) {
            System.out.print("\t");
        }

        while (!firstDayOfMonth.isAfter(lastDayOfMonth)) {
            dayOfWeek = firstDayOfMonth.getDayOfWeek();
            System.out.print(firstDayOfMonth.getDayOfMonth() + "\t");

            // 如果这一天是周日，就换行
            if (DayOfWeek.SUNDAY.equals(dayOfWeek)) {
                System.out.println();
            }

            // 加一天
            firstDayOfMonth = firstDayOfMonth.plusDays(1);
        }
    }

    public void test(int year, int month) {
        // 指定年、月时的一号
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        int min = firstDayOfMonth.getDayOfMonth();

        // 获取当天是星期几
        DayOfWeek dayOfWeek = firstDayOfMonth.getDayOfWeek();

        // 星期几对应的数字是哪个
        int value = dayOfWeek.getValue();

        // 获取指定日期所在的月的最后一天
        LocalDate lastDayOfMonth = firstDayOfMonth.with(TemporalAdjusters.lastDayOfMonth());

        // 指定日期所在月的对应数字
        int max = lastDayOfMonth.getDayOfMonth();

        // 月视图的日历中，是 6行7列
    }
}
