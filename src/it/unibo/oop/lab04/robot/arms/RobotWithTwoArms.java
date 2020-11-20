package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

	public static int MAX_CARRYING_OBJECTS = 2;
	public static final double CARRY_DELTA_ADDITIONAL_CONSUMPTION = 1.1;
	
	/*
	 * Robot Arms.
	 */
	private BasicArm arm1;
	private BasicArm arm2;
	
	
	// Carried object counter
	private int carriedObjCount;
	
	public RobotWithTwoArms(String robotName, BasicArm inputArm1, BasicArm inputArm2) {
		super(robotName);
		this.arm1 = inputArm1;
		this.arm2 = inputArm2;
	}
	
	public RobotWithTwoArms(String robotName) {
		this(robotName, new BasicArm("First arm"), new BasicArm("Second arm"));
	}
	
	protected double getBatteryRequirementForMovement() {
		return super.getBatteryRequirementForMovement() + (CARRY_DELTA_ADDITIONAL_CONSUMPTION * this.carriedObjCount);
	}
	
	/**
	 * Pick up an object from the ground
	 * 
	 * The robot will select an arm that is free and that can carry 
	 * an object. If it's available the free arm will pick up the
	 * object and then it will apply the relative consumption costs.
	 * 
	 * The counter of carried objects it will be updated. 
	 * 
	 * @return true if the robot has picked up an Object.
	 */
	public boolean pickUp() {
		BasicArm freeArm = this.getFreeArm();
		if(freeArm instanceof BasicArm) {
			freeArm.pickUp();
			this.consumeBattery(freeArm.getConsuptionForPickUp());
			this.incCarriedObjCount();
			return freeArm.isGrabbing();
		}
		
		return false;
	}
	
	/**
	 * Get one of the robot arms that isn't carrying an object
	 * @return A BasicArm instance that represent a free arm of the robot
	 */
	private BasicArm getFreeArm() {
		if(!this.isCarryingMax()) {
			return this.arm1.isGrabbing() ? this.arm2 : this.arm1;
		}
		return null;
	}
	
	/**
	 * Check if the object is carrying the max quantity of objects allowed
	 * @return true if the robot is carrying the maximum quantity 
	 */
	private boolean isCarryingMax() {
		return this.carriedObjCount == MAX_CARRYING_OBJECTS;
	}
	
	/**
	 * Increment the counter of the carried objects
	 */
	private void incCarriedObjCount() {
		this.carriedObjCount++;
	}
	
	/**
	 * Drop down an object in to the ground
	 * 
	 * The robot will drop an object from  a selected arm
	 * @return true if the operation is solved successfully
	 */
	public boolean dropDown() {
		BasicArm occupiedArm = this.getAnOccupiedArm();
		if(occupiedArm instanceof BasicArm) {
			occupiedArm.dropDown();
			this.consumeBattery(occupiedArm.getConsuptionForDropDown());
			this.decCarriedObjCount();
			
			return occupiedArm.isGrabbing();
		}
		return false;
	}
	
	/**
	 * Return one of the two arms that is carrying an object
	 * @return an instance of an occupied arm or null 
	 */
	private BasicArm getAnOccupiedArm() {
		
		if(this.arm1.isGrabbing()) {
			return this.arm1;
		} else if (this.arm2.isGrabbing()) {
			return this.arm2;
		}
		
		return null;
	}
	
	/**
	 * Decrement the counter of the carried objects
	 */
	private void decCarriedObjCount() {
		this.carriedObjCount--;
	}
	
	/**
	 * Return the count of the carried items
	 * @return carried items count
	 */
	public int getCarriedItemsCount() {
		return this.carriedObjCount;
	}
}
