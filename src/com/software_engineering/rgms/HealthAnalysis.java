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
	Referral suggestedReferral;
	Surgery suggestedSurgery;
	Medicines suggestedMedicines[];
	int numMedicines = 0;
	public HealthAnalysis(int healthAnalysisid, String diagnosis, GregorianCalendar datetime, float bill, String suggestion, boolean billpaid,String title, String precribefollowup)
	{
		this.setbill(bill);
		this.setbillpaid(billpaid);;
		this.setdiagnosis(diagnosis);
		this.sethealthanalysisid(healthAnalysisid);
		this.setprescribefollowup(precribefollowup);
		this.settitle(title);
		this.setdatetime(datetime);
	}
	public void setdiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public void setdatetime(GregorianCalendar datetime)
	{
		this.datetime = datetime;
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

	public void setsuggestedreferral(int referralid,String patientid,String doctorid1,String doctorid2, String comments)
	{
		suggestedReferral.setpatientid(patientid);
		suggestedReferral.setdoctorid1(doctorid1);
		suggestedReferral.setdoctorid2(doctorid2);
		suggestedReferral.setcomments(comments);
		suggestedReferral.setreferralid(healthAnalysisid);
	}
	public void setsuggestedSurgery(String name, String comments)
	{
		suggestedSurgery.setcomments(comments);
		suggestedSurgery.setname(name);
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
	public Referral getsuggestedreferral(){
		return this.suggestedReferral;
	}
	public Surgery getsuggestedsurgery(){
		return this.suggestedSurgery;
	}
	public void addMedicines(Medicines medicine)
	{
		suggestedMedicines[numMedicines++] = medicine;
	}
}
