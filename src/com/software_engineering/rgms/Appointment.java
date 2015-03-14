package com.software_engineering.rgms;
public class Appointment {
	
	int appointmentid;
	int type;
	int day;
	int timeslot;
	String healthprob;
	String place;
	String doctorname;
	
	public Appointment(int appointmentid, int type, int day, int timeslot,
			String healthproblem, String place, String doctorname){
		this.appointmentid = appointmentid;
		this.type = type;
		this.day = day;
		this.timeslot = timeslot;
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
	public int getDay(){
		return this.day;
	}
	public void setDay(int day){
		this.day = day;
	}
	public int getTimeSlot(){
		return timeslot;
	}
	public void setTimeSlot(int timeslot){
		this.timeslot = timeslot;
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
