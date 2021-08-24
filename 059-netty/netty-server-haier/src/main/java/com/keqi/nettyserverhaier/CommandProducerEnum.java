package com.keqi.nettyserverhaier;

import java.util.Objects;

/**
 * CommandProducerEnum 中控系统向上位机发送的指令
 *
 * @author keqi
 */
public enum CommandProducerEnum {

    // 中控 -> 上位机

    /**
     * 空托盘暂存区是否需要空盘
     */
    EmptyBufferState("EmptyBufferState", 1),

    /**
     * 空托盘暂存区动作
     */
    EmptyBufferMove("EmptyBufferMove", 2),

    /**
     * 满托盘叠放区是否有货可取
     */
    FullBufferState("FullBufferState", 3),

    /**
     * 满托盘叠放区动作
     */
    FullBufferMove("FullBufferMove", 4),

    /**
     * 查询自动门是否能开门
     */
    GetAutoDoorState("GetAutoDoorState", 5),

    /**
     * 打开自动门
     */
    OpenAutoDoor("OpenAutoDoor", 6),

    /**
     * 查询自动门是否开门到位
     */
    GetAutoDoorOpenState("GetAutoDoorOpenState", 7),

    /**
     * 库口移栽机动作
     */
    AutoDoorLineMove("AutoDoorLineMove", 8),

    /**
     * 空盘存放位置的滚杠线转动
     */
    StationLineMove("StationLineMove", 9);

    // 上位机 -> 中控

    /**
     * 响应命令成功
     */
    public static final String RESPONSE_SUCCESS = "1";

    /**
     * 响应命令失败
     */
    public static final String RESPONSE_FAILURE = "2";

    public static CommandProducerEnum parseByCode(String code) {
        for (CommandProducerEnum value : CommandProducerEnum.values()) {
            if (Objects.equals(code, value.getCode())) {
                return value;
            }
        }
        return null;
    }

    public static CommandProducerEnum parseByCommand(String command) {
        for (CommandProducerEnum value : CommandProducerEnum.values()) {
            if (Objects.equals(command, String.valueOf(value.getCommand()))) {
                return value;
            }
        }
        return null;
    }

    private final String code;
    private final Integer command;

    CommandProducerEnum(String code, Integer command) {
        this.code = code;
        this.command = command;
    }

    public String getCode() {
        return code;
    }

    public Integer getCommand() {
        return command;
    }
}
