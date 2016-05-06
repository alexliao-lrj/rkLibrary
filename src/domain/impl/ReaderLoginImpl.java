package domain.impl;

import domain.ReaderLogin;
import entity.Reader;
import dao.ReaderDao;
import dao.impl.ReaderDaoImpl;

public class ReaderLoginImpl implements ReaderLogin {
	
	private ReaderDao readerdao = new ReaderDaoImpl();

	@Override
	public boolean login(Reader reader) {
		// TODO Auto-generated method stub
		Reader tmpReader=readerdao.QueryReader(reader.getReaderId());
		if(tmpReader!=null && reader.getReaderPwd().equals(tmpReader.getReaderPwd())){
			reader.setReaderId(reader.getReaderId());
			return true;
		}
		return false;
	}

}
