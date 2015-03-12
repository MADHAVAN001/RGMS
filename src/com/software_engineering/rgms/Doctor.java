package com.software_engineering.rgms;

import java.util.GregorianCalendar;

public class Doctor extends HumanActor{
	
	String specialization;
	String practicelocation;
	int holidaysleft;
	
	public Doctor(String username, String name, String emailid,
			GregorianCalendar dob, String address, String phoneno,
			GregorianCalendar registerdate, String specialization,
			String practicelocation, int holidaysleft){
		super(username, name, emailid, dob, address, phoneno, registerdate);
		this.specialization = specialization;
		this.practicelocation = practicelocation;
		this.holidaysleft = holidaysleft;
	}
	public String getSpecialization(){
		return specialization;
	}
	public void setSpecialization(String specialization){
		this.specialization = specialization;
	}
	public String getPracticeLocation(){
		return practicelocation;
	}
	public void setPracticeLocation(String location){
		this.practicelocation = location;
	}
	public int getHolidaysLeft(){
		return holidaysleft;
	}
	public void setHolidaysLeft(int holidaysleft){
		this.holidaysleft = holidaysleft;
	}
}
