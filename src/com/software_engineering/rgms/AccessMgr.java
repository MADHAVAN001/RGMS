package com.software_engineering.rgms;
import java.util.HashMap;
public class AccessMgr {
	
	HashMap<String, LoginData>login;
	public AccessMgr(){
		login = new HashMap<String,LoginData>();
	}
	public boolean createNewLogin(int usertype, String userid, String password){
		if(usertype>2 || login.get(userid) != null)
			return false;
		LoginData ld=new LoginData(usertype, userid, password);
		login.put(userid, ld);
		return true;
	}
	
	public boolean verify(int usertype, String userid, String password){
		if(login.get(userid).getUserid() == userid && login.get(userid).getPassword() == password && login.get(userid).getUserType() == usertype)
			return true;
		return false;
	}
	
	public boolean deleteLogin(int usertype, String userid, String password){
		if(usertype>2 || login.get(userid) == null)
			return false;
		if(login.get(userid).getPassword() != password)
			return false;
		login.remove(userid);
		return true;
	}
	
	public boolean changePassword(int usertype, String userid, String oldpassword, String newpassword){
		if(usertype>2 || login.get(userid) != null)
			return false;
		if(login.get(userid).getPassword() != oldpassword)
			return false;
		login.get(userid).setPassword(newpassword);
		return true;
	}
	
	public boolean changeUserID(int usertype, String olduserid, String newuserid, String password){
		if(usertype>2 || login.get(olduserid) == null)
			return false;
		if(login.get(olduserid).getPassword() != password)
			return false;
		login.get(olduserid).setUserid(newuserid);
		login.put(newuserid, login.get(olduserid));
		login.remove(olduserid);
		return true;
	}
}
