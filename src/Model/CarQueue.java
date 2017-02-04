package Model;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Creates a class carQueuethat makes LinkedLists for queues
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */
public class CarQueue {
    private Queue<Car> queue = new LinkedList<>();

    /**
     * adds a car to a new linked list queue
     * 
     * @param car: is the car that gets added
     * @return queue.add(car)
     */
    public boolean addCar(Car car) {
        return queue.add(car);
    }

    /**
     * removes a car from the queue
     * 
     * @return queue.poll()
     */
    public Car removeCar() {
        return queue.poll();
    }

    /**
     * returns the queue size
     * 
     * @return queue.size()
     */
    public int carsInQueue(){
    	return queue.size();
    }
}
