package com.ieng.authority.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ieng.authority.dao.ElementMapper;
import com.ieng.authority.dao.MenuMapper;
import com.ieng.authority.dao.UrlMapper;
import com.ieng.authority.dao.UserMapper;
import com.ieng.authority.pojo.User;
import com.ieng.authority.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private ElementMapper elementMapper;
	@Autowired
	private UrlMapper urlMapper;

	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<>();
		User user = userMapper.queryUserLogin(username, password);
		if(user != null) {
			user.setMenus(menuMapper.getMenuByPid(user.getRid(), 0));
			user.setElements(elementMapper.getElementByPid(user.getRid()));
			user.setUrls(urlMapper.getUrlByRid(user.getRid()));
			map.put("allUrl", urlMapper.showAll());
		}
		map.put("user", user);
		return map;
	}

}
