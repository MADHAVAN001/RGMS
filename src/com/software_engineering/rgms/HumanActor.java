package com.software_engineering.rgms;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
public abstract class HumanActor {
	private int id;
	int num;
	private String name;
	private int age;
	private GregorianCalendar dateofbirth;
	private String address;
	private HashMap<Integer,Appointment> appointment ;
	public HumanActor(){
		
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public GregorianCalendar getDOB(){
		return dateofbirth;
	}
	public void setDOB(GregorianCalendar DOB){
		this.dateofbirth=DOB;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public Appointment getAppointment(int id){
		return appointment.get(id);
	}
	public void addAppointment(Appointment a){
		appointment.put(a.getAppointmentid(),a);
	}
	/*
	 * Patient only allowed to change date time or health condition
	 */
	public boolean changeAppointment(Appointment a, GregorianCalendar date, String healthprob){
		if(appointment.get(a.getAppointmentid()) == null)
			return false;
		a.setDatetime(date);
	    a.setHealthproblem(healthprob);
	    return true;
	}
	/*
	 * Assumption : Appointment IDs for blank appointments are set to 0
	 */
	public void deleteAppointment(Appointment a){
		appointment.remove(a.getAppointmentid());
	}
}
