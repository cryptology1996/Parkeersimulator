package View;

import javax.swing.*;
import Model.*;

public abstract class AbstractView extends JPanel {
	protected Simulator model;

	public AbstractView(Simulator model) {
		this.model=model;
		//model.addView(this);
	}
	
	public Simulator getModel() {
		return model;
	}
	
	public void updateView() {
		repaint();
	}
}
