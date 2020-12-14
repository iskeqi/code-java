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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sys/uploadFile")
public class UploadFileController {

    @GetMapping("/download")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 配置 FreeMarker 对象
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("UTF-8");
        String str3 = ResourceUtils.getURL("classpath:").getPath();
        configuration.setDirectoryForTemplateLoading(new File(str3 + "/ftl"));
        Template template = configuration.getTemplate("api-template.ftl");

        // 导出文件到本地磁盘
        Map<String, Object> map = this.assmeber();
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

    private Map<String, Object> assmeber() {
        // &emsp;

        Map<String, Object> map = new HashMap<>();
        map.put("name", "1.5 查询列表代码生成");
        map.put("url", "http://localhost:9102/idomp-bjzjc/sc/code-gen/list");
        map.put("requestMethod", "POST");
        map.put("requestContentType", "application/json");
        map.put("responseContentType", "application/json");

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
