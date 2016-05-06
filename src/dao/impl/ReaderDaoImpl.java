package dao.impl;

import hibernate.HibernateUtil;
import java.util.Map;

import java.util.List;

import org.hibernate.Session;

import dao.ReaderDao;
import entity.Reader;

public class ReaderDaoImpl implements ReaderDao {
	
	Session session = HibernateUtil.openSession();

	@Override
	public void AddReader(Reader reader) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		session.save(reader);
		session.getTransaction().commit(); 
		session.close();

	}

	@Override
	public void DeleteReader(String readerid) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Reader reader=(Reader) session.load(Reader.class, readerid);
		session.delete(reader);
		session.getTransaction().commit(); 
		session.close();
	}

	@Override
	public Reader QueryReader(String readerid) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Reader reader=null;
		String hql="from Reader r where r.readerid = ?";
        List<Reader> readers=session.createQuery(hql).setParameter(0, readerid).list();
        if(readers.size()!=0){
        	reader=readers.get(0);
        }
		session.getTransaction().commit(); 
		session.close();
		return reader;
	}

	@Override
	public List<Reader> QueryReaders(String readerid, String readername) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		String hql="from Reader r where r.readerid like '%"+readerid+"%' and r.readername like '%"+readername+"%'"; 
		List<Reader> rList=session.createQuery(hql).list();
		session.getTransaction().commit(); 
		session.close();
		return rList;	
	}

	@Override
	public void UpdateReader(Reader reader) {
		// TODO Auto-generated method stub
		session.beginTransaction();
		Reader tmpReader = (Reader)session.load(Reader.class, reader.getReaderId());
		tmpReader.setReaderPwd(reader.getReaderPwd());
		session.update(tmpReader);
		session.getTransaction().commit(); 
		session.close();

	}

}
