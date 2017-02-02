package View;

import java.awt.*;


import javax.swing.*;
import Model.*;

public class PieView extends AbstractView {
    private int aantalAdHoc;
    private int aantalPassCar;
    private int aantalReserved;
    private int aantalEmpty;

    public PieView(Simulator simulator) {
    	super(simulator); 
    	setSize(300,300);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        aantalAdHoc = CarParkView.GetAdHoc();
        aantalPassCar = CarParkView.GetParkPass();
        aantalEmpty = 500 - aantalPassCar - aantalAdHoc;
        aantalReserved = aantalPassCar + aantalAdHoc;
        
        g.setColor(Color.red);
        g.fillArc(10, 10, 250, 250, 0, aantalAdHoc);
        g.setColor(Color.blue);
        g.fillArc(10, 10, 250, 250, aantalAdHoc, aantalPassCar);
        g.setColor(Color.yellow);
        g.fillArc(10, 10, 250, 250, aantalReserved, aantalEmpty);
    }   
    
}