package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BorrowDao;
import entity.Borrow;

public class returnbook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public returnbook() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*根据图书id+读者id找到borrow记录
		 * get到borrow记录的boid
		 * 调用back
		 * 把isback置为1
		 * 表示此条borrow已失效
		 * */
		int borrowid = 0;
		String bookid = req.getParameter("bookid");
		String readerid = req.getParameter("readerid");
		BorrowDao bd = new BorrowDao();
		borrowid = bd.acquireboid(bookid, readerid);
		if(borrowid != 0){
			bd.Back(borrowid);
			List<Borrow> blist = bd.BorrowList(readerid);
			req.getSession().setAttribute("blistreturn", blist);
			resp.sendRedirect(req.getContextPath()+"/returnSuccess.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/return.jsp?returnfail=yes");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
