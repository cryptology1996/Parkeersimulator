package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.*;

public class ChangeController extends AbstractController implements ActionListener {
	private JButton WeekAdHoc;
	private JButton WeekendAdHoc;
	private JButton WeekDayPass;
	private JButton WeekendPass;
	private JButton WeekReserve;
	private JButton WeekendReserve;
	private ActionEvent event;
	
	
	public ChangeController(Simulator simulator) {
		super (simulator);
		
		
		WeekAdHoc = new JButton("Weekday AdHoc");
		WeekAdHoc.addActionListener((ActionListener) this);
		
		WeekendAdHoc = new JButton("Weekend AdHoc");
		WeekendAdHoc.addActionListener((ActionListener) this);
		
		
		WeekDayPass = new JButton("Weekday Pass");
		WeekDayPass.addActionListener((ActionListener) this);
		
		
		WeekendPass = new JButton("Weekend Pass");
		WeekendPass.addActionListener((ActionListener) this);
		
		
		WeekReserve = new JButton("Week Reserve");
		WeekReserve.addActionListener((ActionListener) this);
		
		
		WeekendReserve = new JButton("Weekend Reserve");
		WeekendReserve.addActionListener((ActionListener) this);
		
		
		
	}
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
			

			 public void run (){
				ActionEvent e = getActionEvent();
				String command = e.getActionCommand();
				if (command == "Weekday AdHoc"){
					// methode aanroepen 
					
					// int y = Integer.parseInt(string);
					// WeekdayArrivals = y;
				} 
			}
			};
			performerThread.start();
			}


}