package com.software_engineering.rgms;
import java.util.GregorianCalendar;
import java.util.*;

public class PatientMgr {
	
	protected HashMap <String, Patient>patients;
	
	public PatientMgr(){
		DatabaseMgr db = new DatabaseMgr();
		patients = new HashMap<String, Patient>();
		patients = db.getData(1, patients);
		Iterator<String> keySetIterator = patients.keySet().iterator();
		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  patients.get(key).apps = db.loadAppointments(key, patients.get(key).apps);
		}
	}
	
	public void createPatientAccount(String username, String name, String emailid,
			GregorianCalendar dob, String address, String phoneno,
			GregorianCalendar registerdate, int notifmethod){
		patients.put(username, new Patient(username, name, emailid,
				dob, address, phoneno, registerdate, notifmethod));
	}
	
	public void deletePatientAccount(String username){
		patients.remove(username);
	}
}
