package domain;

import java.util.List;

import entity.Reader;

import dao.ReaderDao;


public class ReaderQuery {
	
	private ReaderDao readerdao = new ReaderDao();

	public boolean ifReaderExist(String readerid) {
		// TODO Auto-generated method stub
		Reader reader = readerdao.QueryReader(readerid);
		if(reader == null)
			return false;
		else
			return true;
	}

	public List<Reader> QueryReaders(String readerid, String readername) {
		// TODO Auto-generated method stub
		return readerdao.QueryReaders(readerid, readername);
	}

	public Reader QueryThisReader(String readerid) {
		// TODO Auto-generated method stub
		return readerdao.QueryReader(readerid);
	}

}
