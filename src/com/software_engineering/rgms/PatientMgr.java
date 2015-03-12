package com.software_engineering.rgms;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class PatientMgr {
	
	protected HashMap <String, Patient>patients;
	
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
