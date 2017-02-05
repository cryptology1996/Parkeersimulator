package View;

import java.awt.*;


import javax.swing.*;
import Model.*;

/**
 * Creates the PieView inside the JFrame
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */
public class PieView extends AbstractView {
    private int aantalAdHoc;
    private int aantalPassCar;
    private int aantalReservedSpot;
    private int aantalReservationCar;
    private int aantalEmpty;

    /**
     * Creates the constructor
     * @param simulator gives information needed from the simulator
     */
    public PieView(Simulator simulator) {
    	super(simulator); 
    	setSize(300,300);
    }
    
    /**
     * calculates the degrees that are used inside the PieChart 
     * @param aantalCars sets the amount of cars
     * @return degrees
     */
    public int calculateDegrees(double aantalCars) 
    {
    	int degrees;
    	double garageSize = 540;
    	
    	degrees = (int) (((100 / garageSize) * aantalCars) * 3.6);
    	
    	return degrees;
    	
    }

    /**
     * Paints the PieChart itself
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        aantalAdHoc = CarParkView.GetAdHoc();
        aantalPassCar = CarParkView.GetParkPass();
        aantalReservedSpot = CarParkView.GetReservedSpot();
        aantalReservationCar = CarParkView.GetReservationCar();
        aantalEmpty = 540 - aantalPassCar - aantalAdHoc - aantalReservedSpot - aantalReservationCar;
        System.out.println("AdHoc:" + aantalAdHoc + " PassCar:" + aantalPassCar + " RrsvSpot: " + aantalReservedSpot +
				" RrsvCar: " + aantalReservationCar + " EmptySpot: " + aantalEmpty);
  
        g.setColor(Color.white);
        g.fillArc(15, 15, 250, 250, 350, 360);
     
        g.setColor(Color.red);
        g.fillArc(15, 15, 250, 250, 0, calculateDegrees(aantalAdHoc));
        g.setColor(Color.orange);
        g.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc), calculateDegrees(aantalPassCar));
       
        g.setColor(Color.magenta);
        g.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + 
        							calculateDegrees(aantalPassCar), calculateDegrees(aantalReservedSpot));
        
        g.setColor(Color.green);
        g.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + 
        							calculateDegrees(aantalPassCar) + 
        							calculateDegrees(aantalReservedSpot), calculateDegrees(aantalReservationCar));
      
    
        g.setColor(Color.white);
        g.fillArc(15, 15, 250, 250, calculateDegrees(aantalAdHoc) + 
        							calculateDegrees(aantalPassCar) +
        							calculateDegrees(aantalReservedSpot) +
        							calculateDegrees(aantalReservationCar), calculateDegrees(aantalEmpty));
        
     
    }   
    
}