package View;

import javax.swing.*;
import Model.*;

public abstract class AbstractView extends JPanel {
	protected ParkeerGarage model;

	public AbstractView(ParkeerGarage model) {
		this.model=model;
		model.addView(this);
	}
	
	public ParkeerGarage getModel() {
		return model;
	}
	
	public void updateView() {
		repaint();
	}
}
