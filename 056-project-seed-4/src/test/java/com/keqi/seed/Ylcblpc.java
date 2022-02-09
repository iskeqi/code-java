package com.keqi.seed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * 乳化计划备料批次表(GdbsYlcblpc)表实体类
 *
 * @author keqi
 * @since 2022-01-12 16:39:41
 */
@Data
public class Ylcblpc {

    private Integer id;

    //乳化计划ID
    private Integer prodPlanId;
    //备料次数[1 一次性备料，2 多次备料]
    private Integer blNum;
    //是否呼叫AGV带载具[1 否，2 带料车，3 带栈板]
    private String callTypeAgv;
    // 1 完成本批次备料，2 完成全部备料
    private String type;
    // 送至指定库位ID
    private Integer destLocationId;
    //1 原料暂存区，2 乳化产线
    private Integer callType;
    //原料仓备料库位ID
    private Integer locationId;
    //原料仓备料库位ID名称
    private String locationIdName;
    //批次编号
    private String pcNum;
    //备注
    private String note;
    //状态[1 未备料，2 备料中，3 已备料，4 已送至乳化产线]
    private String status;

    // 实体类中的状态类直接新增一个内部枚举类
    @Getter
    @AllArgsConstructor
    public enum Status {

        WBL("1", "未备料"),
        BLZ("2", "备料中"),
        YBL("3", "已备料"),
        YSZCX("4", "已送至产线");

        private String code;
        private String codeName;

        // 与需要才
//        public static Status parse(String code) {
//            Status[] values = Status.values();
//            for (Status value : values) {
//                if (value.getCode().equals(code)) {
//                    return value;
//                }
//            }
//            return null;
//        }
    }

//    public static class CallTypeAgv extends BaseEnum<CallTypeAgv> {
//
//        private static final Map<String, CallTypeAgv> INSTANCES = new HashMap<>();
//
//        public CallTypeAgv(String code, String codeName) {
//            super(code, codeName);
//        }
//
//        static {
//            INSTANCES.put(CallTypeAgv.NO.getCode(), CallTypeAgv.NO);
//            INSTANCES.put(CallTypeAgv.DLC.getCode(), CallTypeAgv.DLC);
//            INSTANCES.put(CallTypeAgv.DZB.getCode(), CallTypeAgv.DZB);
//        }
//
//        public static final CallTypeAgv NO = new CallTypeAgv("1", "否");
//        public static final CallTypeAgv DLC = new CallTypeAgv("2", "待料车");
//        public static final CallTypeAgv DZB = new CallTypeAgv("3", "带栈板");
//    }
}
