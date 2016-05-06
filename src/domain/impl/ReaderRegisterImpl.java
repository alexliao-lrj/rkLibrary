package domain.impl;

import domain.ReaderRegister;
import entity.Reader;
import dao.ReaderDao;
import dao.impl.ReaderDaoImpl;

public class ReaderRegisterImpl implements ReaderRegister {
	
	private ReaderDao readerdao = new ReaderDaoImpl();

	@Override
	public void register(Reader reader) {
		// TODO Auto-generated method stub
		reader.setNumber(10);	//一个人10本
		readerdao.AddReader(reader);
	}

}
