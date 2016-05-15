package dao;

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
import entity.Book;
import dao.BookDao;

public class BorrowDao {
	
	

	public void AddBorrow(Borrow borrow) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		session.save(borrow);
		t.commit();
		session.close();

	}

	public void Back(int boid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Date today=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        String backTime = dateFormat.format(today);
        Borrow tmpBorrow=(Borrow)session.load(Borrow.class, boid);
		Transaction t = session.beginTransaction();
    	tmpBorrow.setBack_time(backTime);
        tmpBorrow.setIsback(1);
        session.update(tmpBorrow);
		t.commit(); 
		session.close();

	}

	public List<Borrow> BorrowList(String readerid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();	
		List <Borrow> borrowlist=new ArrayList<Borrow>();
		Query list=session.createSQLQuery("SELECT reader.rid, bid, book.name as bname, borrow_time, back_time, boid"+
		" FROM (borrow natural join book) join reader on(rid=readerid)"+
		" WHERE rid='"+readerid+"'"+ 
		" AND rid=readerid AND bid=bookid AND isback=0;").setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); 
		for(int i=0;i<list.list().size();i++){
			Borrow bo=new Borrow();
			Map map = (Map)list.list().get(i);
			bo.setReaderid(readerid);
			bo.setBookid((String)map.get("bid"));
			bo.setBorrow_time((String)map.get("borrow_time").toString());
			bo.setBack_time(map.get("back_time").toString());
			bo.setBookname((String)map.get("bname"));
			bo.setboid(Integer.parseInt(map.get("boid").toString()));
			borrowlist.add(bo);
		}
		t.commit(); 
		session.close();
		return borrowlist;
	}

	public String continueBorrow(String borrowTime, int boid)
			throws ParseException {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newdate=sdf.parse(borrowTime);
        Calendar cal=new GregorianCalendar();
        cal.setTime(newdate);
        cal.add(Calendar.DATE,30);	//Ðø½è30Ìì
        newdate=cal.getTime();
        String newbackTime=sdf.format(newdate);
		
		Transaction t = session.beginTransaction();
		Borrow tmpBorrow=(Borrow)session.load(Borrow.class, boid);
		tmpBorrow.setBack_time(newbackTime);
		t.commit(); 
		session.close();
		return newbackTime;
	}
	
	public boolean isAvailable(String bookid){
		Session session = HibernateUtil.openSession();
		BookDao bd = new BookDao();
		Transaction t = session.beginTransaction();
		String hql = "from Borrow b where b.bookid='"+bookid+"' and b.isback=0";
		List<Borrow> bor = session.createQuery(hql).list();
		t.commit();
		session.close();
		if(bor.size()!=0){
			return false; 
		}
		return true;
	}
	
	public int acquireboid(String bkid, String rdid){
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		int borrowid = 0;
		String hql = "from Borrow b where b.bookid='"+bkid+"' and b.readerid='"+rdid+"' and b.isback=0";
		List<Borrow> bor = session.createQuery(hql).list();
		t.commit();
		session.close();
		if(bor.size()!=0){
			borrowid = bor.get(0).getboid();
		}
		return borrowid;
	}

}
