package domain.impl;

import java.util.List;

import domain.ReaderQuery;
import entity.Reader;

import dao.ReaderDao;
import dao.impl.ReaderDaoImpl;

public class ReaderQueryImpl implements ReaderQuery {
	
	private ReaderDao readerdao = new ReaderDaoImpl();

	@Override
	public boolean ifReaderExist(String readerid) {
		// TODO Auto-generated method stub
		Reader reader = readerdao.QueryReader(readerid);
		if(reader == null)
			return false;
		else
			return true;
	}

	@Override
	public List<Reader> QueryReaders(String readerid, String readername) {
		// TODO Auto-generated method stub
		return readerdao.QueryReaders(readerid, readername);
	}

	@Override
	public Reader QueryThisReader(String readerid) {
		// TODO Auto-generated method stub
		return readerdao.QueryReader(readerid);
	}

}
