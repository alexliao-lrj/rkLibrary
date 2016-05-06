package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateUtil;
import dao.AdminDao;
import entity.Admin;

public class AdminDaoImpl implements AdminDao {
	
	Session session = HibernateUtil.openSession();

	@Override
	public Admin Login(String aid, String pwd) {
		// TODO Auto-generated method stub
		Transaction t = session.beginTransaction();
		Admin admin = null;
		String hql="from Manager m where m.id = ?";
        List<Admin> admins=session.createQuery(hql).setParameter(0, aid).list();
        if(admins.size()!=0){
        	admin = admins.get(0);
        	if(admin.getAdminPwd().equals(pwd)){
        		return admin;
        	}
        }
		session.getTransaction().commit(); 
		session.close();
		return null;
	}

}
