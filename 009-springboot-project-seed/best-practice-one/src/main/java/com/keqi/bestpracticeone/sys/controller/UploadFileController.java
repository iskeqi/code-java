package com.keqi.bestpracticeone.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.bestpracticeone.core.exception.BusinessException;
import com.keqi.bestpracticeone.core.util.GlobalPropertyUtil;
import com.keqi.bestpracticeone.sys.domain.db.UploadFileDO;
import com.keqi.bestpracticeone.sys.domain.vo.UploadFileVO;
import com.keqi.bestpracticeone.sys.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

@Api(tags = "3. 文件管理")
@ApiSupport(order = 3)
@AllArgsConstructor
@Controller
@RequestMapping("/sys/uploadFile")
public class UploadFileController {

    private final UploadFileService uploadFileService;
    private final GlobalPropertyUtil globalPropertyUtil;

    @ApiOperation("3.1 文件上传(只支持单个)")
    @ApiOperationSupport(order = 1)
    @ResponseBody
    @PostMapping("/upload")
    public UploadFileVO upload(@RequestParam("file") MultipartFile file) throws IOException {
        // 基础路径
        String basePath = this.globalPropertyUtil.getUploadPath();

        // 相对路径
        String relativePath = file.getContentType() + "/" + LocalDate.now() + "/" + UUID.randomUUID().toString() + "/";

        String fullPath = basePath + relativePath;
        Path path = Paths.get(fullPath);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        file.transferTo(path);

        UploadFileDO t = new UploadFileDO();
        t.setName(file.getOriginalFilename());
        t.setSize(file.getSize());
        t.setPath(relativePath);
        this.uploadFileService.insert(t);

        return new UploadFileVO(t.getId(), t.getName());
    }

    @ApiOperation("3.2 文件下传(只支持单个)")
    @ApiOperationSupport(order = 2)
    @GetMapping("/download")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        UploadFileDO uploadFileDO = this.uploadFileService.getById(id);
        if (uploadFileDO == null) {
            throw new BusinessException("文件不存在");
        }
        String path = this.globalPropertyUtil.getUploadPath() + uploadFileDO.getPath() + uploadFileDO.getName();


        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        InputStream in = Resources.getResourceAsStream(path);
        String fileName = URLEncoder.encode(uploadFileDO.getName(), request.getCharacterEncoding());
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        IOUtils.copy(in, response.getOutputStream());
        response.flushBuffer();
    }
}
