package dao.impl;

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

import dao.BookDao;
import entity.Book;

public class BookDaoImpl implements BookDao {
	
	Session session = HibernateUtil.openSession();

	@Override
	public void AddBook(Book book) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.save(book);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void DelBooks(String id) throws SQLException {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Book book = (Book)session.get(Book.class, id);
		session.delete(book);
		session.getTransaction().commit();
		
	}

	@Override
	public Book QueryBook(String id) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Book book = null;
		String hql="from Book book where book.id=?";
		List<Book> books = session.createQuery(hql).setParameter(0, id).list();
		if(books.size() != 0){
			book=books.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return book;
	}

	@Override
	public List<Book> QueryBooks(String hql) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		List<Book> books = session.createQuery(hql).list();
		session.getTransaction().commit();
		session.close();
		return books;
	}

	@Override
	public void UpdateBook(Book book) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Book tmpbook = (Book)session.load(Book.class, book.getId());
		tmpbook.setAuthor(book.getAuthor());
		tmpbook.setPublisher(book.getPublisher());
		tmpbook.setIsbn(book.getIsbn());
		tmpbook.setEdition(book.getEdition());
		tmpbook.setType(book.getType());
		tmpbook.setPrice(book.getPrice());
		tmpbook.setPage(book.getPage());
		tmpbook.setOperator(book.getOperator());
		session.update(tmpbook);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Book BookInfo(String id) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Book book = null;
		String hql="from Book book where book.id=?";
		List<Book> books = session.createQuery(hql).setParameter(0, id).list();
		if(books.size() != 0){
			book=books.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return book;
	}

}
