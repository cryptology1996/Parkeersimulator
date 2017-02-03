package View;

import java.awt.*;


import javax.swing.*;
import Model.*;

public class PieView extends AbstractView {
    private int aantalAdHoc;
    private int aantalPassCar;
    private int aantalReservedSpot;
    private int aantalReservationCar;
    private int aantalEmpty;

    public PieView(Simulator simulator) {
    	super(simulator); 
    	setSize(300,300);
    }
    
    public int calculateDegrees(double aantalCars) 
    {
    	int degrees;
    	double garageSize = 540;
    	
    	degrees = (int) (((100 / garageSize) * aantalCars) * 3.6);
    	
    	return degrees;
    	
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        aantalAdHoc = CarParkView.GetAdHoc();
        aantalPassCar = CarParkView.GetParkPass();
        aantalReservedSpot = CarParkView.GetReservedSpot();
        aantalReservationCar = CarParkView.GetReservationCar();
        aantalEmpty = 540 - aantalPassCar - aantalAdHoc - aantalReservedSpot - aantalReservationCar;
        System.out.println("AdHoc:" + aantalAdHoc + " PassCar:" + aantalPassCar + " RrsvSpot: " + aantalReservedSpot +
				" RrsvCar: " + aantalReservationCar + " EmptySpot: " + aantalEmpty);
        //System.out.println(aantalAdHoc + ": " + calculateDegrees(270));
  
        g.setColor(Color.white);
        g.fillArc(10, 10, 250, 250, 350, 360);
        
        g.setColor(Color.red);
        g.fillArc(10, 10, 250, 250, 0, calculateDegrees(aantalAdHoc));
        g.setColor(Color.orange);
        g.fillArc(10, 10, 250, 250, calculateDegrees(aantalAdHoc), calculateDegrees(aantalPassCar));
       
        g.setColor(Color.YELLOW);
        g.fillArc(10, 10, 250, 250, calculateDegrees(aantalAdHoc) + 
        							calculateDegrees(aantalPassCar), calculateDegrees(aantalReservedSpot));
        
        g.setColor(Color.green);
        g.fillArc(10, 10, 250, 250, calculateDegrees(aantalAdHoc) + 
        							calculateDegrees(aantalPassCar) + 
        							calculateDegrees(aantalReservedSpot), calculateDegrees(aantalReservationCar));
      
    
        g.setColor(Color.white);
        g.fillArc(10, 10, 250, 250, calculateDegrees(aantalAdHoc) + 
        							calculateDegrees(aantalPassCar) +
        							calculateDegrees(aantalReservedSpot) +
        							calculateDegrees(aantalReservationCar), calculateDegrees(aantalEmpty));
        
     
    }   
    
}