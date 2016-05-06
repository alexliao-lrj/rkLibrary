package entity;

public class Reader {
	public String ID; //reader id varchar(20)
	public String pwd; //password varchar(30)
	public String name; //reader name varchar(30)
	public int number; //how many books can r borrow
	//private String operator; //operator/admin string ID
	
	public Reader(){}
	
	public String getReaderId(){
		return this.ID;
	}
	
	public String getReaderPwd(){
		return this.pwd;
	}
	
	public String getReaderName(){
		return this.name;
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setReaderId(String id){
		this.ID=id;
	}
	
	public void setReaderPwd(String password){
		this.pwd=password;
	}
	
	public void setReaderName(String name){
		this.name=name;
	}
	
	public void setNumber(int num){
		this.number=num;
	}
	
	/*
	public String getOperator(){
		return operator;
	}
	public void setOperator(String operator){
		this.operator=operator;
	}
	*/
	
}
