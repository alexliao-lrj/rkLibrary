package entity;

public class Book {
	
	public String bid;//varchar(20) not null
	public int tid;
	public String name;//varchar(128)
	//public int type;
	public String isbn;//varchar(128)
	public int edition;//int
	public String author;//varchar(128)
	public String publisher;//varchar(128)
	public float price;//float 共6位，2位小数点 (6,2)
	public int page;//int
	public String translator;//varchar(128)
	public String operator;//varchar(20) admin.aid
	public String inTime;//varchar(128)
	
	public Book(){}
	
	public Book(int tid, String id, String name, 
			//int type, 
			String isbn, int edition, String author, String publisher, float price, 
			int page, String translator, String operator, String inTime){
		super();
		this.tid=tid;
		this.bid=id;
		this.name=name;
		//this.type=type;
		this.isbn=isbn;
		this.edition=edition;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		this.page=page;
		this.translator=translator;
		this.operator=operator;
		this.inTime=inTime;
	}
	
	public int gettid() {
		return tid;
	}
	public void settid(int tid) {
		this.tid = tid;
	}
	public String getbid() {
		return bid;
	}
	public void setbid(String id) {
		this.bid = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	/*
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	*/
	public String getauthor() {
		return author;
	}
	public void setauthor(String author) {
		this.author = author;
	}
	public String getisbn(){
		return isbn;
	}
	public void setisbn(String isbn){
		this.isbn=isbn;
	}
	public int getedition(){
		return edition;
	}
	public void setedition(int edition){
		this.edition=edition;
	}
	public int getpage(){
		return page;
	}
	public void setpage(int page){
		this.page=page;
	}
	public String getpublisher() {
		return publisher;
	}
	public void setpublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getinTime(){
		return inTime;
	}
	public void setinTime(String inTime){
		this.inTime=inTime;
	}
	public float getprice() {
		return price;
	}
	public void setprice(float price) {
		this.price = price;
	}
	public String gettranslator() {
		return translator;
	}
	public void settranslator(String translator) {
		this.translator = translator;
	}
	public String getoperator(){
		return operator;
	}
	public void setoperator(String operator){
		this.operator=operator;
	}
}
