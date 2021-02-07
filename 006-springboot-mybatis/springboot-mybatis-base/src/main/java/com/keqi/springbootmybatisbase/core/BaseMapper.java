package com.keqi.springbootmybatisbase.core;

import com.keqi.springbootmybatisbase.core.pojo.PageParam;
import org.apache.ibatis.annotations.Param;

import java.util.Collections;
import java.util.List;

public interface BaseMapper<DO, VO, P extends PageParam> {

    int insert(DO t);

    int insertList(@Param("list") List<DO> list);

    int updateById(DO t);

    int update(@Param("t") DO t, @Param("con") DO condition);

    int deleteById(long id);

    int delete(DO condition);

    int deleteByIds(@Param("ids") List<Long> ids);

    DO findById(long id);

    DO find(DO condition);

    List<DO> findByIds(@Param("ids") List<Long> ids);

    List<DO> findList(DO condition);

    default List<VO> page(P param) {
        long count = this.pageCount(param);
        List<VO> list = Collections.emptyList();
        if (count > 0) {
            list = this.pageQuery(param);
        }
        return list;
    }

    long pageCount(P param);

    List<VO> pageQuery(P param);
}
