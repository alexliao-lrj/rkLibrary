package dao.impl;

import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import hibernate.HibernateUtil;

import dao.BorrowDao;
import entity.Borrow;

public class BorrowDaoImpl implements BorrowDao {
	
	Session session = HibernateUtil.openSession();

	@Override
	public void AddBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		session.save(borrow);
		t.commit();
		session.close();

	}

	@Override
	public void Back(int tableid) {
		// TODO Auto-generated method stub
		Date today=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        String backTime = dateFormat.format(today);
        Borrow tmpBorrow=(Borrow)session.load(Borrow.class, tableid);
		Transaction t = session.beginTransaction();
    	tmpBorrow.setBack_time(backTime);
        tmpBorrow.setIsback(1);
        session.update(tmpBorrow);
		t.commit(); 
		session.close();

	}

	@Override
	public List<Borrow> BorrowList(String readerid) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();	
		List <Borrow> borrowlist=new ArrayList<Borrow>();
		Query list=session.createSQLQuery("SELECT [reader].[id],[book].[id] as bid,[reader].[name],[book].[name] as bname,[borrow].[borrowTime],[book].[author],[back_time],[borrow].[id] as tid"+
		" FROM [dbo].[borrow],[dbo].[book],[dbo].[reader]"+
		"WHERE readerid='"+readerid+"'"+ 
		"AND [reader].[id]=[borrow].[readerid] AND [book].[id]=[borrow].[bookid] AND [borrow].[isback]='0'").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		for(int i=0;i<list.list().size();i++){
			Borrow bo=new Borrow();
			Map map = (Map)list.list().get(i);
			bo.setReaderid(readerid);
			bo.setBookid((String)map.get("bid"));
			bo.setBorrow_time((String)map.get("borrowTime").toString());
			bo.setBack_time(map.get("back_time").toString());
			bo.setBookname((String)map.get("bname"));
			bo.setId(Integer.parseInt(map.get("tid").toString()));
			borrowlist.add(bo);
		}
		t.commit(); 
		session.close();
		return borrowlist;
	}

	@Override
	public String continueBorrow(String borrowTime, int tableid)
			throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newdate=sdf.parse(borrowTime);
        Calendar cal=new GregorianCalendar();
        cal.setTime(newdate);
        cal.add(Calendar.DATE,30);	//Ðø½è30Ìì
        newdate=cal.getTime();
        String newbackTime=sdf.format(newdate);
		
		Transaction t = session.beginTransaction();
		Borrow tmpBorrow=(Borrow)session.load(Borrow.class, tableid);
		tmpBorrow.setBack_time(newbackTime);
		t.commit(); 
		session.close();
		return newbackTime;
	}

}
