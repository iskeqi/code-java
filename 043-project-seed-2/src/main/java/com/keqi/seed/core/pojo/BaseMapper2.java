package com.keqi.seed.core.pojo;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.CollectionUtils;

import java.util.List;

public interface BaseMapper2<DO> {

    void insert(DO t);

    default void insertList(List<DO> list) {
        if (!CollectionUtils.isEmpty(list)) {
            for (DO t : list) {
                this.insert(t);
            }
        }
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
            return null;
        }
        return list.get(0);
    }
}
