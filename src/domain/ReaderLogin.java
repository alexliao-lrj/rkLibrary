package domain;

import entity.Reader;
import dao.ReaderDao;

public class ReaderLogin {
	
	public ReaderDao readerdao = new ReaderDao();

	public boolean login(Reader reader) {
		// TODO Auto-generated method stub
		if(reader.getrid()==null) return false;
		Reader tmpReader=readerdao.QueryReader(reader.getrid());
		if(tmpReader!=null && reader.getpwd().equals(tmpReader.getpwd())){
			reader.setrid(reader.getrid());
			return true;
		}
		return false;
	}

}
