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
	private AbstractView carParkView;
	private Controller controller;
	private ParkeerGarage parkeergarage;
	private JFrame screen;
	
	public Parkeersimulator()
	{
		simulator  = new Simulator();
	    controller = new Controller(simulator);
		parkeergarage = new ParkeerGarage(3, 6, 30);
		carParkView  = new CarParkView(parkeergarage);
		screen = new JFrame("Parkeergarage Simulator");
		screen.setSize(1920, 1080);
		screen.setResizable(false);
		screen.setLayout(null);
		screen.getContentPane().add(controller);
		screen.getContentPane().add(carParkView);
		controller.setBounds(735, 900, 450, 50);
		carParkView.setBounds(10, 10, 800, 500);
		carParkView.setBorder(BorderFactory.createLineBorder(Color.black));
		//frame.getContentPane().add(pieview);
		screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		screen.setVisible(true);
		
	
	}
}
