package com.singleton;

import java.lang.reflect.ReflectPermission;
import java.security.*;
import java.lang.Runtime;

public class SingletonLazy {

	private static SingletonLazy INSTANCE = null;

	private SingletonLazy() {
		ReflectPermission perm = new ReflectPermission("suppressAccessChecks", "");
		AccessController.checkPermission(perm);
	}

	synchronized public static final SingletonLazy getInstance() {
		if (INSTANCE == null) {
			AccessController.doPrivileged(new PrivilegedAction<Object>() {
				public Object run() {
					INSTANCE = new SingletonLazy();
					return null;
				}
			});
		}
		return INSTANCE;
	}
}