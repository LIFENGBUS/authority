package com.ieng.authority.dao;

import java.util.List;

import com.ieng.authority.pojo.Url;

public interface UrlMapper {

	List<Url> getUrlByRid(Integer rid);
	List<Url> showAll();

}
