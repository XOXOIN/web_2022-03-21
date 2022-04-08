package chapter03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ch03_Ex02", urlPatterns = {"/ch03_ex02"})
public class Ex02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.sendRedirect("/ch03_ex02.html");
//		PrintWriter outputstream = response.getWriter();
//		
//		outputstream.append("<html>");
//		outputstream.append("	<head>");
//		outputstream.append("		<title>ch03_ex02</title>");
//		outputstream.append("		<style>");
//		outputstream.append("			div {width : 50px; height: 50px; display : inline-block;}");
//		outputstream.append("			.red { background-color: red;}");
//		outputstream.append("			.orange { background-color: orange;}");
//		outputstream.append("			.yellow { background-color: yellow;}");
//		outputstream.append("			.green { background-color: green;}");
//		outputstream.append("			.blue { background-color: blue;}");
//		outputstream.append("			.navy { background-color: navy;}");
//		outputstream.append("			.purple { background-color: purple;}");
//
//		outputstream.append("		</style>");
//		outputstream.append("	</head>");
//		outputstream.append("	<body>");
//		outputstream.append("		<div class=\"red\"></div>");
//		outputstream.append("		<div class=\"orange\"></div>");
//		outputstream.append("		<div class=\"yellow\"></div>");
//		outputstream.append("		<div class=\"green\"></div>");
//		outputstream.append("		<div class=\"blue\"></div>");
//		outputstream.append("		<div class=\"navy\"></div>");
//		outputstream.append("		<div class=\"purple\"></div>");
//		outputstream.append("	</body>");
//		outputstream.append("</html>");
//		
//		outputstream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
