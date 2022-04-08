package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch06_Ex09", urlPatterns = { "/ch06_ex09" })
public class Ex09 extends HttpServlet {
private ServletContext context;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String shutDownTime = context.getInitParameter("shutDownTime");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter output = response.getWriter();
		
		output.print("<h1>Chapter06 - Ex09 입니다</h1>");
		output.print("<p>서버가 " + shutDownTime + " 에 임시 점검을 시작합니다.</p>");
		output.print("<p>임시 점검을 시작하기 전 작업을 마무리하세요.</P");
		
		// 인자로 지정한 경로의 파일이 실제 프로젝트 내에서는 어디에 위치하는지 알려주는 메서드
		String realPath = context.getRealPath("index.html");
		System.out.println(realPath);
		
		output.close();
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		config.getServletContext();
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
