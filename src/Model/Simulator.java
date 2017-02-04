package Model;

import java.util.Random;

import javax.swing.JOptionPane;

import java.awt.*;

/**
 * Creates the simulator and contains all its settings
 * 
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */


public class Simulator extends AbstractModel{

	private static final String AD_HOC = "1";
	private static final String PASS = "2";
	private static final String RESERV_CAR = "3";
	
	private CarQueue entranceCarQueue;
    private CarQueue entrancePassQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;
    private ParkeerGarage parkeerGarage;
   
    private int PayingCars;
    private int day = 0;
    private int hour = 0;
    private int minute = 0;
    private int tickPause = 250;
    
    private boolean set;
    private boolean reset;
    private boolean stop;

    int weekDayArrivals = 60; // average number of arriving cars per hour
    int weekendArrivals = 100; // average number of arriving cars per hour
    int weekDayPassArrivals = 25; // average number of arriving cars per hour
    int weekendPassArrivals = 10; // average number of arriving cars per hour
    int weekDayReservArrivals= 25; // average number of arriving cars per hour
    int weekendReservArrivals = 10; // average number of arriving cars per hour

    int enterSpeed = 3; // number of cars that can enter per minute
    int paymentSpeed = 7; // number of cars that can pay per minute
    int exitSpeed = 5; // number of cars that can leave per minute

    /**
     * creates the constructor for Simulator
     * @param parkeerGarage gives the simulator information from the parkeerGarage
     */
    public Simulator(ParkeerGarage parkeerGarage) {
    	this.parkeerGarage = parkeerGarage;
        entranceCarQueue = new CarQueue();
        entrancePassQueue = new CarQueue();
        paymentCarQueue = new CarQueue();
        exitCarQueue = new CarQueue();
        

    }
    
