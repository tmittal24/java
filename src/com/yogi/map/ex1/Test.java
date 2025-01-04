package com.yogi.map.ex1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.process();
	}

	private void process() {

		Map m1 = new HashMap();
		m1.put("value5", "java2s");
		m1.put("value4", "HashMap");
		m1.put("value3", "java2");
		m1.put("value2", "yogi");
		m1.put("value1", "java2s");
		print(m1.keySet());
		//print(m1.values());
		
		

		SortedMap sm = new TreeMap();
		sm.put("value4", "TreeMap");
		sm.put("value3", "java2");
		sm.put("value2", "yogi");
		sm.put("value1", "java2s");
		sm.put("value5", "java2s");
		print(sm.keySet());
		//print(sm.values());

		LinkedHashMap lm = new LinkedHashMap();
		lm.put("value1", "LinkedHashMap");
		lm.put("value2", "java2");
		lm.put("value3", "yogi");
		lm.put("value5", "java2s");
		lm.put("value4", "java2s");
		print(lm.keySet());
		//print(lm.values());
	}
	
	public void print(Collection collection){
		
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			System.out.println(object);
			
		}
		System.out.println("----------------------------");
		
	}
}