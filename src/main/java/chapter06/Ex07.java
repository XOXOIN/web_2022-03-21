package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ch06_Ex07", urlPatterns = { "/chapter06/session/get" })
public class Ex07 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		String clientIP = (String) session.getAttribute("clientIP");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter output = response.getWriter();
		output.print("<h1>당신의 IP는 <span>" + clientIP + "</span> 입니다.</h1>");
		
		session.removeAttribute("clientIP");
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
