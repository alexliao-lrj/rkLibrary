package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.impl.ReaderLoginImpl;
import entity.Reader;

public class loginaction extends HttpServlet{

	private ReaderLoginImpl dao = new ReaderLoginImpl();
	private String ID;
	private String password;
	Reader reader;
	
	public loginaction() {
		super();
	}
    @Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	 doPost(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ID = req.getParameter(ID);
		password=req.getParameter(password);
		reader=new Reader();
		reader.setReaderId(ID);
		reader.setReaderPwd(password);
		if(dao.login(reader))
		{
			req.getSession().setAttribute("reader",reader);
			resp.sendRedirect(req.getContextPath()+"/readermain.jsp");
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/login_failed.jsp");
		}
		
	}
	@Override
	public void init() throws ServletException {
		// Put your code here
	}
	

}
