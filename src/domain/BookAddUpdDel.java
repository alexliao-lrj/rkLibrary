package domain;

import java.sql.SQLException;

import entity.Book;

import dao.BookDao;
import dao.BookDao;

public class BookAddUpdDel {
	
	BookDao bookdao = new BookDao();

	public void AddBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.AddBook(book);

	}

	public void DeleteBook(String dellists) throws SQLException {
		// TODO Auto-generated method stub
		String[] dellist = dellists.split(",");
		String hql = "delete from Book where bid in (";
		for(int i=0; i<dellist.length; i++){
			if(i<dellist.length-1)
				hql+="'"+dellist[i]+"',";
			else
				hql+="'"+dellist[i]+"')";
		}
		bookdao.DelBooks(hql);

	}

	public void UpdateBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.UpdateBook(book);

	}

}
