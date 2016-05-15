package entity;

public class Borrow {
	public int boid;
	public String bookid;
	public String bookname;
	public String readerid;
	public String borrow_time;
	public String back_time;
	//public String operator;
	public int isback;
	
	public int getIsback() {
		return isback;
	}
	public void setIsback(int isBack) {
		isback = isBack;
	}
	
	public int getboid() {
		return boid;
	}
	public void setboid(int id) {
		this.boid = id;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getReaderid() {
		return readerid;
	}
	public void setReaderid(String readerid) {
		this.readerid = readerid;
	}
	public String getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(String borrowTime) {
		borrow_time = borrowTime;
	}
	public String getBack_time() {
		return back_time;
	}
	public void setBack_time(String backTime) {
		back_time = backTime;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/*
	public String getOperator(){
		return operator;
	}
	public void setOperator(String op){
		operator=op;
	}
	*/

}
