package com.yogi.persist.externalization;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;

public class PersitExternalizable implements Externalizable {
	private Date time;

	transient private Thread t = new Thread();
	int x [] = {1,2};
	public PersitExternalizable() {
		time = Calendar.getInstance().getTime();
	}

	public Date getTime() {
		return time;
	}

	public void readExternal(ObjectInput in) {

	}

	public void writeExternal(ObjectOutput out) {

	}
}
