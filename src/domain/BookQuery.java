package domain;

import java.util.List;
import entity.Book;

public interface BookQuery {
	public List<Book> QueryBooks(String bookinf, int booktype);//读者使用查询功能（模糊查询）
	public List<Book> SearchBooks(String no, String name, String author);//管理员使用查询
	public Book SearchBook(String bookid);

}
