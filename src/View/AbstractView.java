package View;

import javax.swing.*;
import Model.*;

public abstract class AbstractView extends JPanel {
	protected ParkeerGarage simulator;
	protected Simulator model;

	public AbstractView(ParkeerGarage simulator) {
		this.simulator=simulator;
		simulator.addView(this);
	}
	public AbstractView(Simulator model)
	{
		this.model = model;
		model.addView(this);
	}
	
	public ParkeerGarage getModel() {
		return simulator;
	}
	
	public void updateView() {
		repaint();
	}
}
