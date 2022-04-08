package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex03", urlPatterns = { "/ch03_ex03" })
public class Ex03 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(301);
		response.setHeader("Location","http://localhost/ch03_ex02");
		
		response.setContentType("text/plain;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
//		out.append("ex03으로 접근했습니다");
		out.print("ex03으로 접근했습니다");
		
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
