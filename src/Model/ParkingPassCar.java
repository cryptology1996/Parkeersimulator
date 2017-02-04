package Model;


import java.util.Random;
import java.awt.*;
/**
 * creates a parkingPassCar and extends Car
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */
public class ParkingPassCar extends Car {
	private static final Color COLOR=Color.blue;
	
	/**
	 * creates a new ParkingPassCar at random
	 */
    public ParkingPassCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(false);
    }
    
    public Color getColor(){
    	return COLOR;
    }
}

