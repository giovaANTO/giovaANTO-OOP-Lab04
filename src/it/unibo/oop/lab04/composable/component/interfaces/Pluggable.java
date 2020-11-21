package it.unibo.oop.lab04.composable.component.interfaces;

import it.unibo.oop.lab04.composable.component.ComponentManager;

/**
 * This interface describe the basic operations for 
 * plug a component to a ComponentManager .
 */
public interface Pluggable {
	/**
	 * Plug a component to a ComponentManager
	 * @param manager
	 * 			the target component manager
	 */
	void plug(final ComponentManager manager);
	
	/**
	 * Unplug this component from a component manager
	 */
	void unplug();
	
	/**
	 * Return the current plugged ComponentManager.
	 * @return	
	 * 		the ComponentManager instance that is plugged to this component
	 */
	ComponentManager getManager();
}
