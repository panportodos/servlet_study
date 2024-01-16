package com.study.servlet_study.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class RequestCharEncodingFilter
 */
@WebFilter("/*")
public class RequestCharEncodingFilter extends HttpFilter implements Filter {

	public RequestCharEncodingFilter() {

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String[] methods = new String[] { "POST", "PUT" };
		if (Arrays.asList(methods).contains(httpRequest.getMethod().toUpperCase())) {// 리스트 안에 POST를 포함하고 있다면
			httpRequest.setCharacterEncoding("utf-8"); // 인코딩 해준다 (get요청이 들어오면 안바뀜)
		}

//		httpRequest.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
