package com.software_engineering.rgms;

public class LoginData {
	int usertype;
	String userid;
	String password;
	
	
	public LoginData(int usertype, String userid,String password){
		this.usertype = usertype;
		this.userid = userid;
		this.password = password;
		
	}
	public LoginData(String usertype, String userid,String password){
		if(!this.setUserType(usertype)){
			this.usertype = 3;
		}
		this.userid = userid;
		this.password = password;
		
	}
	public int getUserType() {
		return usertype;
	}

	public String toStringUserType(){
		if(usertype == 0)
			return "Patient";
		else if(usertype == 1)
			return "Doctor";
		else if(usertype == 2)
			return "Administrator";
		return "Others";
	}
	public boolean setUserType(String user){
		if(user.toLowerCase() == "administrator"){
			usertype = 2;
			return true;}
		else if(user.toLowerCase() == "doctor"){
			usertype = 1;
			return true;}
		else if(user.toLowerCase() == "patient")
			{usertype = 0;
			return true;
			}
		return false;
		
	}
	public boolean checkPassword(String pwd){
		if(pwd == password)return true;
		return false;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
