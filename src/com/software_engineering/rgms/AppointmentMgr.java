package com.software_engineering.rgms;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class AppointmentMgr {
	
	PatientMgr pm = new PatientMgr();
	HashMap <Integer, String>patientidmapper = new HashMap <Integer, String>();
	HashMap <Integer, String>doctoridmapper = new HashMap <Integer, String>();
	DatabaseMgr db = new DatabaseMgr();
	public AppointmentMgr(){
		
		patientidmapper = db.getData(3, patientidmapper);
		doctoridmapper = db.getData(4, doctoridmapper);
	}
	
	public void createAppointment(String patientname, int appointmentid,
			int type, GregorianCalendar datetime,
			String healthproblem, String place, String doctorname){
		(pm.patients.get(patientname)).addAppointment(appointmentid, 
					new Appointment(appointmentid, type, datetime,
					healthproblem, place, doctorname));			
		patientidmapper.put(appointmentid, patientname);
		doctoridmapper.put(appointmentid, doctorname);
		db.insertData(3, new Appointment(appointmentid, type, datetime,
					healthproblem, place, doctorname));
		db.insertData(appointmentid, patientname);
	}
	
	public void rescheduleAppointment(String patientname, int appointmentid, GregorianCalendar datetime){
		Appointment newApp = (pm.patients.get(patientname)).apps.get(appointmentid);
		newApp.setDatetime(datetime);
		(pm.patients.get(patientname)).apps.put(appointmentid, newApp);
		db.updateAppointment(appointmentid, datetime.toString());
	}
	
	public void cancelAppointment(String patientname, int appointmentid){
		pm.patients.get(patientname).apps.remove(appointmentid);
		patientidmapper.remove(appointmentid);
		doctoridmapper.remove(appointmentid);
		db.deleteRecord(3, appointmentid);
	}
	
	public HashMap<Integer, Appointment> getAppointments(String patientname){
		return pm.patients.get(patientname).getAppointments();
	}
}
