package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import entity.Admin;

public class AdminDao {
	
	public Admin findAdmin(String aid){
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		Admin a = (Admin)session.get(Admin.class, aid);
		t.commit();
		session.close();
		return a;
	}

}
