package com.keqi.springboothibernatevalidator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 嵌套子对象的使用场景(其实就是在嵌套对象属性上方，再加上一个@Valid注解而已啦)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserCreateBatchRequestParam implements Serializable {
	private static final long serialVersionUID = -2962873588297887943L;

	@Valid
	@NotEmpty(message = "sysUserList不能为空")
	@Size(min = 1, message = "sysUserList至少需要一个参数")
	private List<SysUserCreateRequestParam> sysUserList;
}
