package chapter03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Join", urlPatterns = { "/ch03_join" })
public class Join extends HttpServlet {
	public static List<MemberInfo> memberInfoList = new ArrayList<>();
	
	public void checkParameter(String id, String pw, HttpServletResponse response) throws IOException {
		if(id.length()==0 || pw.length()==0) {
			response.sendRedirect("/joinFail.html");
		} else if(id.indexOf(' ') != -1) {
			response.sendRedirect("/joinFail.html");
		} else if(id.length()<4 || id.length() >10) {
			response.sendRedirect("/joinFail.html");
		}
	}
	
	public boolean usedId(String id) {
		boolean exist = false;
		for(MemberInfo comp : memberInfoList) {
			if(comp.getId().equals(id)) {
				// 아이디 중복 표시
				exist = true;
				break;
			} 
		}
		
		return exist;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 id, pw 값을 꺼냄
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 파라미터가 올바른지 여부를 확인 ( checkParameter ) 할 때
		// 올바르지 않다면 클라이언트가 리다이렉트 해야할 경로를 지정해줬으므로
		// 올바르지 않을 때는 리다이렉트 해야할 경로로 이동하도록 이 서블릿이 그대로 끝날 수 있게 if문을 구성
		boolean pass = checkParameter(id,pw,response);
		
		// 회원가입 : 새로운 회원의 정보를 이 사이트의 데이터베이스에 저장하는 것
		MemberInfo memberInfo = new MemberInfo(id,pw);
		
		boolean exist = usedId(id);
//		// 아이디 입력 여부 -> 아이디를 입력하지 않았다면 회원가입 실패 처리 / 아이디를 입력했다면 그 다음 동작에 진입
//		if(id.length()==0 || pw.length()==0) {
//			response.sendRedirect("/joinFail.html");
//		}
//		
//		// 아이디 내 공백 포함 여부
//		if(id.indexOf(' ') != -1) {
//			response.sendRedirect("/joinFail.html");
//		}
//		
//		if(id.length()<4 || id.length() >10) {
//			response.sendRedirect("/joinFail.html");
//		}
		
		// 위의 코드들을 아래처럼 합칠 수 있다
		
		//아이디에 우리가 정하지 않은 특수문자가 들어있을 경우
		//비밀번호에 우리가 정하지 않은 특수 문자가 들어있을 경우
		
//		if(id.length()==0 || pw.length()==0) {
//			response.sendRedirect("/joinFail.html");
//		} else if(id.indexOf(' ') != -1) {
//			response.sendRedirect("/joinFail.html");
//		} else if(id.length()<4 || id.length() >10) {
//			response.sendRedirect("/joinFail.html");
//		} // checkParameter 메서드로 옮긴다
//		else if(아이디에 우리가 정하지 않은 특수문자가 들어있을 경우) {
//			response.sendRedirect("/joinFail.html");
//		} else if(비밀번호에 우리가 정하지 않은 특수 문자가 들어있을 경우) {
//			response.sendRedirect("/joinFail.html");
//		} 
		
		// 비밀번호 내 공백 포함 여부
		
		// 아이디 중복 여부 체크 메서드로
		// 아이디가 사용 중이라면
		// 회원 가입 실패 페이지로 이동
//		boolean exist = false;
//		for(MemberInfo comp : memberInfoList) {
//			if(comp.getId().equals(id)) {
//				// 아이디 중복 표시
//				exist = true;
//				break;
//			} 
//		}
		
		if(exist) {
			response.sendRedirect("/joinFail.html");
		} else {
		// 아이디가 사용중이지 않으면
		// 회원 가입
		memberInfoList.add(memberInfo);
		}
		
		Cookie cookie = new Cookie("isLogin","true");
		
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("isJoin","true");
		
		response.addCookie(cookie2);
		
		// 회원가입 완료 페이지로 이동
		response.sendRedirect("/joinSuccess.html");
	}

}
