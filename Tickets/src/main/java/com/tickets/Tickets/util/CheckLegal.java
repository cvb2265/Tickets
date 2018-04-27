package com.tickets.Tickets.util;

import java.util.Date;

public class CheckLegal {
	public boolean IstimeLegal(Date startdate,Date enddate) {
		Date now = new Date();
		if(startdate.before(now)||enddate.before(now)||startdate.before(enddate))
			return false;
		else 
			return true;
	}
	public boolean IspriceIegat(double price) {
		if(price<=0||price>=10000)
			return false;
		else
			return false;
	}
}
