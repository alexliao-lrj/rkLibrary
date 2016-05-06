package entity;

public class Book {
	public int tid;
	public String id;
	public String name;
	public int type;
	public String isbn;
	public int edition;
	public String author;
	public String publisher;
	public float price;
	public int page;
	public String translator;
	public String operator;
	public String inTime;
	
	public Book(){}
	
	public Book(int tid, String id, String name, int type, String isbn, 
			int edition, String author, String publisher, float price, 
			int page, String translator, String operator, String inTime){
		super();
		this.tid=tid;
		this.id=id;
		this.name=name;
		this.type=type;
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
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn(){
		return isbn;
	}
	public void setIsbn(String isbn){
		this.isbn=isbn;
	}
	public int getEdition(){
		return edition;
	}
	public void setEdition(int edition){
		this.edition=edition;
	}
	public int getPage(){
		return page;
	}
	public void setPage(int page){
		this.page=page;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getInTime(){
		return inTime;
	}
	public void setInTime(String inTime){
		this.inTime=inTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getOperator(){
		return operator;
	}
	public void setOperator(String operator){
		this.operator=operator;
	}
}
