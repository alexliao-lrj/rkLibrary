package dao;

import entity.Admin;

public interface AdminDao {
	public Admin Login(String aid, String pwd);
}
