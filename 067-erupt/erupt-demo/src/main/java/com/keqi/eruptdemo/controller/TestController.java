package com.keqi.eruptdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.erupt.core.annotation.EruptRecordOperate;
import xyz.erupt.core.annotation.EruptRouter;
import xyz.erupt.core.constant.EruptRestPath;

@RestController
@RequestMapping(EruptRestPath.ERUPT_API + "/test") //必须为 EruptRestPath.ERUPT_API 权限校验才会生效
public class TestController {

    @RequestMapping("/abc")
    @EruptRecordOperate("登录可调用") //记录操作日志，可不定义
    @EruptRouter(verifyType = EruptRouter.VerifyType.LOGIN, authIndex = 0) //配置接口登录后可用
    public void test(String param) {
        //TODO
    }


    // 使用该接口必须配置菜单权限，类型为"接口名称" 或 "按钮"，类型值为def
    // authIndex 为重要参数，URL地址通过 '/' 拆分
    // 拆分后的路径索引位置等于 authIndex 则索引位置的值做为权限校验依据
    @EruptRouter(verifyType = EruptRouter.VerifyType.MENU, authIndex = 1)
    @EruptRecordOperate("拥有菜单权限可调用") //记录操作日志，可不定义
    @RequestMapping("/def")
    public void test2(String param) {
        //TODO
    }


    @RequestMapping("/xyz") //普通接口
    public void test3(String param) {
        //TODO
    }

    @RequestMapping("/recoder") //普通接口且记录请求日志
    @EruptRecordOperate("记录请求日志")
    public void recoder(String param) {
        //TODO
    }

}
