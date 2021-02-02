package com.keqi.seed.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrivateFileUploadVO {

	@ApiModelProperty(value = "文件名称", example = "94a1679b62ea46ca82216d026f00b5b6-Java开发手册（嵩山版）.pdf")
	private String name;
}
