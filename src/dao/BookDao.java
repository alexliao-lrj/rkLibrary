package dao;

import hibernate.HibernateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Book;

public class BookDao {
	
	public void AddBook(Book book) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		session.save(book);
		t.commit();
		session.close();
 
	}
	public void DelBooks(String id) throws SQLException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Book book = (Book)session.get(Book.class, id);
		session.delete(book);
		t.commit();
		session.close();
	}

	public Book QueryBook(String id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Book book = null;
		book = (Book)session.get(Book.class, id);
		t.commit();
		session.close();
		return book;
	}

	public List<Book> QueryBooks(String hql) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		List<Book> books = session.createQuery(hql).list();
		t.commit();
		session.close();
		return books;
	}

	public void UpdateBook(Book book) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Book tmpbook = (Book)session.load(Book.class, book.getbid());
		tmpbook.setauthor(book.getauthor());
		tmpbook.setpublisher(book.getpublisher());
		tmpbook.setisbn(book.getisbn());
		tmpbook.setedition(book.getedition());
		//tmpbook.setType(book.getType());
		tmpbook.setprice(book.getprice());
		tmpbook.setpage(book.getpage());
		tmpbook.settranslator(book.gettranslator());
		session.update(tmpbook);
		t.commit();
		session.close();

	}

	public Book BookInfo(String id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Book book = null;
		String hql="from Book book where book.bid=?";
		List<Book> books = session.createQuery(hql).setParameter(0, id).list();
		if(books.size() != 0){
			book=books.get(0);
		}
		t.commit();
		session.close();
		return book;
	}

}
