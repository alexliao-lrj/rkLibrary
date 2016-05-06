package domain.impl;

import java.sql.SQLException;

import domain.BookAddUpdDel;
import entity.Book;

import dao.BookDao;
import dao.impl.BookDaoImpl;

public class BookAddUpdDelImpl implements BookAddUpdDel {
	
	BookDao bookdao = new BookDaoImpl();

	@Override
	public void AddBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.AddBook(book);

	}

	@Override
	public void DeleteBook(String dellists) throws SQLException {
		// TODO Auto-generated method stub
		String[] dellist = dellists.split(",");
		String hql = "delete from Book where id in (";
		for(int i=0; i<dellist.length; i++){
			if(i<dellist.length-1)
				hql+="'"+dellist[i]+"',";
			else
				hql+="'"+dellist[i]+"')";
		}
		bookdao.DelBooks(hql);

	}

	@Override
	public void UpdateBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.UpdateBook(book);

	}

}
