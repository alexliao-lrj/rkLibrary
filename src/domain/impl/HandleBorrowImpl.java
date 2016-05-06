package domain.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;


import domain.HandleBorrow;
import entity.Borrow;

import dao.BorrowDao;
import dao.impl.BorrowDaoImpl;

public class HandleBorrowImpl implements HandleBorrow {
	
	BorrowDao borrowdao = new BorrowDaoImpl();

	@Override
	public void Back(int tableid) {
		// TODO Auto-generated method stub
		borrowdao.Back(tableid);
	}

	@Override
	public List<Borrow> borrowList(String readerid) {
		// TODO Auto-generated method stub
		return borrowdao.BorrowList(readerid);
	}

	@Override
	public void BorrowOut(String bookid, String readerid) {
		// TODO Auto-generated method stub
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
		borrow.setBack_time(backTime);
		borrow.setBorrow_time(borrowTime);
		borrowdao.AddBorrow(borrow);

	}

	@Override
	public String ContinueBorrow(String borrowTime, int tableid)
			throws ParseException {
		// TODO Auto-generated method stub
		return borrowdao.continueBorrow(borrowTime, tableid);
	}

}
