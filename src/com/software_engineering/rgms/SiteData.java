package com.software_engineering.rgms;
import java.util.GregorianCalendar;
public class SiteData {
	private int id;
	private String imagelocation;
	private String content;
	private String title;
	private GregorianCalendar lastupdated;
	
	public SiteData(int siteid,String imagelocation,String title,String content,GregorianCalendar lastupdate){
		this.id = siteid;
		this.imagelocation = imagelocation;
		this.title = title;
		this.content = content;
		this.lastupdated = lastupdate;
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImagelocation() {
		return imagelocation;
	}
	public void setImagelocation(String imagelocation) {
		this.imagelocation = imagelocation;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public GregorianCalendar getLastupdated() {
		return lastupdated;
	}
	public String toStringLastUpdated(){
		return lastupdated.toString();
	}
	public void setLastupdated(GregorianCalendar lastupdated) {
		this.lastupdated = lastupdated;
	}
	
}
