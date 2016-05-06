package domain;

import java.util.List;
import entity.Book;

public interface BookQuery {
	public List<Book> QueryBooks(String bookinf, int booktype);//����ʹ�ò�ѯ���ܣ�ģ����ѯ��
	public List<Book> SearchBooks(String no, String name, String author);//����Աʹ�ò�ѯ
	public Book SearchBook(String bookid);

}
