/**
 * 
 */
package org.chench.test.shiroweb.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @desc org.chench.test.shiroweb.util.MyUtil
 * @author chench9@lenovo.com
 * @date 2017年3月9日
 */
public class MyUtil {
	
	public static void forword(HttpServletRequest req, HttpServletResponse resp, String pageName) throws ServletException, IOException {
		req.getRequestDispatcher(MyUtil.getPagePath(pageName)).forward(req, resp);
	}
	
	public static void redirect(HttpServletRequest req, HttpServletResponse resp, String uri) throws IOException {
		resp.sendRedirect(uri);
	}
	
	private static String getPagePath(String page){
		return Constants.NAME_VIEW_PATH + page;
	}

	private MyUtil(){
	}
}
