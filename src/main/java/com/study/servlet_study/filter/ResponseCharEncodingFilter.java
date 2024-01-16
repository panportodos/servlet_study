package com.study.servlet_study.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")//모든 파일에서 설정
public class ResponseCharEncodingFilter extends HttpFilter implements Filter {


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;//http안붙은 것들은 무조건 다운캐스팅 시켜서 쓴다
	
		httpResponse.setCharacterEncoding("utf-8");
		//Dofilter기준으로 그 전까지가 전처리 영역
		
		
		chain.doFilter(request, response);//doGet으로 갔다가 호출이 끝나면 다시 돌아옴
		//그 이후부터가 후처리 영역
		//httpResponse.getWriter().println("무조건 후처리함");
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
