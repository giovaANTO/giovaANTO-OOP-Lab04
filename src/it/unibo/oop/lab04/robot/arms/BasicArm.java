package it.unibo.oop.lab04.robot.arms;

public class BasicArm {
	
	
   	private static final double PICK_UP_CONSUPTION = 1.1;
	private static final double DROP_DOWN_CONSUPTION = 0.5;
   	
	private final String name;
	private boolean grabbingObj;

	public BasicArm(final String inputName) {
		this.name = inputName;
	}

	public boolean isGrabbing() {
		return this.grabbingObj;
	}
	
	public boolean pickUp() {
		this.setGrabbingObj(true);
		return true;
	}
	
	public boolean dropDown() {
		this.setGrabbingObj(false);
		return false;
	}
	
	public double getConsuptionForPickUp() {
		return PICK_UP_CONSUPTION;
	}
	
	public double getConsuptionForDropDown() {
		return DROP_DOWN_CONSUPTION;
	}
	
	private void setGrabbingObj(boolean grabbingObj) {
		this.grabbingObj = grabbingObj;
	}
	
	public String toString() {
		return "Robot Arms [name=" + name + " rigth now is grabbing an object =" + grabbingObj + "]";
	}
	
	
}
