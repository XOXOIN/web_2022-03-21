package chapter03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex05", urlPatterns = { "/ch03_ex05" })
public class Ex05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 로그인 : 회원 정보 중 사용자가 입력한 아이디와 비밀번호가 일치하는 회원 정보를 select (찾다)
		// 회원 정보 DB의 처음부터 끝까지 접근해서
		// n번째 회원의 아이디와 비밀번호가 사용자가 입력한 아이디, 비밀번호와 일치한다면
		// 로그인 성공
		// 일치하지 않는다면
		// 로그인 실패
		
		boolean success = false;
		for (MemberInfo nthMemberInfo : Join.memberInfoList) {
			if(nthMemberInfo.getId().equals(id) && nthMemberInfo.getPw().equals(pw)) {
				// 로그인 성공
				success = true;
				break;
			} 
		}
		
		if(success) {
			response.sendRedirect("loginSuccess.html");
		} else {
			response.sendRedirect("loginFail.html");
		}
		
		
		System.out.println("클라이언트가 전달한 id값 => " + id);
		System.out.println("클라이언트가 전달한 pw값 => " + pw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
