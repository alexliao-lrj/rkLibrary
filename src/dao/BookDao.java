package dao;

import entity.Book;
import java.util.List;
import java.sql.SQLException;

public interface BookDao {
	public void AddBook(Book book);
	public void DelBooks(String hql)throws SQLException;
	public Book QueryBook(String id);
	public List<Book> QueryBooks(String hql);
	public void UpdateBook(Book book);
	public Book BookInfo(String id);

}
