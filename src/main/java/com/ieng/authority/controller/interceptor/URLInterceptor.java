package com.ieng.authority.controller.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ieng.authority.pojo.Url;
import com.ieng.authority.pojo.User;

public class URLInterceptor implements HandlerInterceptor{
	private Logger logger = LoggerFactory.getLogger(URLInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("LOGIN_USER");
		logger.debug("Request URI: {} ; User: {}" , uri, user);
		if(user != null) {
			List<Url> urls = (List<Url>) session.getAttribute("ALLURL");
			boolean isExists = false;
			for (Url url : urls) {
				if(url.getName().equals(uri)) {
					isExists = true;
				}
			}
			if(isExists) {
				boolean isRight = false;
				for (Url url : user.getUrls()) {
					if(url.getName().equals(uri)) {
						isRight = true;
					}
				}
				if(isRight) {
					return true;
				}else {
					//删除用户登录信息和访问的路径
					session.removeAttribute("LOGIN_USER");
					session.removeAttribute("ALLURL");
					response.sendRedirect(request.getContextPath() + "/login");
					return false;
				}
			}else {
				return true;
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

}
