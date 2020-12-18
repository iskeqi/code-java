package com.keqi.apihu.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.core.util.GlobalPropertyUtil;
import com.keqi.apihu.sys.domain.db.UploadFileDO;
import com.keqi.apihu.sys.domain.vo.UploadFileVO;
import com.keqi.apihu.sys.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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

        return new UploadFileVO(t.getId(), t.getName());
    }

    @ApiOperation("3.2 文件下载(只支持单个)")
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "id", value = "文件ID", example = "1", required = true)
    @GetMapping("/download")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) throws Exception {
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
        IOUtils.copy(fileInputStream, response.getOutputStream());
        response.flushBuffer();

        fileInputStream.close();
    }

    @ApiOperation("3.3 文件删除(只支持单个)")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParam(name = "id", value = "文件ID", example = "1", required = true)
    @PostMapping("/deleteById")
    public void downloadFileAction(@RequestParam Long id) {
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
