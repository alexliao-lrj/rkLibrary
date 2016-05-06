package dao;

import java.util.List;
import entity.Reader;

public interface ReaderDao {
	public void AddReader(Reader reader);
	public void DeleteReader(String readerid);
	public Reader QueryReader(String readerid);
	public List<Reader> QueryReaders(String readerid, String readername);
	public void UpdateReader(Reader reader);
}
