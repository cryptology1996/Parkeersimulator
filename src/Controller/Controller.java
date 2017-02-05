package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import Model.*;

/**
 * This is class Controller for Simulator 
 * Contains the buttons for the simulator with its ActionListener and ActionEvent
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class Controller extends AbstractController implements ActionListener {
	private JButton een;
	private JButton honderd;
	private JButton start;
	private JButton stop;
	private ActionEvent event;

	
/**
* Constructs an instance of the Controller
* and add the buttons 1 step, 100 steps, start an stop to simulator 
*/
	
public Controller(Simulator simulator) {
		super (simulator);
		
		setLayout(new GridBagLayout());
    	setBackground(Color.LIGHT_GRAY);
    	setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,8));
    	Color backgroundB = new Color(0x0C97C5);
    	
    	een = new JButton("One Step");
    	een.addActionListener((ActionListener) this);
    	GridBagConstraints l1 = new GridBagConstraints();
		l1.fill = GridBagConstraints.HORIZONTAL;
        l1.weightx = 3;
        l1.ipady = 30;
        l1.gridx = 0;
        l1.gridy = 0;
        een.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		een.setBackground(backgroundB);
		een.setForeground(Color.WHITE);
        add(een, l1);
        
        honderd= new JButton("Hundred Steps");
        honderd.addActionListener((ActionListener) this);
        GridBagConstraints l2 = new GridBagConstraints();
		l2.fill = GridBagConstraints.HORIZONTAL;
        l2.weightx = 3;
        l2.ipady = 30;
        l2.gridx = 1;
        l2.gridy = 0;
        honderd.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		honderd.setBackground(backgroundB);
		honderd.setForeground(Color.WHITE);
        add(honderd, l2);
       
        start= new JButton("Start");
        start.addActionListener((ActionListener) this);
        GridBagConstraints l3 = new GridBagConstraints();
		l3.fill = GridBagConstraints.HORIZONTAL;
        l3.weightx = 3;
        l3.ipady = 30;
        l3.gridx = 2;
        l3.gridy = 0;
        start.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		start.setBackground(backgroundB);
		start.setForeground(Color.WHITE);
        add(start, l3);
       
        stop= new JButton("Stop");
        stop.addActionListener((ActionListener) this);
        GridBagConstraints l4 = new GridBagConstraints();
		l4.fill = GridBagConstraints.HORIZONTAL;
        l4.weightx = 3;
        l4.ipady = 30;
        l4.gridx = 3;
        l4.gridy = 0;
        stop.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		stop.setBackground(backgroundB);
		stop.setForeground(Color.WHITE);
        add(stop, l4);
	}

/**
 * sets ActionEvent to e
 * @ActionEvent = e
 * @event = e
 */

public void setActionEvent(ActionEvent e) {
	event = e;
}

/**
 * returns the set event
 * @return event
 */

public ActionEvent getActionEvent() {
	return event;
}




/**
 * Executes the the input action
 */

public void actionPerformed(ActionEvent e)
{
	
	 //sets the received actionEvent, and creates a new thread
	 setActionEvent(e);
	 Thread performerThread = new Thread(){
		
		 /**
		  * Creates the commands that the buttons execute
		  */

		 public void run (){
			ActionEvent e = getActionEvent();
			String command = e.getActionCommand();
			simulator.setStop(false);
			if (command == "One Step"){
				simulator.runCommand(1);
			} 
			if (command == "Hundred Steps"){
				simulator.runCommand(100);
				}
			if (command == "Start"){
				
				simulator.runCommand(100000);
			}
		if (command == "Stop"){
			
			simulator.setStop(true);
			
			}
	
		}
		};
		performerThread.start();
		}

}

