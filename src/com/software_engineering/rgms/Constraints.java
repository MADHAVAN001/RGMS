package com.software_engineering.rgms;

public class Constraints {
	String name;
	String description;
	String doctorid;
	boolean completed;

	public void setname(String name) {
		this.name = name;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public void setdoctorid(String doctorid) {
		this.doctorid = doctorid;
	}

	public void setcompleted(boolean completed) {
		this.completed = completed;
	}

	public String getname() {
		return this.name;
	}

	public String getdescription() {
		return this.description;
	}

	public String getdoctorid() {
		return this.doctorid;
	}

	public boolean getcompleted() {
		return this.completed;
	}
}
