package web_view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.TableModel;

import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;

import controller.JPAController;

/**
 * Servlet implementation class SelectTable
 */
@WebServlet("/SelectTable")
public class SelectTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static JPAController controller;
	public static String tableName;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTable() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static JPAController getController(){
    	if(controller == null){
    		controller = new JPAController();
    	}
    	return controller;
    }
    
    public static TableModel getTableModel(){
    	Class tableClass = null;
    	try{
    		tableClass = Class.forName(tableName);
    	}catch(ClassNotFoundException e){
    		e.printStackTrace();
    	}
    	return getController().getTableModel(tableClass);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tableName = "model." + request.getParameter("tableName");
		request.setAttribute("model", getTableModel());
		request.setAttribute("tableName", tableName);
		request.getRequestDispatcher("showTable.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
