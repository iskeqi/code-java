package com.keqi.knife4j.sys.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrivateFileUploadVO {

	@ApiModelProperty(value = "文件id", example = "1")
	private Long id;
}
