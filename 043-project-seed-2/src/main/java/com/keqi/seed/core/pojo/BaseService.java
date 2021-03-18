package com.keqi.seed.core.pojo;

public interface BaseService<DO extends BaseDO> {

    void insert(DO t);

    void deleteById(long id);

    void updateById(DO t);

    DO findById(long id);
}
