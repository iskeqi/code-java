package com.keqi.springbootmybatismapperxml.controller;

import com.keqi.springbootmybatismapperxml.mapper.SysNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private SysNoticeMapper sysNoticeMapper;

	@GetMapping("/test1")
	public Object test1(Integer noticeId) {
		return this.sysNoticeMapper.selectByPrimaryKeyObj(noticeId);
	}
}
