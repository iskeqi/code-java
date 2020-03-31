package com.keqi.springbootmybatismapperxml.mapper;

import com.keqi.springbootmybatismapperxml.domain.SysNotice;
import com.keqi.springbootmybatismapperxml.domain.SysNoticeObj;

public interface SysNoticeMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    SysNotice selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);

    /*测试使用Object类型的参数接收数值类型和字符串类型时，能不能够自动的进行判断*/
    SysNoticeObj selectByPrimaryKeyObj(Integer noticeId);
}