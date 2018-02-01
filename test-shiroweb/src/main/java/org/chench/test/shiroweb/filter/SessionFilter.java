/**
 * 
 */
package org.chench.test.shiroweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @desc org.chench.test.shiroweb.filter.SessionFilter
 * @author chench9@lenovo.com
 * @date 2017年3月9日
 */
public class SessionFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter do filter");
		chain.doFilter(request, response);
	}

	public void destroy() {
		System.out.println("filter destroy");
	}

}
