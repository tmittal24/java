package com.yogi.focusTraversal;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;

/**
 * Inner class for handling Tab focus control by returning the next focusable
 * component, when traversal wraps in the forward/reverse direction
 */
public class ZFocusTraversalPolicy extends FocusTraversalPolicy {

	/**
	 * List to be populated from the constructor of each view Class, with the
	 * components that needs tab focus.
	 */
	private ArrayList componentList = new ArrayList();

	private Component firstFocusElement = null;

	/**
	 * Called when moving focus to next component by pressing "Tab" key Returns
	 * the Component that should receive the focus after zComponent, or null if
	 * no suitable Component can be found
	 */
	public Component getComponentAfter(Container focusCycleRoot, Component zComponent) {
		Component nextComponent = null;
		if (zComponent != null) {
			int index = componentList.indexOf(zComponent);
			if (index != -1) {
				if (index == componentList.size() - 1) {
					// For last component, return the first componet as
					// next.
					nextComponent = (Component) componentList.get(0);
				} else {
					nextComponent = (Component) componentList.get(index + 1);
				}
			}
		}
		return nextComponent;
	}

	/**
	 * Called when moving focus to previous component by pressing combination of
	 * "Shift+Tab" keys Returns the Component that should receive the focus
	 * before aComponent, or null if no suitable Component can be found
	 */
	public Component getComponentBefore(Container focusCycleRoot, Component zComponent) {
		Component previousComponent = null;
		if (zComponent != null) {
			int index = componentList.indexOf(zComponent);
			if (index != -1) {
				if (index == 0) {
					// For first component, return the last component as
					// next.
					previousComponent = (Component) componentList.get(componentList.size() - 1);
				} else {
					previousComponent = (Component) componentList.get(index - 1);
				}
			}
		}
		return previousComponent;
	}

	/**
	 * Returns the default Component to focus. This Component will be the first
	 * to receive focus when traversing down into a new focus traversal cycle
	 * rooted at focusCycleRoot.
	 */
	public Component getDefaultComponent(Container focusCycleRoot) {
		if (firstFocusElement != null) {
			return firstFocusElement;
		} else {
			if (componentList.size() >= 1) {
				return (Component) componentList.get(0);
			} else {
				return null;
			}
		}
	}

	/**
	 * Returns Returns the first Component in the traversal cycle. This method
	 * is used to determine the next Component to focus when traversal wraps in
	 * the forward direction.
	 */
	public Component getFirstComponent(Container focusCycleRoot) {
		if (componentList.size() >= 1) {
			return (Component) componentList.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Returns the last Component in the traversal cycle. This method is used to
	 * determine the next Component to focus when traversal wraps in the reverse
	 * direction
	 */
	public Component getLastComponent(Container focusCycleRoot) {
		if (componentList.size() >= 1) {
			return (Component) componentList.get(componentList.size() - 1);
		} else {
			return null;
		}
	}

	/**
	 * @param zComponent -
	 *            The Component requiring "Tab" focus.
	 * 
	 * This method should be called from the Constructor of each View Class to
	 * add the Components requiring "Tab" focus
	 */
	public void addComponent(Component zComponent) {
		componentList.add(zComponent);
	}

	/**
	 * Sets the given component as the first focus element
	 * 
	 * @param zComponent
	 */
	public void setfirstFocusElement(Component zComponent) {
		firstFocusElement = zComponent;
	}

	/**
	 * 
	 * @param zComponent -
	 *            The Component after which the newComponent will be inserted
	 * @param newComponent -
	 *            The new Component to be inserted
	 */
	public void addComponentAfter(Component zComponent, Component newComponent) {
		if (zComponent != null) {
			int index = componentList.indexOf(zComponent);
			if (index != -1) {
				componentList.add(index + 1, newComponent);
			}
		}
	}

	/**
	 * 
	 * @param zComponent -
	 *            The Component before which the newComponent will be inserted
	 * @param newComponent -
	 *            The new Component to be inserted
	 */
	public void addComponentBefore(Component zComponent, Component newComponent) {
		if (zComponent != null) {
			int index = componentList.indexOf(zComponent);
			if (index != -1) {
				componentList.add(index, newComponent);
			}
		}
	}

}
