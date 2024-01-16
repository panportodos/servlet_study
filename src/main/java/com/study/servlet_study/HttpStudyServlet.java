package com.study.servlet_study;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/http")
public class HttpStudyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HttpStudyServlet() {// 생성자
		super();
	}

	// HTTP 메소드 - Post, Get, Put, Delete (CRUD)
	// POST 요청 : Create 추가
	// GET 요청 : Read 조회
	// PUT 요청 : Update 수정
	// DELETE 요청 : Delete 삭제

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8"); //요청 때도 인코딩을 해줘야한다

		Map<String, String> paramsMap = new HashMap<>();

		request.getParameterMap().forEach((k, v) -> {// 키값을 명시하지 않았는데도 하나씩 읽어들여 다 볼 수 있다
//			String[] valueArray = v;
			StringBuilder builder = new StringBuilder(); // 비어있는 문자열을 담는 공간을 만든다
			Arrays.asList(v).forEach(value -> builder.append(value)); // asList:배열을list로 바꾼다/ 한글자 한글자로 된 value를 append시켜
																		// 문자열로 만든다
//			System.out.println(k + ": " + builder.toString()); // 빌더만 쓰면 객체기때문에 주소만 나오므로 toString붙여야
//			for (String value : v) {
//				System.out.print(value);
//			}
//			System.out.println();
			paramsMap.put(k, builder.toString());
		});

		System.out.println(paramsMap);

		// 위에께 어려우면 아래로 사용한다

		Map<String, String> paramsMap2 = new HashMap<>();

		Iterator<String> ir = request.getParameterNames().asIterator();
		while (ir.hasNext()) {
			String key = ir.next();
			paramsMap2.put(key, request.getParameter(key));
//			System.out.println(ir.next());
		}
		System.out.println(paramsMap2);

		String nameParams = request.getParameter("name");// 파라미터를 일일이 다 적어야 볼 수 있다
		String phoneParams = request.getParameter("phone");
		String emailParams = request.getParameter("email");
		String addressParams = request.getParameter("address");

//		System.out.println(nameParams);
//		System.out.println(phoneParams);
//		System.out.println(emailParams);
//		System.out.println(addressParams);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // doGet오버라이드
		Map<String, String> paramsMap = new HashMap<>();
		request.getParameterMap().forEach((k, v) -> {
			StringBuilder builder = new StringBuilder();
			Arrays.asList(v).forEach(value -> builder.append(value));
			paramsMap.put(k, builder.toString());
		});

		System.out.println(paramsMap);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
