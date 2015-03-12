package com.software_engineering.rgms;

public class Medicines {
	int[] quantity;
	String name;
	String description;
	int[] intakecon;
	public void setquantity(int quantity[])
	{
		this.quantity = quantity;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public void setdescription(String description)
	{
		this.description = description;
	}
	public void set(int intakecon[])
	{
		this.intakecon = intakecon;
	}
	public String getname()
	{
		return name;
	}
	public int[] getquatity()
	{
	return quantity;	
	}
	public int[] getintakecon()
	{
		return intakecon;
	}
	public String getdescription()
	{
		return description;
	}
}
