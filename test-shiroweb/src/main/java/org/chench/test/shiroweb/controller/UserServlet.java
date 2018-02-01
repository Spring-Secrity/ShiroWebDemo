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
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.chench.test.shiroweb.util.Constants;
import org.chench.test.shiroweb.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc org.chench.test.shiroweb.controller.UserServlet
 * @author chench9@lenovo.com
 * @date 2017年4月28日
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(UserServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(Constants.ACTION_LOGIN.equals(action)) {
			login(req, resp);
		}else if(Constants.ACTION_LOGOUT.equals(action)) {
			logout(req, resp);
		}
	}
	
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		Exception exception = null;
		Subject currentUser = SecurityUtils.getSubject();
		//currentUser.getSession();
		
		if(!currentUser.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(name, password);
			try {
				currentUser.login(token);
			} catch (UnknownAccountException e) {
				exception = e;
				logger.error(String.format("user not found: %s", name), e);
			} catch(IncorrectCredentialsException e) {
				exception = e;
				logger.error(String.format("user: %s pwd: %s error", name, password), e);
			} catch (ConcurrentAccessException e) {
				exception = e;
				logger.error(String.format("user has been authenticated: %s", name), e);
			} catch (AuthenticationException e) {
				exception = e;
				logger.error(String.format("account except: %s", name), e);
			}
		}
		
		if(exception == null) {
			if(logger.isDebugEnabled()) {
				logger.debug("user: {} login sucess", name);
			}
			MyUtil.forword(req, resp, "home.jsp");
			return;
		}
		
		req.setAttribute("ex", exception);
		req.setAttribute("name", name);
		MyUtil.forword(req, resp, "error.jsp");
	}
	
	private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()) {
			currentUser.logout();
		}
		req.getSession().invalidate();
		MyUtil.redirect(req, resp, "index");
	}

}
