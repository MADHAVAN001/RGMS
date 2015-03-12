package com.software_engineering.rgms;
import java.util.GregorianCalendar;
public class Appointment {
	
	int appointmentid;
	int type;
	GregorianCalendar datetime;
	String healthprob;
	String place;
	String doctorname;
	
	public Appointment(int appointmentid, int type, GregorianCalendar datetime,
			String healthproblem, String place, String doctorname){
		this.appointmentid = appointmentid;
		this.type = type;
		this.datetime = datetime;
		this.healthprob = healthproblem;
		this.place = place;
		this.doctorname = doctorname;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type = type;
	}
	public String getDateTime() {
		return datetime.toString();
	}
	public void setDatetime(GregorianCalendar date) {
		this.datetime = date;
	}
	public String getHealthProblem() {
		return healthprob;
	}
	public void setHealthProblem(String healthproblem) {
		this.healthprob = healthproblem;
	}
	public String getPlace(){
		return place;
	}
	public void setPlace(String place){
		this.place = place;
	}
	public String getDoctorUsername(){
		return doctorname;
	}
	public void setDoctorUsername(String doctorname){
		this.doctorname = doctorname;
	}
}
