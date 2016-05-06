package domain.impl;

import java.util.List;

import domain.BookQuery;
import entity.Book;
import dao.BookDao;
import dao.impl.BookDaoImpl;

public class BookQueryImpl implements BookQuery {
	
	BookDao bookdao = new BookDaoImpl();

	@Override
	public List<Book> QueryBooks(String bookinf, int booktype) {
		// TODO Auto-generated method stub
		String hql;
		if(booktype==-1){
			hql="FROM Book b WHERE (id LIKE '%"+bookinf+"%' " +
					"OR name LIKE '%"+bookinf+"%' "+
					"OR author LIKE '%"+bookinf+"%' "+
					"OR publisher LIKE '%"+bookinf+"%') ";
		}else{
			hql="FROM Book b WHERE (b.id LIKE '%"+bookinf+"%' " +
					"OR b.name LIKE '%"+bookinf+"%' "+
					"OR b.author LIKE '%"+bookinf+"%' "+
					"OR b.publisher LIKE '%"+bookinf+"%') AND b.type = booktype";
		}
		return bookdao.QueryBooks(hql);
	}

	@Override
	public List<Book> SearchBooks(String no, String name, String author) {
		// TODO Auto-generated method stub
		String hql="FROM Book b WHERE b.id LIKE '%"+no+"%' " +
				"AND b.name LIKE '%"+name+"%' "+
				"AND b.author LIKE '%"+author+"%' ";
		return bookdao.QueryBooks(hql);
	}

	@Override
	public Book SearchBook(String bookid) {
		// TODO Auto-generated method stub
		return bookdao.QueryBook(bookid);
	}

}
