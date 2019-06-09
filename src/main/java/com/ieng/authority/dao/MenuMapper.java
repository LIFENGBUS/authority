package com.ieng.authority.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ieng.authority.pojo.Menu;

public interface MenuMapper {

	List<Menu> getMenuByPid(@Param("rid")Integer rid, @Param("pid")Integer pid);

}
