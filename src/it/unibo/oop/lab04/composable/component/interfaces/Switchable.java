package it.unibo.oop.lab04.composable.component.interfaces;


/*
 * Describe an element that can be set in two different states: On and Off 
 */
public interface Switchable {
		
	/**
	 * Switch on the element
	 */
	void on();
	
	/**
	 * Switch off the element
	 */
	void off();
	
	/**
	 * Check if an element is switched on
	 */
	boolean isOn();
		
}
