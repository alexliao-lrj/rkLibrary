package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;


import entity.Borrow;

import dao.BorrowDao;

public class HandleBorrow {
	

	public void Back(int boid) {
		// TODO Auto-generated method stub
		BorrowDao borrowdao = new BorrowDao();
		borrowdao.Back(boid);
	}

	public List<Borrow> borrowList(String readerid) {
		// TODO Auto-generated method stub
		BorrowDao borrowdao = new BorrowDao();
		return borrowdao.BorrowList(readerid);
	}

	public void BorrowOut(String bookid, String readerid, String bookname) {
		// TODO Auto-generated method stub
		BorrowDao borrowdao = new BorrowDao();
		Date today = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
		String borrowTime = dateFormat.format(today);
		Calendar cal = new GregorianCalendar();
		cal.setTime(today);
		cal.add(Calendar.DATE, 30);
		Date backday=cal.getTime();
        String backTime=dateFormat.format(backday);
		Borrow borrow=new Borrow();
		borrow.setIsback(0);
		borrow.setReaderid(readerid);
		borrow.setBookid(bookid);
		borrow.setBookname(bookname);
		borrow.setBack_time(backTime);
		borrow.setBorrow_time(borrowTime);
		borrowdao.AddBorrow(borrow);

	}

	public String ContinueBorrow(String borrowTime, int boid)
			throws ParseException {
		// TODO Auto-generated method stub
		BorrowDao borrowdao = new BorrowDao();
		return borrowdao.continueBorrow(borrowTime, boid);
	}

}
