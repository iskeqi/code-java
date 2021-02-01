package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PublicFileUploadVO {

	@ApiModelProperty(value = "文件路径", example = "/publicFile/2020-12-24/image/png/ff289c4e-8547-4abf-a90a-ead4139a3b0ca.png")
	private String path;
}
