package Model;

import java.awt.Color;

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
		
	}

	
	public Color getColor() {
		return COLOR;
	}
	
}
