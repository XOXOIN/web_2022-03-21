package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex01", urlPatterns = { "/chapter03/ex01" })
public class Ex01 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("MIME TYPE(포장할 내용);(포장할 방식)");
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter outputstream = response.getWriter();
		
		outputstream.append("<html>");
		outputstream.append("	<head>");
		outputstream.append("		<title>Servlet Response Web Page</title>");
		outputstream.append("	<body>");
		outputstream.append("		<h1>Nice to meet you!</h1>");
		outputstream.append("		<h1>만나서 반갑습니다!</h1>");
		outputstream.append("	</body>");
		outputstream.append("	</head>");
		outputstream.append("</html>");
		
		outputstream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