    /**
     * This is the method that starts up the simulator when a button is pressed
     * @param getal is the number of times the simulator will tick(is given by the buttons)
     */
  public void runCommand(int getal) {
    	int i = getal;
    	while(i > 0 && set == true){
    		tick(); 
    		i--; 
    			if(stop){
    			return;
    			}
    		}
    	if (set == false){
    		Toolkit.getDefaultToolkit().beep();
    		JOptionPane.showMessageDialog(null, "You need to Set all values before starting", "Error",  JOptionPane.ERROR_MESSAGE);
    	}
    	}
  

    
  	/**
  	 * The tick method handles the entire simulation
  	 */
    private void tick() {
    	advanceTime();
    	handleExit();
    	updateViews();
    	
    	// Pause.
        try {
            Thread.sleep(tickPause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	handleEntrance();
    	
    }

    /**
     * Advances the time inside the simulation
     */
    private void advanceTime(){
        // Advance the time by one minute.
        minute++;
        while (minute > 59) {
            minute -= 60;
            hour++;
        }
        while (hour > 23) {
            hour -= 24;
            day++;
        }
        while (day > 6) {
            day -= 7;
        }

    }

    /**
     * handleEntrance groups all the entrance queues into one method 
     */
    private void handleEntrance(){
    	
    	carsArriving();
    	carsEntering(entrancePassQueue);
    	carsEntering(entranceCarQueue);  	
    }
    
    /**
     * handleExit groups all the exit queues into one method
     */
    private void handleExit(){
        carsReadyToLeave();
        carsPaying();
        carsLeaving();
    }
    /**
     * updateViews updates the visual aspects of the simulator after each tick
     */
    public void updateViews(){
    	parkeerGarage.tick();
        notifyViews();
    }

    /**
     * carsArriving handles all the newly added cars and gives them the correct name
     */
    private void carsArriving(){
    	int numberOfCars=getNumberOfCars(weekDayArrivals, weekendArrivals);
        addArrivingCars(numberOfCars, AD_HOC);    	
    	numberOfCars=getNumberOfCars(weekDayPassArrivals, weekendPassArrivals);
        addArrivingCars(numberOfCars, PASS);
        numberOfCars=getNumberOfCars(weekDayReservArrivals, weekendReservArrivals);
        addArrivingCars(numberOfCars, RESERV_CAR);
    }

    /**
     * carsEntering handles all the cars that enter the garage 
     * @param queue grabs the correct queue
     */
    private void carsEntering(CarQueue queue){
        int i=0;
        // Remove car from the front of the queue and assign to a parking space.
    	while (queue.carsInQueue()>0 && 
    			parkeerGarage.getNumberOfOpenSpots()>0 && 
    			i<enterSpeed) {
            Car car = queue.removeCar();
            Location freeLocation = parkeerGarage.getFirstFreeLocation();
            parkeerGarage.setCarAt(freeLocation, car);
            i++;
        }
    }
    
    /**
     * carsReadyToLeave puts the leaving cars into the correct queue
     */
    private void carsReadyToLeave(){
        // Add leaving cars to the payment queue.
        Car car = parkeerGarage.getFirstLeavingCar();
        while (car!=null) {
        	if (car.getHasToPay()){
	            car.setIsPaying(true);
	            paymentCarQueue.addCar(car);
        	}
        	else {
        		carLeavesSpot(car);
        	}
            car = parkeerGarage.getFirstLeavingCar();
        }
    }

    /**
     * carsPaying adds the paying cars to an int called PayingCars that will be used to calculate revenue.
     * It also puts the cars into the exitCarQueue afterwards
     */
    private void carsPaying(){
        // Let cars pay.
    	for (int i = 0; i < paymentSpeed; i++) {
            Car car = paymentCarQueue.removeCar();
            if (car != null){
            	
            	PayingCars++;
            
            }
            if (car == null) {
                break;
            }
            parkeerGarage.removeCarAt(car.getLocation());
            exitCarQueue.addCar(car);

    	
    	}
    }
    
    /**
     * returns the amount of cars that will pay 
     * @return PayingCars
     */
    public int getPayingCars() {
    	return PayingCars;
    }

    /**
     * carsLeaving removes the car from the simulator
     */
    private void carsLeaving(){
        // Let cars leave.
    	int i=0;
    	while (exitCarQueue.carsInQueue()>0 && i < exitSpeed){
            exitCarQueue.removeCar();
            i++;
    	}	
    }
    
    /**
     * gets the number of cars that arrive
     * @param weekDay sets if its a weekday or not
     * @param weekend sets if its a weekend or not
     * @return a random amount of cars that arrive
     */
    private int getNumberOfCars(int weekDay, int weekend){
        Random random = new Random();

        // Get the average number of cars that arrive per hour.
        int averageNumberOfCarsPerHour = day < 5
                ? weekDay
                : weekend;

        // Calculate the number of cars that arrive this minute.
        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        return (int)Math.round(numberOfCarsPerHour / 60);	
    }

    /**
     * adds the newly arriving cars into the entrance queue
     * @param numberOfCars sets the number of cars
     * @param typesets the type of car
     */
    private void addArrivingCars(int numberOfCars, String type){
        // Add the cars to the back of the queue.
    	switch(type) {
    	case AD_HOC: 
            for (int i = 0; i < numberOfCars; i++) {
            	entranceCarQueue.addCar(new AdHocCar());
            }
            break;
    	case PASS:
            for (int i = 0; i < numberOfCars; i++) {
            	entrancePassQueue.addCar(new ParkingPassCar());
            }
            break;
    	case RESERV_CAR:
    		for (int i = 0; i < numberOfCars; i++) {
    			entranceCarQueue.addCar(new ReservationCar());
    		}
    		break;
    	}
    }
    
    /**
     * Removes the car from a spot inside the garage
     * @param car sets the car that is leaving
     */
    private void carLeavesSpot(Car car){
    	parkeerGarage.removeCarAt(car.getLocation());
        exitCarQueue.addCar(car);
    }
    
    
    /**
     * All the methods below are getters and setters used by the buttons and textfields in QueueView and ChangeController
     */
    
    public int getEntranceCarQueue() {
    	return entranceCarQueue.carsInQueue(); 
    }
    
    public int getPassCarQueue() {
    	return entrancePassQueue.carsInQueue();
    }
    
    public int getExitCarQueue() {
    	return exitCarQueue.carsInQueue(); 
    }
    
    public void ChangeWeekAH(int getal){
		  this.weekDayArrivals = getal;
	  }
    public void ChangeWeekendAH(int getal){
		  this.weekendArrivals  = getal;
	  }
  public void ChangeWeekP(int getal){
		  this.weekDayPassArrivals = getal;
	  }
  public void ChangeWeekendP(int getal){
		  this.weekendPassArrivals = getal;
	  }
  public void ChangeWeekRes(int getal){
		  this.weekDayReservArrivals = getal;
	  }
  public void ChangeWeekendRes(int getal){
	  this.weekendReservArrivals = getal;
  }
  
  public void ChangeEntrySpeed(int getal){
	  this.enterSpeed = getal;
  }
  
  public void ChangePaySpeed(int getal){
	  this.paymentSpeed = getal;
  }
  
  public void ChangeExitSpeed(int getal){
	  this.exitSpeed = getal;
  }
  
  public void setSet(boolean check){
	  this.set = check;
	}
  
  public void setReset(boolean check){
	  this.reset = check;
	  
  }
  public void setStop(boolean stopping)
  {
	 stop = stopping;
  
  }
}
    

