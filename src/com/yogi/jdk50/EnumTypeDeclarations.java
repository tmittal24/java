package com.yogi.jdk50;

public class EnumTypeDeclarations {
	// (2) Static enum declaration is OK.
	public static enum SimpleMeal {
		BREAKFAST, LUNCH, DINNER
	};

	public void foo() {
		// (3) Local (inner) enum declaration is NOT OK!
		// enum SimpleMeal
		// { BREAKFAST, LUNCH, DINNER }
	}
}

