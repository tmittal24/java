package com.singleton;

import java.io.Serializable;
import java.lang.Runtime ;
import java.lang.reflect.ReflectPermission;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class Singleton_Eager implements Serializable {
	private static final long serialVersionUID = 3119105548371608200L;
	
	
	private static final Singleton_Eager singleton = new Singleton_Eager();

	 
	private Singleton_Eager() {
		/** Don't let anyone else instantiate this class even using reflection */
		ReflectPermission perm = null;
		perm = new ReflectPermission("suppressAccessChecks", "");
		AccessController.checkPermission(perm);
	}

	public static Singleton_Eager getInstance() {
//		 if (singleton == null) {
//		      AccessController.doPrivileged(new PrivilegedAction<Object>() {
//		        public Object run() {
//		        	singleton= new Singleton_Eager();
//		          return null;
//		        }
//		      });
//		    }
//		    return singleton;
		return singleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning of this class is not allowed");
	}

	/**
	 * when an object is read, replace it with the singleton instance.
	 *  This ensures that nobody can create another instance by serializing and de-serializing the singleton
	 * @return
	 */
	protected Object readResolve() {
		// instead of the object we're on, 
		  // return the class variable INSTANCE
		return singleton;
	}

	// -----> This is my implementation to stop it but Its not working. :(
	public Object newInstance() throws InstantiationException {
		throw new InstantiationError("Creating of this object is not allowed.");
	}

}

