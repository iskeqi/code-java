package com.keqi.seed.core.pojo;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.CollectionUtils;

import java.util.List;

public interface BaseMapper2<DO extends BaseDO> {

    int insert(DO t);

    int delete(DO condition);

    int update(@Param("t") DO t, @Param("con") DO condition);

    List<DO> findList(DO condition);

    default int insertList(@Param("list") List<DO> list) {
        int count = 0;
        if (!CollectionUtils.isEmpty(list)) {
            for (DO t : list) {
                count += this.insert(t);
            }
        }
        return count;
    }

    default int deleteById(long id) {
        // 这种方式运行时会报错
        return this.delete((DO) new BaseDO(id));
    }

    default int deleteByIds(@Param("ids") List<Long> ids) {
        int count = 0;
        if (!CollectionUtils.isEmpty(ids)) {
            for (Long id : ids) {
                count += this.deleteById(id);
            }
        }
        return count;
    }

    default int updateById(DO t) {
        BaseDO id;
        try {
            id = t.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Cannot instantiate object with no-argument constructor");
        }
        id.setId(t.getId());

        t.setId(null);
        return this.update(t, (DO) id);
    }

    default DO findById(long id) {
        // 这种方式运行时会报错
        return this.find((DO) new BaseDO(id));
    }

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
