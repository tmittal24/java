package com.yogi.collections;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class MapNullCheck {
	public static void main(String[] args) {
		process();
	}

	public static void process() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(null, null);
		map.put("a", "aaaa");

		for (Entry<String, Object> parmDataArrayItem : map.entrySet()) {
			Object obj = parmDataArrayItem.getValue();
			String parmValue = (obj instanceof String) ? (String) parmDataArrayItem.getValue()
					: (obj instanceof Date) ? obj.toString() : String.valueOf(obj);
			System.out.println(parmValue);
		}
	}
}
