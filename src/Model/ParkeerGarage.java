package Model;

/**
 * creates a class ParKeerGarage that creates information that is given to the CarParkView
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */

public class ParkeerGarage extends AbstractModel{
    private int numberOfFloors;
    private int numberOfRows;
    private int numberOfPlaces;
    private int numberOfOpenSpots;
    private Car[][][] cars;

    /**
     * Creates the constructor for ParKeergarage 
     * 
     * @param numberOfFloors, numberOfRows, numberOfPlaces: these ints give values to the floors that are created later on
     */
    public ParkeerGarage(int numberOfFloors, int numberOfRows, int numberOfPlaces) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfRows = numberOfRows;
        this.numberOfPlaces = numberOfPlaces;
        this.numberOfOpenSpots =numberOfFloors*numberOfRows*numberOfPlaces;
        cars = new Car[numberOfFloors][numberOfRows][numberOfPlaces];
        
    }
       
    /**
     *  Gets the number of floors 
     *  
     *  @return numberOfFloors
     */
	public int getNumberOfFloors() {
        return numberOfFloors;
    }

	 /**
     *  Gets the number of rows 
     *  
     *  @return numberOfRows
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     *  Gets the number of places 
     *  
     *  @return numberOfPlaces
     */
    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    /**
     *  Gets the number of open spots 
     *  
     *  @return numberOfOpenSpots
     */
    public int getNumberOfOpenSpots(){
    	return numberOfOpenSpots;
    }
    /**
     *  Gets the the location of a car be it valid or not
     *  
     *  @param location: is a location int that 
     *  @return returns the car location
     */
    public Car getCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        return cars[location.getFloor()][location.getRow()][location.getPlace()];
    }

    /**
     * Sets the car at a valid location
     * @param location: sets a valid location
     * @param car: grabs a valid car 
     * @return true/false 
     */
    public boolean setCarAt(Location location, Car car) {
        if (!locationIsValid(location)) {
            return false;
        }
        Car oldCar = getCarAt(location);
        if (oldCar == null) {
            cars[location.getFloor()][location.getRow()][location.getPlace()] = car;
            car.setLocation(location);
            numberOfOpenSpots--;
            return true;
        }
        return false;
    }

    /**
     * Removes a car from a valid location
     * @param location: sets valid location
     * @return car
     */
    public Car removeCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        Car car = getCarAt(location);
        if (car == null) {
            return null;
        }
        cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
        car.setLocation(null);
        numberOfOpenSpots++;
        return car;
    }

    /**
     * Gets the first free location
     * @return location
     */
    public Location getFirstFreeLocation() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    if (getCarAt(location) == null) {
                        return location;
                    }
                }
            }
        }
        return null;
    }
    /**
     * gets the first leaving car
     * @return car
     */
    public Car getFirstLeavingCar() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null && car.getMinutesLeft() <= 0 && !car.getIsPaying()) {
                        return car;
                    }
                }
            }
        }
        return null;
    }
/**
 * tells the tick method to tick 
 */
    public void tick() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null) {
                        car.tick();
                    }
                }
            }
        }
    }

    /**
     * is a boolean method that questions if a location is valid or not
     * @param location:: sets a location
     * @return true/false
     */
    private boolean locationIsValid(Location location) {
        int floor = location.getFloor();
        int row = location.getRow();
        int place = location.getPlace();
        if (floor < 0 || floor >= numberOfFloors || row < 0 || row > numberOfRows || place < 0 || place > numberOfPlaces) {
            return false;
        }
        return true;
    }
}

