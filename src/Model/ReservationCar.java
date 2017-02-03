package Model;

import java.awt.Color;
import java.util.Random;

/**
 * Class Which contains a car which has made a reservation
 * @author Antonie Groenveld, Arneld van der Veen, Albert van der Berg, Daniël Bouius, Martijn Bakker
 *
 */
public class ReservationCar extends Car {
	private static final Color COLOR=Color.YELLOW;
	
	/**
	 * Constructs an instance of ReservationCar, and sets the time that is left until the car arrives
	 */
	public ReservationCar(){
		Random random = new Random();
		int arrivaltime = (int) (random.nextFloat() * 3 * 60);
		int stayminutes = (int) (15 + random.nextFloat() * 3 * 60) + arrivaltime;
		this.setMinutesLeft(stayminutes);
		this.setArrivalTime(arrivaltime);
		this.setHasToPay(true);
		
		
	}

	
	public Color getColor() {
		return COLOR;
	}
	
}
