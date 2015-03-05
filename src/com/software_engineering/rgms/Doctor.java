package com.software_engineering.rgms;

public class Doctor extends HumanActor{
	String specialization;
	String location;
	public Doctor(){
		
	}
	public String getSpecialization(){
		return specialization;
	}
	public void setSpecialization(String specialization){
		this.specialization = specialization;
	}
	public String getLocation(){
		return location;
	}
	public void setLocation(String location){
		this.location = location;
	}
}
