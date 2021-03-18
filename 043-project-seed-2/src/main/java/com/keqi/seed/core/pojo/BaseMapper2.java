package com.keqi.seed.core.pojo;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.CollectionUtils;

import java.util.List;

public interface BaseMapper2<DO extends BaseDO> {

    int insert(DO t);

    default int insertList(@Param("list") List<DO> list) {
        int count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            for (DO t : list) {
                count += this.insert(t);
            }
        }
        return count;
    }

    int delete(DO condition);

    int update(@Param("t") DO t, @Param("con") DO condition);

    List<DO> findList(DO condition);

    default DO find(DO condition) {
        List<DO> list = this.findList(condition);
        if (list.size() > 1) {
            throw new RuntimeException("Expect one, actually return multiple results");
        }
        if (list.size() == 0) {
            try {
                BaseDO t = condition.getClass().newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException("Cannot instantiate object with no-argument constructor");
            }
        }
        return list.get(0);
    }
}
