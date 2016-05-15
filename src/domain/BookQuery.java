package domain;

import java.util.List;

import entity.Book;
import dao.BookDao;

public class BookQuery {
	
	BookDao bookdao = new BookDao();


	public List<Book> QueryBooks(String[] bookinf) {
		// TODO Auto-generated method stub
		String hql;
		hql="FROM Book b WHERE (b.bid LIKE '%"+bookinf[0]+"%' " +
			"AND b.name LIKE '%"+bookinf[1]+"%' "+
			"AND b.author LIKE '%"+bookinf[2]+"%' "+
			"AND b.publisher LIKE '%"+bookinf[3]+"%') ";
		
		return bookdao.QueryBooks(hql);
	}

	public List<Book> SearchBooks(String no, String name) {
		// TODO Auto-generated method stub
		String hql="FROM Book b WHERE b.bid LIKE '%"+no+"%' " +
				"AND b.name LIKE '%"+name+"%' ";
		return bookdao.QueryBooks(hql);
	}

	public Book SearchBook(String bookid) {
		// TODO Auto-generated method stub
		return bookdao.QueryBook(bookid);
	}

}
