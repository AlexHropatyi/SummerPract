package lab.testservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/MyServlet", description="ServletTesting")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String sn = request.getParameter("surname");
		String cn = request.getParameter("country_name");
		String sex = request.getParameter("sex");
		String point = request.getParameter("cnt_of_points");
		String medal = request.getParameter("cnt");
		System.out.println(id + " " + sn + " " + cn + " " + sex + " " + point + " " + medal);
	
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<h3> Информация о биатлонисте: </h3> "+id+" "+sn+" "+cn+" "+sex+" "+point+" "+medal+"");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
