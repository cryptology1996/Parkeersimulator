package View;

import java.awt.Color;
import java.awt.Graphics;

import Model.*;

public class Test extends AbstractView {
	
	
	public Test(ParkeerGarage parkeergarage){
		super(parkeergarage);
		setSize(800,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		g.setColor(Color.RED);
		g.fillOval(10, 20, 200, 200);
		
			}
	}

