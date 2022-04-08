package chapter06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 사용자의 IP를 사용해서 우리 서비스를 이용한 횟수를 세주는 서블릿
@WebServlet("/chapter06/counter")
public class Counter extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String clientIP = request.getRemoteAddr();
		
		ServletContext context = getServletContext();
		
		int count = 0;
		try {
			count = (int) context.getAttribute(clientIP);
		
		} catch(NullPointerException e) {
			
		}
		
		count++;
		
		context.setAttribute(clientIP, count);
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter output = response.getWriter();
		
		output.print("<h1>아이피 : " + clientIP + "</h1>");
		output.print("<h1>이용 횟수 : " + clientIP + " </h1>");
		
		output.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
