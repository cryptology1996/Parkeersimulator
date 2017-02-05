package Main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import Controller.*;
import Model.*;
import View.*;

/**
 * Creates the public static void main(String [] args) the program uses to start up.
 * Also creates all the view and controller instances.
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */

public class Main {
	
	public static void main(String [] args)
	{
		{
			
			/*
			 * Create a Parking garage
			 */
		    ParkeerGarage parkeergarage = new ParkeerGarage(3, 6, 30);
		    
		    /*
		     * Create a simulator and Controllers
		     */
			Simulator simulator  = new Simulator(parkeergarage);
		    Controller controller = new Controller(simulator);
		    ChangeController changeController = new ChangeController(simulator);
		    
		    /*
		     * Create each View
		     */
		    CarParkView CarParkView  = new CarParkView(parkeergarage);
		    TextOverview textoverview = new TextOverview(simulator);
		    PieView PieView = new PieView(simulator);
		    TypeOfCarView TypeOfCarView = new TypeOfCarView(simulator);
		    QueueView queueView = new QueueView(simulator);
		    
		    
		    /*
		     * Create a JFrame and set properties
		     */
			JFrame screen = new JFrame("Parking Garage Simulator");
			screen.setSize(885, 820);
			screen.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
			screen.setResizable(false);
			screen.setLayout(null);
			screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			/*
			 * add the controllers to the JFrame
			 */
			screen.getContentPane().add(controller);
			screen.getContentPane().add(changeController);
			
			/*
			 * Add every View to the Jframe
			 */
			screen.getContentPane().add(CarParkView);
			screen.getContentPane().add(textoverview);
			screen.getContentPane().add(PieView);
			screen.getContentPane().add(TypeOfCarView);
			screen.getContentPane().add(queueView);
			
			/*
			 * Set the Bounds of the Controllers
			 */
			controller.setBounds(-2, 730, 875, 50);
			changeController.setBounds(5, 440, 200, 280);
			
			/*
			 * Set the Bounds of each View
			 */
			CarParkView.setBounds(5, 10, 860, 420);
			textoverview.setBounds(245, 440, 300, 50);
			PieView.setBounds(585, 440, 280, 280);
			TypeOfCarView.setBounds(245, 500, 300, 130);
			queueView.setBounds(245, 640, 300, 80);
			
			/*
			 * set colors for background use
			 */
			
			Color backgroundA = new Color(0xDBEEF4);
			Color backgroundC = new Color(0x131B84);
			Color backgroundB = new Color(0xAAD0DD);
			
			/*
			 * Set backgrounds for the JFrame and changeController
			 */
			screen.getContentPane().setBackground(backgroundC);
			changeController.setBackground(backgroundB);
			
			/*
			 * Set the background of the views
			 */
			PieView.setBackground(backgroundB);
			TypeOfCarView.setBackground(backgroundA);
			queueView.setBackground(backgroundA);
			textoverview.setBackground(backgroundA);
			
			/*
			 * Sets the background of the CarParkView
			 */
			screen.setBackground(backgroundA);
			
			
			
			/*
			 * Set borders for each View and controllers
			 */
			controller.setBorder(BorderFactory.createLineBorder(Color.black));
			changeController.setBorder(BorderFactory.createLineBorder(Color.black));
			TypeOfCarView.setBorder(BorderFactory.createLineBorder(Color.black));
			PieView.setBorder(BorderFactory.createLineBorder(Color.black));
			CarParkView.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.DARK_GRAY));
			queueView.setBorder(BorderFactory.createLineBorder(Color.black));
			textoverview.setBorder(BorderFactory.createLineBorder(Color.black));
			
			/*
			 * Set the JFrame visible
			 */
			screen.setVisible(true);
			
		
		}
	}
}
