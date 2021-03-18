package com.keqi.seed.core.pojo;

import org.apache.ibatis.annotations.Param;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 不对分页查询方法进行总结，推荐使用 PageHelper 来实现分页
 *
 * @param <DO>
 */
public interface BaseMapper<DO> {

    org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BaseMapper.class);

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

    default int updateById(DO t) {
        // this.update(t, ) 这里到底是使用父类还是反射呢？(还是继承比较好吧)
        Class<?> clazz = t.getClass();
        DO o = null;
        try {
            Method getId = clazz.getMethod("getId");
            Object id = getId.invoke(t);

            Method setId = clazz.getMethod("setId");
            o = (DO) clazz.newInstance();
            setId.invoke(o, id);


        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            log.info(e.getMessage(), e);
        }
        return this.update(t, o);
    }

    int update(@Param("t") DO t, @Param("con") DO condition);

    default int deleteById(long id) {
        return this.delete(null);
    }

    int delete(DO condition);

    default int deleteByIds(@Param("ids") List<Long> ids) {
        int count = 0;
        if (!CollectionUtils.isEmpty(ids)) {
            for (Long id : ids) {
                count += this.deleteById(id);
            }
        }
        return count;
    }

    default DO findById(long id) {
        return this.find(null);
    }

    DO find(DO condition);

    List<DO> findByIds(@Param("ids") List<Long> ids);

    List<DO> findList(DO condition);

}
