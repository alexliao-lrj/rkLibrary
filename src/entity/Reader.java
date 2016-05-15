package entity;

public class Reader {
	public String rid; //reader id varchar(20)
	public String pwd; //password varchar(30)
	public String name; //reader name varchar(30)
	public int number; //how many books can r borrow
	//private String operator; //operator/admin string ID
	
	public Reader(){}
	
	public String getrid(){
		return rid;
	}
	
	public String getpwd(){
		return pwd;
	}
	
	public String getname(){
		return name;
	}
	
	public int getnumber(){
		return number;
	}
	
	public void setrid(String id){
		this.rid=id;
	}
	
	public void setpwd(String password){
		this.pwd=password;
	}
	
	public void setname(String name){
		this.name=name;
	}
	
	public void setnumber(int num){
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
