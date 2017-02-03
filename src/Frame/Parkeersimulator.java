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
	private AbstractView textoverview;
	private AbstractView PieView;
	private AbstractView TypeOfCarView;
	private JFrame screen;
	
	public Parkeersimulator()
	{
	    parkeergarage = new ParkeerGarage(3, 6, 30);
		simulator  = new Simulator(parkeergarage);
	    controller = new Controller(simulator);
	    CarParkView  = new CarParkView(parkeergarage);
	    textoverview = new TextOverview(simulator);
	    PieView = new PieView(simulator);
	    TypeOfCarView = new TypeOfCarView(simulator);
		screen = new JFrame("Parkeergarage Simulator");
		screen.setSize(1600, 900);
		screen.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
		screen.setResizable(false);
		screen.setLayout(null);
		
		
		screen.getContentPane().add(controller);
		screen.getContentPane().add(CarParkView);
		screen.getContentPane().add(textoverview);
		screen.getContentPane().add(PieView);
		screen.getContentPane().add(TypeOfCarView);
		
		
		controller.setBounds(400, 775, 800, 75);
		CarParkView.setBounds(362, 10, 875, 445);
		textoverview.setBounds(650, 510, 300, 90);
		PieView.setBounds(1200, 480, 272, 272);
		TypeOfCarView.setBounds(650, 600, 300, 100);
		
		
		PieView.setBackground(Color.LIGHT_GRAY);
		CarParkView.setBackground(Color.LIGHT_GRAY);
		
		
		TypeOfCarView.setBorder(BorderFactory.createLineBorder(Color.black));
		PieView.setBorder(BorderFactory.createLineBorder(Color.black));
		CarParkView.setBorder(BorderFactory.createLineBorder(Color.black));
		controller.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setVisible(true);
		
	
	}
}
