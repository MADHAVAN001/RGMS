package com.software_engineering.rgms;

public class Surgery {
	String name;
	String comments;
	Surgery(String name, String comments){
		this.name = name;
		this.comments = comments;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public void setcomments(String comments)
	{
		this.comments = comments;
	}
	public String getcomments()
	{
		return comments;
	}
	public String getname()
	{
		return name;
	}
}
