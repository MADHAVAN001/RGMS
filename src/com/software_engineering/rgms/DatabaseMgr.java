package com.software_engineering.rgms;
import java.sql.*;
import java.util.*;

public class DatabaseMgr {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://rgms.ceu7pkexqrb8."+
	"ap-southeast-1.rds.amazonaws.com:3306/innodb";
	static final String USER = "rgms";
	static final String PASS = "rgms2006";
	private Connection conn = null;
	private Statement stmt = null;
	ResultSet rs = null;
	String sql;
	
	public DatabaseMgr(){
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 *  Function to load data from database to hashmap assigned
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashMap getData(int choice, @SuppressWarnings("rawtypes") HashMap h){
		try{
			switch(choice){
			case 1:
				sql = "SELECT USERNAME, NAME, EMAILID, DOB, ADDRESS,"
						+ " PHONE,REGISTERDATE, NOTIFMETHOD FROM PATIENT";
			    rs = stmt.executeQuery(sql);
			    while(rs.next()){
			    	String username = rs.getString("USERNAME");
					String name = rs.getString("NAME");
					String emailid = rs.getString("EMAILID");
					GregorianCalendar dob = rs.getString("DOB");
					String address = rs.getString("ADDRESS");
					String phoneno = rs.getString("PHONE");
					GregorianCalendar registerdate = rs.getString("REGISTERDATE");
					int notifmethod = rs.getInt("NOTIFMETHOD");
					h.put(username, new Patient(username, name, emailid,
				dob, address, phoneno, registerdate, notifmethod));
			    }
			    return h;
			    break;
			case 2: 
				sql = "SELECT USERNAME, NAME, EMAILID, DOB, ADDRESS," + 
			"PHONE,REGISTERDATE, SPECIALIZATION, PRACTICELOCATION, HOLIDAYSLEFT "
			+ "FROM DOCTOR";	
			    rs = stmt.executeQuery(sql);
			    while(rs.next()){
			    	String username = rs.getString("USERNAME");
					String name = rs.getString("NAME");
					String emailid = rs.getString("EMAILID");
					GregorianCalendar dob = rs.getString("DOB");
					String address = rs.getString("ADDRESS");
					String phoneno = rs.getString("PHONE");
					GregorianCalendar registerdate = rs.getString("REGISTERDATE");
					String specialization = rs.getString("SPECIALIZATION");
					String practicelocation = rs.getString("PRACTICELOCATION");
					int holidaysleft = rs.getInt(holidaysleft);
					h.put(username, new Doctor(username, name, emailid,
				dob, address, phoneno, registerdate, specialization,
				practicelocation, holidaysleft));
			    }
			    return h;
			    break;
			case 3:
				sql = "SELECT APPOINTMENTID, PATIENTNAME FROM APPOINTMENT";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					int appointmentid = rs.getInt("APPOINTMENTID");
					String patientname = rs.getString("PATIENTNAME");
					h.put(appointmentid, patientname);
				}
				return h;
				break;
			case 4:
				sql = "SELECT APPOINTMENTID, DOCTORNAME FROM APPOINTMENT";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					int appointmentid = rs.getInt("APPOINTMENTID");
					String doctorname = rs.getString("DOCTORNAME");
					h.put(appointmentid, doctorname);
				}
				return h;
				break;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	public HashMap<Integer, Appointment> loadAppointments(String patientname,
			HashMap<Integer, Appointment>h){
		sql = "SELECT APPOINTMENTID, TYPE, DATETIME, "
				+ "HEALTHPROBLEM, PLACE, DOCTORNAME FROM APPOINTMENT "
				+ "WHERE PATIENTNAME = \'"+patientname+"\'";
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			int appointmentid = rs.getInt("APPOINTMENTID");
			int type = rs.getInt("TYPE");
			GregorianCalendar datetime = rs.getString("DATETIME");
			String healthproblem = rs.getString("HEALTHPROBLEM");
			String place = rs.getString("PLACE");
			String doctorname = rs.getString("DOCTORNAME");
			h.put(appointmentid, new Appointment(appointmentid, type, datetime,
					healthproblem, place, doctorname));
	}
		return h;
	}
	
	public void insertData(int choice, Object o){
		try{
			switch(choice){
			case 1:
				Patient p = (Patient)o;
				sql = "INSERT INTO PATIENT"
						+ "VALUES(\'"+ p.getUsername()+ "\',\'" + p.getName()
						+"\',\'" + p.getEmailId() + "\',\'" + p.getDOB().toString()
						+"\',\'" + p.getAddress() + "\',\'" + p.getPhoneNo()
						+"\',\'" + p.getRegDate().toString() + "\',\'" + 
						p.getNotifMethod() + "\')";
				stmt.executeUpdate(sql);
				break;
			case 2:
				Doctor d = (Doctor)o;
				sql = "INSERT INTO DOCTOR"
						+ "VALUES(\'"+ d.getUsername()+ "\',\'" + d.getName()
						+"\',\'" + d.getEmailId() + "\',\'" + d.getDOB().toString()
						+"\',\'" + d.getAddress() + "\',\'" + d.getPhoneNo()
						+"\',\'" + d.getRegDate().toString() + "\',\'" +
						d.getSpecialization() + "\',\'" + d.getPracticeLocation()
						+ "\',\'" + d.getHolidaysLeft() + "\')";
				stmt.executeUpdate(sql);
				break;
			case 3:
				Appointment a = (Appointment)o;
				sql = "INSERT INTO APPOINTMENT(APPOINTMENTID, TYPE, "
						+ "DATETIME, HEALTHPROBLEM, PLACE, DOCTORNAME)"
						+ "VALUES(\'" + a.getAppointmentid() + "\',\'" +
						a.getType() + "\',\'" + a.getDateTime() + "\',\'" +
						a.getHealthProblem() + "\',\'" + a.getPlace() + 
						"\',\'" + a.getDoctorUsername() + "\')";
				stmt.executeUpdate(sql);
				break;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

	public void insertData(int appointmentid, String patientname) {
		try {
			sql = "UPDATE APPOINTMENT"
					+ "SET PATIENTNAME = \'" + patientname + "\'"
					+ " WHERE APPOINTMENT ID = " + appointmentid;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	
	public void updateAppointment(int appointmentid, String datetime){
		try{
			sql = "UPDATE APPOINTMENT"
					+ "SET DATETIME = \'" + datetime + "\'"
					+ " WHERE APPOINTMENT ID = " + appointmentid;
			stmt.executeUpdate(sql);
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

	public void deleteRecord(int choice, String name) {
		try {
			switch (choice) {
			case 1:
				sql = "DELETE FROM PATIENT WHERE USERNAME = \'" + name + "\'";
				stmt.executeUpdate(sql);
				break;
			case 2:
				sql = "DELETE FROM DOCTOR WHERE USERNAME = \'" + name + "\'";
				stmt.executeUpdate(sql);
				break;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void updatebill(int id, HealthAnalysis app) {
		try {

			sql = "UPDATE HEALTHANALYSIS SET BILL = " + app.getbill()
					+ " WHERE HEALTHANALYSISID = " + id;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void updatereferral(int id, Referral ref) {
		try {

			sql = "UPDATE REFERRAL SET DOCTORID1 = " + "/'" + ref.getdoctorid1()
					+ "/'" + " ,DOCTORID2 = " + "/'" + ref.getdoctorid2() + "/'"
					+ " ,PATIENTID = " + "/'" + ref.getpatientid() + "/'"
					+ ", COMMENTS = " + "/'" + ref.getcomments() + "/'"
					+ " WHERE REFERRALID = " + id;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void updatesurgery(int id, Surgery surg) {
		try {

			sql = "UPDATE SURGERY SET NAME = "+"/'" + surg.getname() + "/'"+" , COMMENTS = "+"/'" + surg.getcomments() + "/'"+" WHERE HEALTHANALYSISID = "+id;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void updatebillpaid(int id, HealthAnalysis app) {
		try {

			sql = "UPDATE HEALTHANALYSIS SET BILLPAID = " + app.getbillpaid()
					+ " WHERE HEALTHANALYSISID = " + id;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public void addHealthAnalysis(String patientid, HealthAnalysis app) {
		try {
			
			sql = "INSERT INTO HEALTHANALYSIS VALUES("+"/'" + patientid + "/'"+", "+app.gethealthanalysisid()+","+"/'" + app.getdiagnosis() + "/'"+", "+"/'" + app.getsuggestion() + "/'"+", "+"/'" + app.getdatetime() + "/'"+", "+app.getbill()+","+"/'" + app.getbillpaid() + "/'"+","+"/'" + app.gettitle() + "/'"+", "+"/'" + app.getprescribefollowup()+ "/'"+")";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public void addMedicines(int id, Medicines med) {
		try {
			
			sql = "INSERT INTO MEDICINES VALUES("+id+","+"/'" + med.getname() + "/'"+", "+med.getquatity()[0]+", "+med.getquatity()[1]+", "+med.getquatity()[2]+","+"/'" + med.getdescription() + "/'"+", "+med.getintakecon()[0]+", "+med.getintakecon()[1]+", "+med.getintakecon()[2]+")";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public void addSurgery(int id, Surgery surg) {
		try {
			
			sql = "INSERT INTO SURGERY VALUES("+id+", "+"/'" + surg.getname() + "/'"+", "+"/'" + surg.getcomments() + "/'"+")";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public void addReferral(int id, Referral ref) {
		try {
			
			sql = "INSERT INTO REFERRAL VALUES("+id+", "+"/'" + ref.getdoctorid1() + "/'"+", "+"/'" + ref.getdoctorid2() + "/'"+"/'" + ref.getpatientid() + "/'"+"/'" + ref.getcomments() + "/'"+")";
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public void deletereferral(int id) {
		try {
			sql = "DELETE FROM REFERRAL WHERE REFERRALID = "+id;
			stmt.executeUpdate(sql);
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}
	public void deleteRecord(int choice, int appointmentid) {
		try {
			if (choice == 3) {
				sql = "DELETE FROM APPOINTMENT WHERE APPOINTMENTID = "
						+ appointmentid ;
				stmt.executeUpdate(sql);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
