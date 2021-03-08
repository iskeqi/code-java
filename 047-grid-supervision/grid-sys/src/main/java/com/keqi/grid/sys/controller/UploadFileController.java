package com.keqi.grid.sys.controller;

import com.keqi.grid.sys.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    @ResponseBody
    @PostMapping("/sys/uploadFile")
    public Map<String, String> upload(MultipartFile file) {
        Map<String, String> r = new HashMap<>();
        r.put("fileName", this.uploadFileService.upload(file));
        return r;
    }

    @GetMapping("/sys/uploadFile")
    public void downloadByName(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileName) throws Exception {
        this.uploadFileService.downloadByName(request, response, fileName);
    }

    @ResponseBody
    @DeleteMapping("/sys/uploadFile/{fileName}")
    public void deleteByName(@PathVariable String fileName) {
        this.uploadFileService.deleteByFileName(fileName);
    }
}