package com.yogi.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsContains {

	private static List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		list.add("DB");
		list.add("DC");
		list.add("HM");

		boolean flag1 = false;
		boolean flag2 = false;
		if (!(list.contains("DB") && list.contains("DC") && list.contains("HM"))) {
			flag1 = true;
		}
		System.out.println("Flag1=" + flag1);

		if ((!list.contains("DB") && !list.contains("DC") && !list.contains("HM"))) {
			flag2 = true;
		}
		System.out.println("Flag2=" + flag2);
	}

}
