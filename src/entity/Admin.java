package entity;

public class Admin {
	private String ID;	//id varchar(20)
	private String pwd; //password varchar(30)
	private String name;	//admin name varchar(30)
	
	public Admin(){}
	
	public String getAdminId(){
		return this.ID;
	}
	
	public String getAdminPwd(){
		return this.pwd;
	}
	
	public String getAdminName(){
		return this.name;
	}
	
	public void setAdminId(String id){
		this.ID=id;
	}
	
	public void setAdminPwd(String password){
		this.pwd=password;
	}
	
	public void setAdminName(String name){
		this.name=name;
	}
	
}
