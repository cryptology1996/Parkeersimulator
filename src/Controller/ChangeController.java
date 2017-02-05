package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.*;

/**
 * Class for the ChangeController that creates the change menu in the simulator
 * Contains buttons, textfields and actionlistener.
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class ChangeController extends AbstractController implements ActionListener {
	private JLabel WeekAdHoc;
	private JLabel WeekendAdHoc;
	private JLabel WeekDayPass;
	private JLabel WeekendPass;
	private JLabel WeekReserve;
	private JLabel WeekendReserve;
	private JLabel EntrySpeed;
	private JLabel PaySpeed;
	private JLabel ExitSpeed;
	
	private boolean editable;
	
	private ActionEvent event;
	
	private JButton Set;
	private JButton Reset;
	
	private JTextField WeekAH;
	private JTextField WeekendAH;
	private JTextField WeekP;
	private JTextField WeekendP;
	private JTextField WeekRes;
	private JTextField WeekendRes;
	
	private JTextField entrySpeedtxt;
	private JTextField paySpeedtxt;
	private JTextField exitSpeedtxt;
	
	/*
	 * Constructs the constructor for ChangeController
	 */
	
	public ChangeController(Simulator simulator) {
		super (simulator);
		
		/*
		 * Add a color for buttons
		 */
		
		Color backgroundB = new Color(0x0C97C5);
		
		/*
		 * Create each textField, labels and buttons
		 */
		WeekAdHoc = new JLabel("Weekday AdHoc:    ");
		WeekAH = new JTextField(5);
		WeekAH.setText("60");
		WeekAH.setEditable(true);
		WeekAH.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(WeekAdHoc);
		add(WeekAH);
		
		WeekendAdHoc = new JLabel("Weekend AdHoc:    ");
		WeekendAH = new JTextField(5);
		WeekendAH.setText("100");
		WeekendAH.setEditable(true);
		WeekendAH.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(WeekendAdHoc);
		add(WeekendAH);
		
		
		WeekDayPass = new JLabel("Weekday Pass:       ");
		WeekP = new JTextField(5);
		WeekP.setText("25");
		WeekP.setEditable(true);
		WeekP.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(WeekDayPass);
		add(WeekP);
		
		
		WeekendPass = new JLabel("Weekend Pass:       ");
		WeekendP = new JTextField(5);
		WeekendP.setText("10");
		WeekendP.setEditable(true);
		WeekendP.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(WeekendPass);
		add(WeekendP);
		
		
		WeekReserve = new JLabel("Weekday Reserve: ");
		WeekRes = new JTextField(5);
		WeekRes.setText("25");
		WeekRes.setEditable(true);
		WeekRes.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(WeekReserve);
		add(WeekRes);
		
		
		WeekendReserve = new JLabel("Weekend Reserve: ");
		WeekendRes = new JTextField(5);
		WeekendRes.setText("10");
		WeekendRes.setEditable(true);
		WeekendRes.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(WeekendReserve);
		add(WeekendRes);
		
		JLabel emptyspace = new JLabel("                                              ");
		add(emptyspace);
		
		EntrySpeed = new JLabel("Entry Speed:             ");
		entrySpeedtxt = new JTextField(5);
		entrySpeedtxt.setText("3");
		entrySpeedtxt.setEditable(true);
		entrySpeedtxt.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(EntrySpeed);
		add(entrySpeedtxt);
		
		PaySpeed = new JLabel("Payment Speed:      ");
		paySpeedtxt = new JTextField(5);
		paySpeedtxt.setText("5");
		paySpeedtxt.setEditable(true);
		paySpeedtxt.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(PaySpeed);
		add(paySpeedtxt);
		
		ExitSpeed = new JLabel("Exit Speed:                ");
		exitSpeedtxt = new JTextField(5);
		exitSpeedtxt.setText("7");
		exitSpeedtxt.setEditable(true);
		exitSpeedtxt.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(ExitSpeed);
		add(exitSpeedtxt);
		
		
		
		Set = new JButton("Set");
		Set.addActionListener((ActionListener) this);
		Set.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		Set.setPreferredSize(new Dimension(70, 20));
		Set.setBackground(backgroundB);
		Set.setForeground(Color.WHITE);
		add(Set);
		
		Reset = new JButton("Reset");
		Reset.addActionListener((ActionListener) this);
		Reset.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
		Reset.setPreferredSize(new Dimension(70, 20));
		Reset.setBackground(backgroundB);
		Reset.setForeground(Color.WHITE);
		add(Reset);
		
		
		
		
		
		
	}
		
	/**
     * Sets the from the ActionListener recieved ActionEvent to the field event
     * @param e
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
			
			if (command == "Set"){
					int Weekah  = Integer.parseInt(WeekAH.getText().trim());
					simulator.ChangeWeekAH(Weekah);
					
					int Weekendah  = Integer.parseInt(WeekendAH.getText().trim());
					simulator.ChangeWeekendAH(Weekendah);
					
					int weekp  = Integer.parseInt(WeekP.getText().trim());
					simulator.ChangeWeekP(weekp);
					
					int weekendp  = Integer.parseInt(WeekendP.getText().trim());
					simulator.ChangeWeekendP(weekendp);
					
					int weekres = Integer.parseInt(WeekRes.getText().trim());
					simulator.ChangeWeekRes(weekres);
					
					int Weekendres  = Integer.parseInt(WeekendRes.getText().trim());
					simulator.ChangeWeekendRes(Weekendres);
					
					int entryspeed = Integer.parseInt(entrySpeedtxt.getText().trim());
					simulator.ChangeEntrySpeed(entryspeed);
					
					int payspeed = Integer.parseInt(paySpeedtxt.getText().trim());
					simulator.ChangePaySpeed(payspeed);
					
					int exitspeed = Integer.parseInt(exitSpeedtxt.getText().trim());
					simulator.ChangeExitSpeed(exitspeed);
					
					WeekAH.setEditable(false);
					WeekendAH.setEditable(false);
					WeekP.setEditable(false);
					WeekendP.setEditable(false);
					WeekRes.setEditable(false);
					WeekendRes.setEditable(false);
					entrySpeedtxt.setEditable(false);
					paySpeedtxt.setEditable(false);
					exitSpeedtxt.setEditable(false);
					
					simulator.setSet(true);
					simulator.setStart(false);

				}
			
			if (command == "Reset"){
				
				WeekAH.setEditable(true);
				WeekAH.setText("60");
				
				WeekendAH.setEditable(true);
				WeekendAH.setText("100");
				
				WeekP.setEditable(true);
				WeekP.setText("25");
				
				WeekendP.setEditable(true);
				WeekendP.setText("10");
				
				WeekRes.setEditable(true);
				WeekRes.setText("25");
				
				WeekendRes.setEditable(true);
				WeekendRes.setText("10");
				
				entrySpeedtxt.setEditable(true);
				entrySpeedtxt.setText("3");
				
				paySpeedtxt.setEditable(true);
				paySpeedtxt.setText("7");
				
				exitSpeedtxt.setEditable(true);
				exitSpeedtxt.setText("5");
				
				simulator.setSet(false);
				
				
			}
			}
			};
			performerThread.start();
			}
	
	 
	  



}