package com.study.servlet_study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getMethod());
		System.out.println(request.getRequestURL());//풀 주소
		System.out.println(request.getRequestURI());//주소 뒷부분
		System.out.println(response.getStatus());//정상적인 상태로 응답을 받으면 200을 준다
		
		response.setContentType("text/plain");//컨텐츠 타입을 지정한다
		//response.setCharacterEncoding("utf-8");//한글을 쓰려면 utf-8로 잡아줘야한다
		System.out.println(response.getContentType());//null, 응답한 data가 없다
		
		response.getWriter().println("Hello");
		System.out.println("요청이 들어옴~!");
	}
} 
