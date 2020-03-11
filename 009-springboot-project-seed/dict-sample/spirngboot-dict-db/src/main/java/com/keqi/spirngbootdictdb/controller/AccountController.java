package com.keqi.spirngbootdictdb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.spirngbootdictdb.common.AjaxEntity;
import com.keqi.spirngbootdictdb.common.AjaxEntityBuilder;
import com.keqi.spirngbootdictdb.dict.DictUtil;
import com.keqi.spirngbootdictdb.domain.Account;
import com.keqi.spirngbootdictdb.domain.AccountEnum;
import com.keqi.spirngbootdictdb.domain.AccountVO;
import com.keqi.spirngbootdictdb.enums.ActiveFlagEnum;
import com.keqi.spirngbootdictdb.enums.UserTypeEnum;
import com.keqi.spirngbootdictdb.mapper.AccountMapper;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 用户Controller
 */
@RestController
@AllArgsConstructor
@Validated
public class AccountController {

	private final AccountMapper accountMapper;

	// 直接由前端调用字典接口进行数据值得替换(后端很舒服，前端也还行，但是这样真的是好的方式吗？)
	@GetMapping("/account/detail1")
	public AjaxEntity detail1(Long id) {
		// 查询单个数据详情
		Account account = accountMapper.selectByPrimaryKey(id);

		// VO转换
		AccountVO accountVO = new AccountVO();
		BeanUtil.copyProperties(account, accountVO);
		return AjaxEntityBuilder.success(accountVO);
	}

	// 后端通过缓存中的数据进行替换(前端最舒服，后端还勉强能够忍受)
	@GetMapping("/account/detail2")
	public AjaxEntity detail2(Long id) {
		// 查询单个数据详情
		Account account = accountMapper.selectByPrimaryKey(id);

		// VO转换
		AccountVO accountVO = new AccountVO();
		BeanUtil.copyProperties(account, accountVO);
		accountVO.setUserTypeName(DictUtil.getVlueName("sc_user_type", accountVO.getUserType()));
		accountVO.setActiveFlagName(DictUtil.getVlueName("sc_active_type", accountVO.getActiveFlag()));
		return AjaxEntityBuilder.success(accountVO);
	}

	// 后端通过固定写死的枚举类来获取对应的数据
	@GetMapping("/account/detail3")
	public AjaxEntity detail3(Long id) {
		// 查询单个数据详情
		Account account = accountMapper.selectByPrimaryKey(id);

		// VO转换
		AccountVO accountVO = new AccountVO();
		BeanUtil.copyProperties(account, accountVO);
		accountVO.setUserTypeName(UserTypeEnum.valueOf(accountVO.getUserType()).getValueName());
		accountVO.setActiveFlagName(ActiveFlagEnum.valueOf(accountVO.getActiveFlag()).getValueName());
		return AjaxEntityBuilder.success(accountVO);
	}


	// 推荐写法！推荐写法！推荐写法！推荐写法！推荐写法！推荐写法！推荐写法！推荐写法！推荐写法！推荐写法！

	// 后端通过固定写死的枚举类搭配MyBatis直接查询出来(但是数据库对应字段标识符必须是varchar/char类型的，数值型是万万不可的)
	// 如果非要指定为数值类型的话，就需要自己编写一个自定义的类型转换器

	// 在使用MyBatis时，直接使用枚举类型字段接收字符串类型，这是完全可以被接受的，jdbcType指定为char或者是varchar都行
	@GetMapping("/account/detail4")
	public AjaxEntity detail4(Long id) {
		// 查询单个数据详情
		AccountEnum account = accountMapper.selectAccountEnumByPrimaryKey(id);

		// VO转换
		AccountVO accountVO = new AccountVO();
		// 将一个枚举类型对象赋值给一个同名的字符串类型对象，是能够直接进行赋值的，赋值的就是枚举类父类Enum的那个name属性
		BeanUtil.copyProperties(account, accountVO);

		// 如下通过枚举对象获取对应的valueName属性值
		accountVO.setUserTypeName(account.getUserType().getValueName());
		accountVO.setActiveFlagName(account.getActiveFlag().getValueName());
		return AjaxEntityBuilder.success(accountVO);
	}

	// 测试SpringMVC直接使用枚举对象来接收对应的同名的字符串
	// 可见，直接使用枚举类来接收同名的字符串，也是支持的，这样就更加的方便啦
	// 程序中无论是有多个参数还是只有一个参数，都使用枚举类来进行封装这是一种非常好的方式
	// 数据库中也是用字符串来表示对应的标识符，这样从controller->service->mapper就一路畅通无阻啦
	@GetMapping("/account/detail5")
	public AjaxEntity detail5(@NotNull UserTypeEnum userType) {
		return AjaxEntityBuilder.success(userType.getValueName());
	}
}
