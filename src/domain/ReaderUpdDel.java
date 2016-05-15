package domain;

import entity.Reader;

import dao.ReaderDao;

public class ReaderUpdDel {
	
	private ReaderDao readerdao = new ReaderDao();

	public void DeleteReader(String readerid) {
		// TODO Auto-generated method stub
		readerdao.DeleteReader(readerid);

	}

	public void UpdateReader(Reader reader) {
		// TODO Auto-generated method stub
		readerdao.UpdateReader(reader);

	}

}
