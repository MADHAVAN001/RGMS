package com.software_engineering.rgms;

public class Referral {
	int referralid;
	String patientid;
	String doctorid1;
	String doctorid2;
	String comments;

	public void setreferralid(int referralid) {
		this.referralid = referralid;
	}

	public void setpatientid(String patientid) {
		this.patientid = patientid;
	}

	public void setdoctorid1(String doctorid1) {
		this.doctorid1 = doctorid1;
	}

	public void setdoctorid2(String doctorid2) {
		this.doctorid2 = doctorid2;
	}

	public void setcomments(String comments) {
		this.comments = comments;
	}

	public int getreferralid() {
		return this.referralid;
	}

	public String getpatientid() {
		return this.patientid;
	}

	public String getdoctorid1() {
		return this.doctorid1;
	}

	public String getdoctorid2() {
		return this.doctorid2;
	}

	public String getcomments() {
		return this.comments;
	}
}
