package com.software_engineering.rgms;
import java.util.GregorianCalendar;

public class Patient extends HumanActor{
	GregorianCalendar registerdate;
	float billdue;
	public Patient(){
		
	}
	public GregorianCalendar getDate(){
		return registerdate;
	}
	public void setDate(GregorianCalendar date){
		this.registerdate = date;
	}
	public float getBillDue(){
		return billdue;
	}
	public void setBillDue(int amt){
		this.billdue = amt;
	}
}
