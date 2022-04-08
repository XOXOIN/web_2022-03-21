package chapter07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter1 implements Filter{

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// 서블릿 -> HttpServlet의 자식 / doGet, doPost 등의 메서드를 오버라이딩 
		// web.xml에 서블릿의 URL을 지정
		
		// 필터 -> Filter를 구현 / doFilter 메서드를 오버라이딩 
		// web.xml에 필터의 URL을 지정
		
		System.out.println("<< doFilter() 호출 전 >>");
		
		arg1.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = arg1.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print(" <title>servlet</title>");
		out.print("</head>");
		out.print("<body>");
		
		arg2.doFilter(arg0,arg1);
		
		out.print("</body>");
		out.print("</html>");

		out.close();
		
		System.out.println("<< doFilter() 호출 후 >>");
	}
	
	

}
