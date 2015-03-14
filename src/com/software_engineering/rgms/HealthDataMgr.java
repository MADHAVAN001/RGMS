package com.software_engineering.rgms;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class HealthDataMgr {
	HashMap<Integer,HealthAnalysis> HealthAnalysisDetails;
	HashMap<Integer,String> idMapper;
	public void updateHealthAnalysis(int healthAnalysisid, String patientid, String diagnosis, GregorianCalendar datetime, float bill, String suggestion, boolean billpaid,String title, String prescribefollowup)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.setbill(bill);
		temp.setbillpaid(billpaid);
		temp.setdatetime(datetime);
		temp.setdiagnosis(diagnosis);
		temp.setprescribefollowup(prescribefollowup);
		temp.setsuggestion(suggestion);
		temp.settitle(title);
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
	}
	public void updatebill(int healthAnalysisid,float bill)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.setbill(bill);
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.updatebill(healthAnalysisid,temp);
	}
	public void updatebillpaid(int healthAnalysisid, boolean billpaid)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.setbillpaid(billpaid);
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.updatebillpaid(healthAnalysisid,temp);
	}
	public void updatereferral(int healthAnalysisid, Referral updatedreferral)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.suggestedReferral = updatedreferral;
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.updatereferral(healthAnalysisid,updatedreferral);
	}
	public void updatesurgery(int healthAnalysisid, Surgery updatedsurgery)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.suggestedSurgery = updatedsurgery;
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.updatesurgery(healthAnalysisid,updatedsurgery);
	}
	public HealthAnalysis getHealthAnalysis(int healthAnalysisid)
	{
		return HealthAnalysisDetails.get(healthAnalysisid);
	}
	public HealthAnalysis[] getTreatmentHistory(String patientid)
	{
		HealthAnalysis temp[] = new HealthAnalysis[20];
		int variable = 0;
		for(int i = 0;i<idMapper.size();i++)
		{
			if(idMapper.get(i) == patientid)
			{
				temp[variable++] = HealthAnalysisDetails.get(i);
			}
		}
		return temp;
	}
	public Referral retrievereferral(int healthAnalysisid)
	{
		return HealthAnalysisDetails.get(healthAnalysisid).getsuggestedreferral();
	}
	public Surgery getSurgery(int healthAnalysisid){
		return HealthAnalysisDetails.get(healthAnalysisid).getsuggestedsurgery();
	}
	public void addHealthAnalysis(String patientid, String diagnosis, GregorianCalendar datetime, float bill, String suggestion, boolean billpaid,String title, String prescribefollowup)
	{
		int healthAnalysisid = HealthAnalysisDetails.size()+1;
		HealthAnalysis temp = new HealthAnalysis(healthAnalysisid,diagnosis,datetime,bill,suggestion,billpaid,title,prescribefollowup);
		HealthAnalysisDetails.put(healthAnalysisid, temp);
		idMapper.put(healthAnalysisid, patientid);
		DatabaseMgr db = new DatabaseMgr();
		db.addHealthAnalysis(patientid, temp);
	}
	public void addMedicines(int healthAnalysisid,String name, String description, int quantity[], int intakecon[])
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		Medicines medicine = new Medicines(name,description,quantity,intakecon); 
		temp.addMedicines(medicine);
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.addMedicines(healthAnalysisid,medicine);
	}
	public void addSurgery(int healthAnalysisid, String name,String comments)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.setsuggestedSurgery(name, comments);
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.addSurgery(healthAnalysisid,temp.getsuggestedsurgery());
	}
	public void addReferral(int healthAnalysisid, String patientid,String doctorid1,String doctorid2,String comments)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.setsuggestedreferral(healthAnalysisid, patientid, doctorid1, doctorid2, comments);
		HealthAnalysisDetails.replace(healthAnalysisid, temp);
		DatabaseMgr db = new DatabaseMgr();
		db.addReferral(healthAnalysisid,temp.getsuggestedreferral());
	}
	public void deletereferrals(int healthAnalysisid)
	{
		HealthAnalysis temp = HealthAnalysisDetails.get(healthAnalysisid);
		temp.suggestedReferral = null;
		HealthAnalysisDetails.replace(healthAnalysisid, temp);	
		DatabaseMgr db = new DatabaseMgr();
		db.deletereferral(healthAnalysisid);
	}
}
