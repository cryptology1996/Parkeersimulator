package View;

import javax.swing.*;
import Model.*;

public abstract class AbstractView extends JPanel {
	protected ParkeerGarage simulator;

	public AbstractView(ParkeerGarage simulator) {
		this.simulator=simulator;
		simulator.addView(this);
	}
	
	public ParkeerGarage getModel() {
		return simulator;
	}
	
	public void updateView() {
		repaint();
	}
}
