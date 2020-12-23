package com.keqi.knife4j.sys.controller;

import cn.hutool.core.io.IoUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.core.util.GlobalPropertyUtil;
import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.domain.vo.UploadFileVO;
import com.keqi.knife4j.sys.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

@Api(tags = "3. 文件管理")
@ApiSupport(order = 3)
@AllArgsConstructor
@Controller
public class UploadFileController {

    private final UploadFileService uploadFileService;
    private final GlobalPropertyUtil globalPropertyUtil;

    @ApiOperation("3.1 文件上传(只支持单个)")
    @ApiOperationSupport(order = 1)
    @ResponseBody
    @PostMapping("/sys/uploadFile/upload")
    public UploadFileVO upload(@RequestParam("file") MultipartFile file) throws IOException {
        // 基础路径
        String basePath = this.globalPropertyUtil.getUploadPath();
        // 相对路径
        String relativePath = LocalDate.now() + "/" + file.getContentType() + "/";
        // 全路径
        String fullPath = basePath + relativePath;
        // 对用户上传过来的文件使用UUID进行重命名，下载时截取掉UUID这段名称即可
        String name = UUID.randomUUID().toString() + file.getOriginalFilename();

        File f = new File(fullPath, name);
        if (!f.exists()) {
            f.mkdirs();
        }
        file.transferTo(f);

        UploadFileDO t = new UploadFileDO();
        t.setName(name);
        t.setSize(file.getSize());
        t.setPath(relativePath);
        t.setType(file.getContentType());
        this.uploadFileService.insert(t);

        return new UploadFileVO(t.getId(), t.getName(), t.getPath());
    }

    @ApiOperation("3.2 根据文件ID下载(只支持单个)")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "文件ID", example = "1", required = true)
    @GetMapping("/sys/uploadFile/downloadById")
    public void downloadById(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) throws Exception {
        UploadFileDO uploadFileDO = this.uploadFileService.getById(id);
        if (uploadFileDO == null) {
            throw new BusinessException("文件不存在");
        }
        String path = this.globalPropertyUtil.getUploadPath() + uploadFileDO.getPath() + uploadFileDO.getName();

        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");

        FileInputStream fileInputStream = new FileInputStream(new File(path));

        // 截取出 name 属性 [37,length-1) 位置的字符串，文件的真正命名
        String fileName = URLEncoder.encode(uploadFileDO.getName().substring(37), request.getCharacterEncoding());

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        IoUtil.copy(fileInputStream, response.getOutputStream());
        response.flushBuffer();

        fileInputStream.close();
    }

    @ApiOperation(value = "3.3 根据文件路径下载(只支持单个)", notes = "将文件上传接口返回的 path 和 name 拼接后可得到文件的相对路径，" +
            "在此相对路径前拼接 '/upload-file-path/' 可直接根据相对路径下载此文件（此接口无需鉴权）")
    @ApiOperationSupport(order = 3)
    @GetMapping("/upload-file-path/**")
    public void downloadByPath(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String requestURI = request.getRequestURI();

        String path = this.globalPropertyUtil.getUploadPath() +
                requestURI.substring(requestURI.indexOf("/upload-file-path/") + 17);
        String name = path.substring(path.lastIndexOf("/") + 1);

        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");

        FileInputStream fileInputStream = new FileInputStream(new File(path));

        // 截取出 name 属性 [37,length-1) 位置的字符串，文件的真正命名
        String fileName = URLEncoder.encode(name.substring(37), request.getCharacterEncoding());

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        IoUtil.copy(fileInputStream, response.getOutputStream());
        response.flushBuffer();

        fileInputStream.close();
    }

    @ApiOperation("3.4 文件删除(只支持单个)")
    @ApiOperationSupport(order = 4)
    @ApiImplicitParam(name = "id", value = "文件ID", example = "1", required = true)
    @PostMapping("/sys/uploadFile/deleteById")
    public void deleteById(@RequestParam Long id) {
        UploadFileDO uploadFileDO = this.uploadFileService.getById(id);
        if (uploadFileDO == null) {
            throw new BusinessException("文件不存在");
        }
        String path = this.globalPropertyUtil.getUploadPath() + uploadFileDO.getPath() + uploadFileDO.getName();

        File file = new File(path);
        if (!file.delete()) {
            throw new BusinessException("文件删除失败");
        }
        this.uploadFileService.deleteById(id);
    }


}
