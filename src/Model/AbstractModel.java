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
	
	
	public AbstractModel() {
		views=new ArrayList<AbstractView>();
	}
	
	public void addView(AbstractView view) {
		views.add(view);
		System.out.println(views.size());
	}
	
	public void notifyViews() {
		for(AbstractView v: views) v.updateView();
	}
}