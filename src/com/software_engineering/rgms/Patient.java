package com.software_engineering.rgms;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class Patient extends HumanActor{
	
	int notifmethod;
	protected HashMap <Integer, Appointment> apps = new HashMap<Integer,Appointment>();
	
	public Patient(String username, String name, String emailid,
			GregorianCalendar dob, String address, String phoneno,
			GregorianCalendar registerdate, int notifmethod){
		super(username, name, emailid, dob, address, phoneno, registerdate);
		this.notifmethod = notifmethod;
	}
	public int getNotifMethod(){
		return notifmethod;
	}
	public void setNotifMethod(int notifmethod){
		this.notifmethod = notifmethod;
	}
	public HashMap<Integer,Appointment> getAppointments(){
		return apps;
	}
	public void addAppointment(int id, Appointment a){
		apps.put(id, a);
	}
}
