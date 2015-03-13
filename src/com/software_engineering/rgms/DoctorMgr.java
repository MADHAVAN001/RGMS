package com.software_engineering.rgms;
import java.util.*;

public class DoctorMgr {
	
	HashMap <String, Doctor>doctors = new HashMap <String, Doctor>();
	DatabaseMgr db = new DatabaseMgr();
	public DoctorMgr(){
		
		doctors = db.getData(2, doctors);
	}
	public void createDoctorAccount(String username, String name, String emailid,
			GregorianCalendar dob, String address, String phoneno,
			GregorianCalendar registerdate, String specialization,
			String practicelocation, int holidaysleft){
		doctors.put(username, new Doctor(username, name, emailid,
				dob, address, phoneno, registerdate, specialization,
				practicelocation, holidaysleft));
		db.insertData(2, new Doctor(username, name, emailid,
				dob, address, phoneno, registerdate, specialization,
				practicelocation, holidaysleft));
	}
	public void deleteDoctorAccount(String username){
		doctors.remove(username);
		db.deleteRecord(2, username);
	}
	public boolean applyForLeave(String username, int days){
		int holidaysleft = doctors.get(username).getHolidaysLeft();
		if(days <= holidaysleft){
			doctors.get(username).setHolidaysLeft(holidaysleft - days);
		}
		return false;
	}
}
