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
				sql = "SELECT USERNAME, NAME, EMAILID, DOB, ADDRESS, PHONE,REGISTERDATE, NOTIFMETHOD FROM PATIENT";
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
			/*case 3:
				sql = "SELECT APPOINTMENTID, TYPE, DATETIME, "
						+ "HEALTHPROBLEM, PLACE, DOCTORNAME FROM APPOINTMENT "
						+ "WHERE PATIENTNAME = ";
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
				*/
			case 4:
				sql = "SELECT APPOINTMENTID, PATIENTNAME FROM APPOINTMENT";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					int appointmentid = rs.getInt("APPOINTMENTID");
					String patientname = rs.getString("PATIENTNAME");
					h.put(appointmentid, patientname);
				}
				return h;
			case 5:
				sql = "SELECT APPOINTMENTID, DOCTORNAME FROM APPOINTMENT";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					int appointmentid = rs.getInt("APPOINTMENTID");
					String doctorname = rs.getString("DOCTORNAME");
					h.put(appointmentid, doctorname);
				}
				return h;
			}
		}catch(SQLException se){
			se.printStackTrace();
		}
	}

}
