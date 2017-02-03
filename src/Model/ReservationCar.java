package Model;

import java.awt.Color;

/**
 * Class Which contains a car which has made a reservation
 * @author Antonie Groenveld, Arneld van der Veen, Albert van der Berg, Daniël Bouius, Martijn Bakker
 *
 */
public class ReservationCar extends Car {
	private int arrivalTime;
	private static final Color COLOR=Color.YELLOW;
	
	/**
	 * Constructs an instance of ReservationCar, and sets the time that is left until the car arrives
	 */
	public ReservationCar(int time){
		arrivalTime = time;
		
	}
	/**
	 * returns the amount of time until the car arrives
	 * @return arrivalTime
	 */
	public int getArrivalTime(){
		return arrivalTime;
	}
	
	/**
	 * subtracts 1 minute per tick of the amount of time until arrival
	 */	
	public void removeArrivalTime(){
		if (arrivalTime != 0){
			arrivalTime--;
		}
	}
	
	public Color getColor() {
		return COLOR;
	}
	
}
