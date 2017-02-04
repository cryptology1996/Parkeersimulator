package Model;

import java.util.*;

import View.*;

/**
 * Abstract Class for the model subclasses
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public abstract class AbstractModel {
	private List<AbstractView> views;
	
	/**
	 * Creates an ArrayList that will contain all the views that are created in the program.
	 */
	public AbstractModel() {
		views=new ArrayList<AbstractView>();
	}
	
	/**
	 * Adds views to the ArrayList
	 * 
	 * @param view: A parameter that contains a View
	 */
	public void addView(AbstractView view) {
		views.add(view);
	}
	
	/**
	 * A method that allows all classes that are extended by AbstractModel to use updateView.
	 */
	public void notifyViews() {
		for(AbstractView v: views) v.updateView();
	}
}