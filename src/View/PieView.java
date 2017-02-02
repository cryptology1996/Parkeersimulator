package View;

import java.awt.*;


import javax.swing.*;
import Model.*;

public class PieView extends AbstractView {
    private int aantalAdHoc;
    private int aantalPassCar;
    private int aantalReserved;

    public PieView(ParkeerGarage simulator) {
    	super(simulator);  
    	setSize(300,300);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        aantalAdHoc = getModel().getAdHoc();
        System.out.println(aantalAdHoc);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 200, 200);
        g.setColor(Color.red);
        g.fillArc(10, 10, 180, 180, 0, aantalAdHoc);
        g.setColor(Color.blue);
        g.fillArc(10, 10, 180, 180, aantalAdHoc, aantalPassCar);
        g.setColor(Color.black);
        g.fillArc(10, 10, 180, 180, aantalAdHoc+aantalPassCar, aantalReserved);
        
    }    
}