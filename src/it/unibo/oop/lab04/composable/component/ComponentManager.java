package it.unibo.oop.lab04.composable.component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import it.unibo.oop.lab04.composable.component.enums.ComponentType;


public class ComponentManager {
	
	private final Map<ComponentType, Set<AbstractComponent>> componentMap;
	
	public ComponentManager() {
		this.componentMap = new HashMap<>();
	}
	
	/**
	 * Add a new component to the attached robot 
	 * 
	 * @param type
	 * 			component type 
	 * @param component
	 * 			the component to insert
	 */
	void addComponent(ComponentType type, AbstractComponent component) {
		this.getComponentCategory(type).add(component);
	}

	/**
	 * Search a registered component by its name.
	 * 
	 * @param type
	 * 			component type 
	 * 
	 * @param name
	 * 			component name
	 * 
	 * @return The searched component
	 */
	AbstractComponent getComponent(ComponentType type, String name) { 
		return this.getComponentCategory(type).stream()
											  .filter(c -> c.getName().equals(name))
											  .findFirst()
											  .get(); 
	}
	
	/**
	 * Search a registered component by its id. Return the first result found
	 * 
	 * @param type
	 * 			component type 
	 * 
	 * @param id
	 * 			component id
	 * 
	 * @return The searched component
	 */
	AbstractComponent getComponentById(ComponentType type, String id) { 
		return this.getComponentCategory(type).stream()
				 							  .filter(c -> c.getId().equals(id))
				 							  .findFirst()
				 							  .get(); 
	}
	
	/**
	 * Search a component by its name and remove it from the list
	 * 
	 * @param type
	 * 			component type 
	 * @param name
	 * 			component name
	 */
	void removeComponent(ComponentType type, String id) {
		this.getComponentCategory(type).removeIf(e -> e.getId().equals(id));
	}
	
	private Set<AbstractComponent> getComponentCategory(ComponentType type) {
		return this.componentMap.get(type);
	}
}
