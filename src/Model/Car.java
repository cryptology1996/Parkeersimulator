package Model;

import java.awt.*;

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
    	return time;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMinutesLeft() {
        return minutesLeft;
    }

    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }
    
    public boolean getIsPaying() {
        return isPaying;
    }

    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    public boolean getHasToPay() {
        return hasToPay;
    }

    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }

    public void tick() {
        minutesLeft--;
    }
    
    public abstract Color getColor();
}