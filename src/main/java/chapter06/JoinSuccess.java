package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_JoinSuccess", urlPatterns = { "/servlet/member/JoinSuccess" })
public class JoinSuccess extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Cookie[] cookies = request.getCookies();
		
		for(Cookie cookie : cookies) {
			String name = cookie.getName();
			
			if(name.equals("isJoin")) {
				String value = cookie.getValue();
				
				if(value.equals("true")) {
					response.setContentType("text/html;charset=UTF-8");
					
					PrintWriter output = response.getWriter();
					
					output.print("<h1>회원 가입 완료</h1>");
					output.print("<a href = \"web_2022-03-21/main/index.html\">메인 페이지로 이동</a>");
					
//					response.sendRedirect("/web_2022-03-21/member/join/joinSuccess.html");
				}
			}
		}
		} catch(NullPointerException e) {
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter output = response.getWriter();
			
			output.print("<h1>접근 권한이 없습니다!</h1>");
			output.print("<a href = \"web_2022-03-21/member/join/join.html\">메인 페이지로 이동</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
