package it.unibo.oop.lab04.composable.component;

import it.unibo.oop.lab04.composable.component.interfaces.Pluggable;
import it.unibo.oop.lab04.composable.component.interfaces.Switchable;

public abstract class AbstractComponent implements Pluggable, Switchable {

	private boolean powerStatus;
	private String id;
	private String name;
	
	public AbstractComponent(boolean powerStatus, String id, String name) {
		this.powerStatus = false;
		this.id = id;
		this.name = name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void on() {
		this.powerStatus = true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void off() {
		this.powerStatus = false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isOn() {
		return this.powerStatus;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 
	 * 			the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 
	 * 			the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	abstract public void plug(final ComponentManager manager);

	/**
	 * {@inheritDoc}
	 */
	abstract public void unplug();
	
	/**
	 * {@inheritDoc}
	 */
	abstract public ComponentManager getManager();
}
