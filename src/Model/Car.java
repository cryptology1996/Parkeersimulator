package Model;

import java.awt.*;

/**
 * Creates the class car that is the superclass for all the other car classes
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */

public abstract class Car {

    private Location location;
    private int minutesLeft;
    private boolean isPaying;
    private boolean hasToPay;
    private int ArrivalTime;

    /**
     * Constructor for objects of class Car
     */
    public Car() {

    }
    
    public int setArrivalTime(int time){
    	ArrivalTime = time;
    	return ArrivalTime;
    }
    
	/**
	 * returns the amount of time until the car arrives
	 * @return arrivalTime
	 */
	public int getArrivalTime(){
		return ArrivalTime;
	}
	
	/**
	 * subtracts 1 minute per tick of the amount of time until arrival
	 */	
	public void removeArrivalTime(){
		if (ArrivalTime != 0){
			ArrivalTime--;
		}
		
	}
	
	/**
	 * gets the location of a car
	 * @return location
	 */
    public Location getLocation() {
        return location;
    }

    /**
     * sets the location of a car
     * 
     * @param location: sets the location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * gets the amount of minutes a car will remain in the garage
     * 
     * @return minutesLeft
     */
    public int getMinutesLeft() {
        return minutesLeft;
    }

    /**
     * sets the minutes that a car has left in the garage
     * 
     * @param minutesLeft: sets the amount of minutes left
     */
    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    
    /**
     * gets if the car is paying or not
     * 
     * @return isPaying
     */
    public boolean getIsPaying() {
        return isPaying;
    }
    
    /**
     *  sets if a car is paying or not
     *  
     *  @param isPaying: is a boolean that sets a car to pay or not with true/false
     */
    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    /**
     * Gets if a car has to pay to pay or not
     * 
     * @return hasToPay
     */
    public boolean getHasToPay() {
        return hasToPay;
    }

    /**
     * Sets if a car has to pay or not
     * 
     * @param hasToPay: is a boolean that sets if a car has to pay or not with true/false
     */
    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }

    public void tick() {
        minutesLeft--;
		if (ArrivalTime != 0){
			ArrivalTime--;
		}
    }
    
    public abstract Color getColor();
}