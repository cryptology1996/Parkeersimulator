package Model;

import java.util.Random;
import java.awt.*;

/**
 * Creates a class AdHocCar and extends Car.
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */
public class AdHocCar extends Car {
	private static final Color COLOR=Color.red;
	
	/**
	 * Generates a new AdHocCar with a randomizer
	 */
    public AdHocCar() {
    	Random random = new Random();
    	int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setHasToPay(true);
    }
    
    /**
     * gets the colour that is given to AdHocCar
     * 
     * @return COLOR
     */
    public Color getColor(){
    	return COLOR;
    }
}
