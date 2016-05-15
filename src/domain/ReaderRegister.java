package domain;

import entity.Reader;
import dao.ReaderDao;

public class ReaderRegister {
	
	private ReaderDao readerdao = new ReaderDao();

	public void register(Reader reader) {
		// TODO Auto-generated method stub
		readerdao.AddReader(reader);
	}

}
