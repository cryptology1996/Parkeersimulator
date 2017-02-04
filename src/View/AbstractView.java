package View;

import javax.swing.*;
import Model.*;

/**
 * AbstractView for the view classes
 *  @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 */
public abstract class AbstractView extends JPanel {
	protected ParkeerGarage simulator;
	protected Simulator model;
	
	/**
	 * Creates an instance for ParkeerGarage
	 * @param simulator is the ParkeerGarage
	 */
	public AbstractView(ParkeerGarage simulator) {
		this.simulator=simulator;
		simulator.addView(this);
	}
	
	/**
	 * Creates an instance for Simulator
	 * @param model is the simulator
	 */
	public AbstractView(Simulator model)
	{
		this.model = model;
		model.addView(this);
	}
	
	public ParkeerGarage getModel() {
		return simulator;
	}
	
	/**
	 * updates all the views
	 */
	public void updateView() {
		repaint();
	}
}
