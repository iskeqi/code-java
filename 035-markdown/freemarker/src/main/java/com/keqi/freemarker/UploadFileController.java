package com.keqi.freemarker;


import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/sys/uploadFile")
public class UploadFileController {

    /*
        后台查询到系统中的所有模块、分组、API信息后，组装成一个Map对象。然后使用 FreeMarker 模板技术生成 md 文件，保存至本地
        磁盘，最后再通过 response 对象的输出流下载文件到浏览器中。
     */

    @GetMapping("/download")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 配置 FreeMarker 对象
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("UTF-8");
        String str3 = ResourceUtils.getURL("classpath:").getPath();
        configuration.setDirectoryForTemplateLoading(new File(str3 + "/ftl"));
        Template template = configuration.getTemplate("api-template.ftl");

        // 构造对象
        List<Map<String, Object>> moduleList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> module = new HashMap<>();
            List<Map<String, Object>> groupList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                // 构建分组列表
                Map<String, Object> group = new HashMap<>();
                List<Map<String, Object>> apiList = new ArrayList<>();
                for (int k = 0; k < 10; k++) {
                    // 构建API列表
                    apiList.add(this.assembler());
                }
                group.put("apiList", apiList);
                group.put("groupName", "分组名称" + j);
                groupList.add(group);
            }
            module.put("groupList", groupList);
            module.put("moduleName", "模块名称" + i);
            moduleList.add(module);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("moduleList", moduleList);

        // 导出文件到本地磁盘
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("E:\\knife4j-upload-file\\2020-12-10\\application\\pdf\\api.md"));
        template.process(map, outputStreamWriter);
        outputStreamWriter.close();

        // 读取本地文件并通过 response 输出到浏览器端
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");

        File file = new File("E:\\knife4j-upload-file\\2020-12-10\\application\\pdf\\api.md");

        FileInputStream fileInputStream = new FileInputStream(file);

        String fileName = URLEncoder.encode("file.md", request.getCharacterEncoding());
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        IOUtils.copy(fileInputStream, response.getOutputStream());
        fileInputStream.close();
        response.flushBuffer();

        boolean delete = file.delete();
        System.out.println(delete);
    }

    private Map<String, Object> assembler() {
        // &emsp;

        Map<String, Object> map = new HashMap<>();
        map.put("name", "1.5 查询列表代码生成");
        map.put("url", "http://localhost:9102/idomp-bjzjc/sc/code-gen/list");
        map.put("requestMethod", "POST");
        map.put("requestContentType", "application/json");
        map.put("responseContentType", "application/json");
        map.put("note", new Random().nextInt(10) / 2 == 0 ? "接口描述性信息" : null);

        String requestDemo = JsonUtil.writeValueAsString(map);
        String responseDemo = JsonUtil.writeValueAsString(map);
        map.put("requestDemo", requestDemo);
        map.put("responseDemo", responseDemo);

        List<Map<String, Object>> requestParamList = new ArrayList<>();
        List<Map<String, Object>> responseParamList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> param = new HashMap<>();
            String s = "";
            if (i == 3) {
                s = "&emsp;";
            }
            param.put("name", s + "username");
            param.put("note", "用户名");
            param.put("required", "是");
            param.put("type", "string");
            requestParamList.add(param);
            responseParamList.add(param);
        }


        map.put("requestParamList", requestParamList);
        map.put("responseParamList", responseParamList);

        return map;
    }


}
