package domain;

import hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Admin;
import dao.AdminDao;

public class AdminLogin {
	public boolean Login(Admin admin) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSession();
		Transaction t = session.beginTransaction();
		AdminDao dao = new AdminDao();
		Admin a = dao.findAdmin(admin.getaid());
		if(a != null && admin.getpwd().equals(a.getpwd())){
			admin.setaid(admin.getaid());
			admin.setname(a.getname());
			return true;
		}
		t.commit(); 
		session.close();
		return false; 
	}
}
