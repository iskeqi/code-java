package com.keqi.forestgetui.forest.getui.domain.param;

import lombok.Data;

@Data
public class AuthParam {

    /**
     * 签名，加密算法: SHA256，格式: sha256(appkey+timestamp+mastersecret)
     */
    private String sign;

    /**
     * 毫秒时间戳，请使用当前毫秒时间戳，误差太大可能出错
     */
    private String timestamp;

    /**
     * 创建应用时生成的appkey
     */
    private String appkey;
}
