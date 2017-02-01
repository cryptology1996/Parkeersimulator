package Frame;

import java.awt.*;
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
		GridLayout Layout = new GridLayout(0,2);
		frame.setSize(1280, 800);
		frame.setResizable(false);
		frame.setLayout(Layout);
		frame.getContentPane().add(controller);
		frame.getContentPane().add(carParkView);
		carParkView.updateView();
		//frame.getContentPane().add(pieview);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	
	}
}
