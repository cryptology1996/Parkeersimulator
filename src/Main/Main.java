package Main;

import javax.swing.*;

import Controller.*;
import Model.Simulator;
import View.*;


public class Main
{ 
	private CarParkView carParkView;
	
	public static void main(String [] args)
	{
		JFrame frame = new JFrame();
        Simulator s = new Simulator();
        CarParkView v = new CarParkView();
		//controller=new Controller(model);
	
		frame.setSize(1280, 800);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.getContentPane().add(v);
		//frame.getContentPane().add(pieview);
		//frame.getContentPane().add(Simulator);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setVisible(true);
		
		
	}
}
