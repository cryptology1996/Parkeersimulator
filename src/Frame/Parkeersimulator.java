package Frame;

import java.awt.*;
import javax.swing.*;
import Controller.*;
import Model.ParkeerGarage;
import Model.Simulator;
import View.*;

public class Parkeersimulator
{ 
	private Simulator simulator;
	private AbstractView CarParkView;
	private Controller controller;
	private ParkeerGarage parkeergarage;
	private JFrame screen;
	
	public Parkeersimulator()
	{
	    parkeergarage = new ParkeerGarage(3, 6, 30);
		simulator  = new Simulator(parkeergarage);
	    controller = new Controller(simulator);
	    CarParkView  = new CarParkView(parkeergarage);
		screen = new JFrame("Parkeergarage Simulator");
		screen.setSize(1920, 1030);
		screen.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
		screen.setResizable(false);
		screen.setLayout(null);
		screen.getContentPane().add(controller);
		screen.getContentPane().add(CarParkView);
		controller.setBounds(735, 900, 500, 50);
		CarParkView.setBounds(10, 10, 875, 445);
		CarParkView.setBackground(Color.LIGHT_GRAY);
		CarParkView.setBorder(BorderFactory.createLineBorder(Color.black));
		controller.setBorder(BorderFactory.createLineBorder(Color.black));
		//frame.getContentPane().add(pieview);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
	
	}
}
