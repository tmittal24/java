package com.yogi.persist.serialization.ex1;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

public class PersistentTime implements Serializable {
	private Date time;
	transient private Thread t = new Thread();
	public PersistentTime() {
		time = Calendar.getInstance().getTime();
	}

	public Date getTime() {
		return time;
	}
}
