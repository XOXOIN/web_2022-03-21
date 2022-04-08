package jquery;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "jquery_First", urlPatterns = { "/jquery/first" })
public class First extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 데이터를 꺼내서 출력하세요.
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		
		System.out.println("클라이언트가 전달한 데이터");
		System.out.println("name1 = " + name1);
		System.out.println("name2 = " + name2);
		
		// 첫 번째 컨텐츠를 DB에서 불러옴
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		// 불러온 첫 번째 컨텐츠를 클라이언트에게 전달
		
		response.setContentType("text/plane;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("첫 번째 컨텐츠");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
