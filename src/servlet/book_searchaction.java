package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.ReaderDao;
import entity.Book;
import domain.BookQuery;
import domain.ReaderLogin;
import entity.Reader;

public class book_searchaction extends HttpServlet {
	
	public ReaderLogin rl = new ReaderLogin();
	Reader reader;

	/**
	 * Constructor of the object.
	 */
	public book_searchaction() {
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

		doPost(req,resp);
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
		req.setCharacterEncoding("UTF-8");
		String Book_ID = req.getParameter("Book_ID");
		String Book_name = req.getParameter("Book_name");
		String Author = req.getParameter("Author");
		String Publisher = req.getParameter("Publisher");
		BookQuery bq = new BookQuery();
		HttpSession session = req.getSession();
		
		String[] info={"","","",""};
		if(Book_ID!=null){
			info[0]=Book_ID;
		}
	    if(Book_name!=null){
	    	info[1]=Book_name;
		}
	    if(Author!=null){
			info[2]=Author;
		}
		if(Publisher!=null){
			info[3]=Publisher;
		}
		
		List<Book> l =bq.QueryBooks(info);
		session.setAttribute("book_list", l);
		resp.sendRedirect(req.getContextPath()+"/search_result.jsp");
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