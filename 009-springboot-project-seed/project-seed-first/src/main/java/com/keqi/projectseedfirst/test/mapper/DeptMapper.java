package com.keqi.projectseedfirst.test.mapper;

import com.keqi.projectseedfirst.test.domain.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
	int deleteByPrimaryKey(Long deptId);

	int insert(Dept record);

	int insertSelective(Dept record);

	Dept selectByPrimaryKey(Long deptId);

	int updateByPrimaryKeySelective(Dept record);

	int updateByPrimaryKey(Dept record);

	/**
	 * 查询指定deptId下的所有直接子级部门
	 *
	 * @param parentId parentId
	 * @return deptList
	 */
	List<Dept> selectAllByParentId(@Param("parentId") Long parentId);


}