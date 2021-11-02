package com.keqi.eruptdemo.tpl;

import xyz.erupt.annotation.sub_erupt.Tpl;
import xyz.erupt.tpl.annotation.EruptTpl;
import xyz.erupt.tpl.annotation.TplAction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@EruptTpl(engine = Tpl.Engine.FreeMarker) //注解值表示要使用的模板引擎
public class FreemarkerAction {

    // 返回值表示要绑定的数据。必须返回 Map<String, Object>
    @TplAction("dashboard.ftl") //注解值表示要绑定的页面
    public Map<String, Object> dashboard() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mp = new LinkedHashMap<>();
        mp.put("annotation", 'E');
        mp.put("core", 'R');
        mp.put("auth", 'U');
        mp.put("web", 'P');
        mp.put("mongodb", 'T');
        mp.put("bi", '-');
        mp.put("job", '-');
        mp.put("tpl", '-');
        mp.put("generator", '-');
        map.put("color", new String[]{
                "#eb776e", "#56aad6", "#69d5e7", "#f686e5", "#29ae94", "#fbd364",
                "#4da1ff", "#ff6e4b", "#ffc524", "#e07de9", "#42e9e1", "#a9f", "#a90",
                "#09f", "#928bff"
        });
        map.put("map", mp);
        return map;
    }

}
