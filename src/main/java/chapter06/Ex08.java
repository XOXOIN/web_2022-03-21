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

@WebServlet(name = "ch06_Ex08", urlPatterns = { "/ch06_ex08" })
public class Ex08 extends HttpServlet {
	private ServletContext context;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String shutDownTime = context.getInitParameter("shutDownTime");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter output = response.getWriter();
		
		output.print("<h1>Chapter06 - Ex08 입니다</h1>");
		output.print("<p>서버가 " + shutDownTime + " 에 임시 점검을 시작합니다.</p>");
		output.print("<p>임시 점검을 시작하기 전 작업을 마무리하세요.</P");
		
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
