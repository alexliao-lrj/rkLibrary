package domain.impl;

import domain.ReaderUpdDel;
import entity.Reader;

import dao.ReaderDao;
import dao.impl.ReaderDaoImpl;

public class ReaderUpdDelImpl implements ReaderUpdDel {
	
	private ReaderDao readerdao = new ReaderDaoImpl();

	@Override
	public void DeleteReader(String readerid) {
		// TODO Auto-generated method stub
		readerdao.DeleteReader(readerid);

	}

	@Override
	public void UpdateReader(Reader reader) {
		// TODO Auto-generated method stub
		readerdao.UpdateReader(reader);

	}

}
