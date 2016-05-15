package entity;

public class Admin {
	private String aid;	//aid varchar(20)
	private String pwd; //password varchar(20)
	private String name;	//admin name varchar(20)
	
	public Admin(){}
	
	public String getaid(){
		return this.aid;
	}
	
	public String getpwd(){
		return this.pwd;
	}
	
	public String getname(){
		return this.name;
	}
	
	public void setaid(String id){
		this.aid=id;
	}
	
	public void setpwd(String password){
		this.pwd=password;
	}
	
	public void setname(String name){
		this.name=name;
	}
	
}
