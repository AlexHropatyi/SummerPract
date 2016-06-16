package web_view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectOperation
 */
@WebServlet("/SelectOperation")
public class SelectOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int operation;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation = Integer.parseInt(request.getParameter("operation"));
		String tableClassName = SelectTable.tableName;
		String formName = "";
		if(operation == 4){
			formName = "getId.html";
		}else if(tableClassName.equals("model.Biathlete")){
			if(operation == 1){
				formName = "inputbiathlete.html";
			}else if(operation == 2){
				formName = "editbiathlete.html";
			}
		}else if(tableClassName.equals("model.Race")){
			if(operation == 1){
				formName = "inputrace.html";
			}else if(operation == 2){
				formName = "editrace.html";
			}
		}else if(tableClassName.equals("model.Results")){
			if(operation == 1){
				formName = "inputresults.html";
			}else if(operation == 2){
				formName = "editresults.html";
			}
		}else if(tableClassName.equals("model.General")){
			if(operation == 1){
				formName = "inputgeneral.html";
			}else if(operation == 2){
				formName = "editgeneral.html";
			}
		}else if(tableClassName.equals("model.Medals")){
			if(operation == 1){
				formName = "inputmedals.html";
			}else if(operation == 2){
				formName = "editmedals.html";
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}