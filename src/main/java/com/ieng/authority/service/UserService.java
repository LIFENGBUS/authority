package com.ieng.authority.service;

import java.util.Map;

import com.ieng.authority.pojo.User;

public interface UserService {

	Map<String, Object> login(String username, String password);

}
