package com.software_engineering.rgms;
import java.util.GregorianCalendar;

public class HumanActor {
	
	private String username;
	private String name;
	private String emailid;
	private GregorianCalendar dob;
	private String address;
	private String phoneno;
	private GregorianCalendar registerdate;

	public HumanActor(String username, String name, String emailid,
			GregorianCalendar dob, String address, String phoneno,
			GregorianCalendar registerdate){
		this.username = username;
		this.name = name;
		this.emailid = emailid;
		this.dob = dob;
		this.address = address;
		this.phoneno = phoneno;
		this.registerdate = registerdate;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getEmailId(){
		return emailid;
	}
	public void setEmailId(String emailid){
		this.emailid = emailid;
	}
	public GregorianCalendar getDOB(){
		return dob;
	}
	public void setDOB(GregorianCalendar DOB){
		this.dob=DOB;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getPhoneNo(){
		return phoneno;
	}
	public void setPhoneNo(String no){
		this.phoneno = no;
	}
	public GregorianCalendar getRegDate(){
		return registerdate;
	}
	public void setRegDate(GregorianCalendar registerdate){
		this.registerdate = registerdate;
	}
}
	
