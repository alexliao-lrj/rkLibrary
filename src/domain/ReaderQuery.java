package domain;

import entity.Reader;
import java.util.List;

public interface ReaderQuery {

	public boolean ifReaderExist(String readerid);
	public List<Reader> QueryReaders(String readerid, String readername);
	public Reader QueryThisReader(String readerid);
	
}
