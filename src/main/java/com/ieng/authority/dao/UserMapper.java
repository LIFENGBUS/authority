package com.ieng.authority.dao;

import com.ieng.authority.pojo.User;

public interface UserMapper {

	User queryUserLogin(String username, String password);
	

}
