package com.software_engineering.rgms;
import java.util.GregorianCalendar;
public class Appointment {
	int appointmentid;
	boolean followup;
	GregorianCalendar datetime;
	String medicalpractice;
	String healthproblem;
	Patient patient;
	
	public Appointment(int appointmentid, boolean followup, GregorianCalendar datetime,
			String medicalpractice, String healthproblem, Patient patient) {
		this.appointmentid = appointmentid;
		this.followup = followup;
		this.datetime = datetime;
		this.medicalpractice = medicalpractice;
		this.healthproblem = healthproblem;
		this.patient = patient;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public boolean isFollowup() {
		return followup;
	}
	public void setFollowup(boolean followup) {
		this.followup = followup;
	}
	public String toStringDateTime() {
		return datetime.toString();
	}
	public void setDatetime(GregorianCalendar date) {
		this.datetime = date;
	}
	public String getMedicalpractice() {
		return medicalpractice;
	}
	public void setMedicalpractice(String medicalpractice) {
		this.medicalpractice = medicalpractice;
	}
	public String getHealthproblem() {
		return healthproblem;
	}
	public void setHealthproblem(String healthproblem) {
		this.healthproblem = healthproblem;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
