package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex02", urlPatterns = { "/ch06_ex02" })
public class Ex02 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		try {
			for(Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
			
				if(name.equals("id")) {
					System.out.println("이 서비스가 원하는 쿠키 있음");
				}
			
			System.out.println(name + " = " + value);
			}
		} catch(NullPointerException e) {
			System.out.println("쿠키가 없습니다.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
