package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

import entity.Book;

public class addbook extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addbook() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String bid = req.getParameter("bid");
		BookDao dao = new BookDao();
		Book btmp = dao.QueryBook(bid);
		boolean flag = false;
		String name = req.getParameter("name");
		String isbn = req.getParameter("isbn");
		int edition = Integer.parseInt(req.getParameter("edition"));
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		float price = Float.parseFloat(req.getParameter("price"));
		int page = Integer.parseInt(req.getParameter("page"));
		String translator = req.getParameter("translator");
		String operator = req.getParameter("operator");
		String inTime = req.getParameter("inTime");
		Book b = new Book();
		b.setbid(bid);
		b.setname(name);
		b.setisbn(isbn);
		b.setedition(edition);
		b.setauthor(author);
		b.setpublisher(publisher);
		b.setprice(price);
		b.setpage(page);
		b.settranslator(translator);
		b.setoperator(operator);
		b.setinTime(inTime);
		
		try{
			if(bid.equals(btmp.getbid())){
				flag = true;
			}
		}catch(Exception e){
			
		}finally{
			if(flag){
				resp.sendRedirect(req.getContextPath()+"/BookAdd.jsp?addfail=yes");
			}else{
				dao.AddBook(b);
				req.getSession().setAttribute("addbook", b);
				resp.sendRedirect(req.getContextPath()+"/addSuccess.jsp");
			}
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
