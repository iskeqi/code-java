package com.keqi.knife4j.sys.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL) // 此实体类中的属性为 null 时，不会被序列化
@Data
public class UploadFileVO {

	@ApiModelProperty(value = "文件ID", example = "1")
	private Long id;

	@ApiModelProperty(value = "文件名称", example = "85b4f070-d238-4e34-bd40-d72885a42f6fSnipaste_2020-12-23_11-23-11.png")
	private String name;

	@ApiModelProperty(value = "文件存储路径（相对路径）", example = "/2020-12-23/image/png/")
	private String path;

	public UploadFileVO() {
	}

	public UploadFileVO(Long id) {
		this.id = id;
	}

	public UploadFileVO(String path) {
		this.path = path;
	}
}