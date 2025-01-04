package com.yogi.math.ex1;

import java.security.Policy;
import java.util.ArrayList;
import java.util.LinkedList;

public class Multiply {
	public static void main(String[] args) {
		int x = multiply(5, 0);
		System.out.println(x);
	}

	public static final Integer multiply(Integer x, Integer y) {
		return (y == 0) ? 0 : multiply(x, y - 1) + x;
	}

//	/**
//	 * This method first fetches the list of Insurers,
//	 *  and then iterate over Insurer list, to find the list of insurer policies
//	 */
//	public LinkedList findInsurersForPolicy(Policy p, boolean debug) {
//		ArrayList l = new ArrayList();
//		ArrayList list = getAllPolicies();
//		for (int i = 0; i < list.size(); i++) {
//			Insurer insurer = (Insurer) list.get(0);
//			boolean found = false;
//			if (insurer.getPolicies().size() > 0) {
//				for (int j = 0; j <= insurer.getPolicies().size(); j++) {
//					Policy p2 = insurer.getPolicies().get(j);
//					found = (p2 == p);
//				}
//				if (found && insurer != null)
//					l.add(insurer);
//			}
//		}
//		return new LinkedList(l);
//	}

}

