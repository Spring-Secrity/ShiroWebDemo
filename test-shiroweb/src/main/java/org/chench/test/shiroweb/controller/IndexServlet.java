/**
 * 
 */
package org.chench.test.shiroweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.env.WebEnvironment;
import org.apache.shiro.web.util.WebUtils;
import org.chench.test.shiroweb.util.MyUtil;

/**
 * @desc org.chench.test.shiroweb.controller.IndexServlet
 * @author chench9@lenovo.com
 * @date 2017年3月9日
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WebEnvironment environment = WebUtils.getRequiredWebEnvironment(req.getSession().getServletContext());
		System.out.println(environment);
		MyUtil.forword(req, resp, "index.jsp");
	}

}
