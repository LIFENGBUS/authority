package com.ieng.authority.dao;

import java.util.List;

import com.ieng.authority.pojo.Element;

public interface ElementMapper {

	List<Element> getElementByPid(Integer rid);

}
