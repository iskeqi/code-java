package com.keqi.springbootknife4j.sys.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeGenSaveParam {

	@ApiModelProperty(value = "用户名",  required = true, example = "grace")
	private String username;

	@ApiModelProperty(value = "年龄",  required = true, example = "22")
	private Integer age;

	@ApiModelProperty(value = "体重",  required = false, example = "63.45")
	private Float weight;

	/*
		@ApiModelProperty
			作用：用在请求参数或者相应参数实体类的属性中
			属性：
				value：指定属性的名称，直接会显示在 UI 界面上
				required：默认值是 flase，如果该参数是必须传递的，那么一定要设置此值为 true。同样会显示在 UI 界面上
				dataType：此注解中的解释是用来指定数据类型的，但是实际上在 knife4j 中指定了此属性反而不起作用，不指定反而能自动识别出来
				example：用于给定一个示例值，直接和 value 属性一同在 UI 界面上显示
				hidden：尽管编码规范要求 Param 类和 VO 类不允许出现额外的属性，但有时真的有点不可避免。
						那么就可以使用将 hidden 属性设置为 true，则不会再 UI 界面上显示出来

				至于如何保证字段在界面上的顺序，这个 knife4j 的作者明确说了暂不支持，后续好像也没有开发的计划
	 */

}
