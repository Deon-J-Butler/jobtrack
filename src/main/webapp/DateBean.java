package main.webapp;

import java.util.Date;

public class DateBean {
	
	private Date param1 = new Date();

	public Date getParam1() {
		return param1;
	}

	public void setParam1(Date param1) {
		this.param1 = param1;
	}

	public String toString() {
		return "DateBean [param1=" + param1 + "]";
	}

}
