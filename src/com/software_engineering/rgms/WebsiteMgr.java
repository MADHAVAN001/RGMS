package com.software_engineering.rgms;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class WebsiteMgr {
	HashMap<Integer, SiteData> sitedata;

	public WebsiteMgr() {
		sitedata = new HashMap<Integer, SiteData>();
	}

	public boolean updateSiteData(int dataid, String imagelocation, String title,
			String content, GregorianCalendar lastupdate) {
		if (dataid < 1)
			return false;
		SiteData data = new SiteData(dataid, imagelocation, title, content,
				lastupdate);
		sitedata.replace(dataid, data);
		String sql = "UPDATE SITEDATA SET IMAGELOCATION = "+"\'"+imagelocation+"\'"+",TITLE = "+"\'"+title+"\'"+",DATA = "+"\'"+content+"\'"+",LASTUPDATE = "+"\'"+lastupdate+"\'"+" WHERE ID = "+dataid;
		
		return true;

	}

	public boolean deleteSiteData(int dataid) {
		if (sitedata.containsKey(dataid))
		{
			sitedata.remove(dataid);
			String sql = "DELETE FROM SITEDATA WHERE ID = "+dataid;
		
		return true;
		}
		else
			return false;
	}

	public boolean addSiteData(int dataid, String imagelocation, String title,
			String content, GregorianCalendar lastupdate) {
		if (dataid < 1)
			return false;
		SiteData data = new SiteData(dataid, imagelocation, title, content,
				lastupdate);
		sitedata.put(dataid, data);
		String sql = "INSERT INTO SITEDATA VALUES("+dataid+",\'"+title+"\'"+",\'"+imagelocation+"\'"+",\'"+content+"\'"+",\'"+lastupdate+"\'"+")";
	
		return true;
	}

	public SiteData getSite(int dataid) {
		if (!sitedata.containsKey(dataid))
			return null;
		SiteData data = sitedata.get(dataid);
		return data;
	}
}