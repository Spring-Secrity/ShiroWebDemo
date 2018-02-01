/**
 * 
 */
package org.chench.test.shiroweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.chench.test.shiroweb.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户管理
 * @desc org.chench.test.shiroweb.controller.AdminServlet
 * @author chench9@lenovo.com
 * @date 2017年4月29日
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(AdminServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(logger.isDebugEnabled()) {
			logger.debug("admin manage action");
		}
		
		String roleAdmin = "admin";
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.hasRole(roleAdmin)) {
			logger.error("user: {} has not role: {}", currentUser.getPrincipal(), roleAdmin);
			AuthorizationException ex = new AuthorizationException("user has not role: " + roleAdmin);
			req.setAttribute("ex", ex);
			MyUtil.forword(req, resp, "error.jsp");
			return;
		}
		
		MyUtil.forword(req, resp, "admin.jsp");
	}
	
}
