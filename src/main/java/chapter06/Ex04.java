package chapter06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ch06_Ex04", urlPatterns = { "/chapter06/session/create" })
public class Ex04 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션은 쿠키와 다르게 따로 생성하는 코드가 없고
		// 요청 정보를 갖고 있는 객체.getSession() 메서드를 호출해서
		// 세션이 없는 클라이언트는 세션이 만들어지고
		// 세션이 있는 클라이언트는 세션ID를 사용해서 기존에 만들어진 세션을 가져옴
		HttpSession session = request.getSession();
		
		if(session == null) {
			System.out.println("세션 없음");
		} else {
			System.out.println("세션 있음");
			
			if(session.isNew()) {
				System.out.println("세션이 새로 만들어짐");
				
				session.setMaxInactiveInterval(1800); // 세션 유지시간 설정 (초)
			} else {
				System.out.println("기존에 만들어진 세션");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
