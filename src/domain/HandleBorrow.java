package domain;

import entity.Borrow;
import java.text.ParseException;
import java.util.List;

public interface HandleBorrow {
	public void Back(int tableid);
	public List<Borrow> borrowList(String readerid);
	public void BorrowOut(String bookid, String readerid);
	public String ContinueBorrow(String borrowTime, int tableid)throws ParseException;
	
}
