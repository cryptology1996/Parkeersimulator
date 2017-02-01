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
	
	public Parkeersimulator()
	{
		simulator  = new Simulator();
	    controller = new Controller(simulator);
		parkeergarage = new ParkeerGarage(3, 6, 30);
		carParkView  = new CarParkView(parkeergarage);
		JFrame frame = new JFrame();
		frame.setSize(1920, 1080);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().add(controller);
		frame.getContentPane().add(carParkView);
		controller.setBounds(0, 210, 450, 50);
		carParkView.setBounds(230, 10, 200, 200);
		//frame.getContentPane().add(pieview);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	
	}
}
