package dao;

import java.util.Map;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.HibernateUtil;

import dao.ReaderDao;
import entity.Reader;

public class ReaderDao {
	
	//SessionFactory sessionFactory = 
	//	new Configuration().configure().buildSessionFactory(); 
	//Session session = HibernateUtil.openSession();
	//Session session = sessionFactory.openSession();
	//Session session;

	public void AddReader(Reader reader) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		session.save(reader);
		t.commit(); 
		session.close();

	}

	public void DeleteReader(String readerid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Reader reader=(Reader) session.load(Reader.class, readerid);
		session.delete(reader);
		t.commit(); 
		session.close();
	}

	public Reader QueryReader(String readerid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Reader reader = (Reader)session.get(Reader.class, readerid);
		t.commit();
		session.close();
		return reader;
	}

	public List<Reader> QueryReaders(String readerid, String readername) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		String hql="from Reader r where r.rid like '%"+readerid+"%' and r.name like '%"+readername+"%'"; 
		List<Reader> rList=session.createQuery(hql).list();
		t.commit(); 
		session.close();
		return rList;	
	}

	public void UpdateReader(Reader reader) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Reader tmpReader = (Reader)session.load(Reader.class, reader.getrid());
		tmpReader.setpwd(reader.getpwd());
		tmpReader.setname(reader.getname());
		session.update(tmpReader);
		t.commit(); 
		session.close();

	}

}
