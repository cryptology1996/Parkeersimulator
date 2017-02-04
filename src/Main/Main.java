package Main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import Controller.*;
import Model.*;
import View.*;


public class Main {
	
	public static void main(String [] args)
	{
		{
		    ParkeerGarage parkeergarage = new ParkeerGarage(3, 6, 30);
			Simulator simulator  = new Simulator(parkeergarage);
		    Controller controller = new Controller(simulator);
		    CarParkView CarParkView  = new CarParkView(parkeergarage);
		    TextOverview textoverview = new TextOverview(simulator);
		    PieView PieView = new PieView(simulator);
		    TypeOfCarView TypeOfCarView = new TypeOfCarView(simulator);
		    QueueView queueView = new QueueView(simulator);
		    ChangeController changeController = new ChangeController(simulator);
			JFrame screen = new JFrame("Parkeergarage Simulator");
			screen.setSize(1200, 1000);
			screen.getRootPane().setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.DARK_GRAY));
			screen.setResizable(false);
			screen.setLayout(null);
			
			
			screen.getContentPane().add(controller);
			screen.getContentPane().add(CarParkView);
			screen.getContentPane().add(textoverview);
			screen.getContentPane().add(PieView);
			screen.getContentPane().add(TypeOfCarView);
			screen.getContentPane().add(queueView);
			screen.getContentPane().add(changeController);
			
			
			controller.setBounds(167, 910, 875, 50);
			CarParkView.setBounds(5, 10, 875, 445);
			textoverview.setBounds(150, 450, 600, 40);
			PieView.setBounds(610, 490, 272, 272);
			TypeOfCarView.setBounds(300, 600, 300, 130);
			queueView.setBounds(200, 800, 150, 130);
			
			changeController.setBounds(5, 500, 200, 200);
			
			
			PieView.setBackground(Color.LIGHT_GRAY);
			CarParkView.setBackground(Color.LIGHT_GRAY);
			changeController.setBackground(Color.LIGHT_GRAY);
			
			
			TypeOfCarView.setBorder(BorderFactory.createLineBorder(Color.black));
			PieView.setBorder(BorderFactory.createLineBorder(Color.black));
			CarParkView.setBorder(BorderFactory.createLineBorder(Color.black));
			controller.setBorder(BorderFactory.createLineBorder(Color.black));
			queueView.setBorder(BorderFactory.createLineBorder(Color.black));
			changeController.setBorder(BorderFactory.createLineBorder(Color.black));
			
			
			
			
			screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			screen.setVisible(true);
			
		
		}
	}
}
