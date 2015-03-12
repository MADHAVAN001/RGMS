package com.software_engineering.rgms;

import java.util.GregorianCalendar;

public class HealthAnalysis {
	String diagnosis;
	GregorianCalendar datetime;
	float bill;
	String suggestion;
	int healthAnalysisid;
	boolean billpaid;
	String title;
	String prescribefollowup;

	public void setdiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public void setbill(float bill) {
		this.bill = bill;
	}

	public void setsuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public void sethealthanalysisid(int healthanalysisid) {
		this.healthAnalysisid = healthanalysisid;
	}

	public void setbillpaid(boolean billpaid) {
		this.billpaid = billpaid;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public void setprescribefollowup(String prescribefollowup) {
		this.prescribefollowup = prescribefollowup;
	}

	public String getdiagnosis() {
		return this.diagnosis;
	}

	public GregorianCalendar getdatetime() {
		return this.datetime;
	}

	public float getbill() {
		return this.bill;
	}

	public String getsuggestion() {
		return this.suggestion;
	}

	public int gethealthanalysisid() {
		return this.healthAnalysisid;
	}

	public boolean getbillpaid() {
		return this.billpaid;
	}

	public String gettitle() {
		return this.title;
	}

	public String getprescribefollowup() {
		return this.prescribefollowup;
	}
}
