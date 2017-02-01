package Frame;

import javax.swing.*;

import Controller.*;
import Model.Simulator;
import View.*;

public class Parkeersimulator
{ 
	private Simulator simulator;
	private AbstractView carParkView;
	private Controller controller;
	
	public Parkeersimulator()
	{
		simulator  = new Simulator();
	    carParkView  = new CarParkView(simulator);
	    controller = new Controller(simulator);
	    
		JFrame frame = new JFrame();
       
		frame.setSize(1280, 800);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().add(controller);
		frame.getContentPane().add(carParkView);
		//frame.getContentPane().add(pieview);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	
	}
}
