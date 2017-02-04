package View;

import javax.swing.*;
import java.awt.*;

import Model.*;

/**
 * Class for the Queue overview
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class QueueView extends AbstractView{
	private JTextField txtEntranceQueue;
	private JTextField txtEntrancePassQueue;
	private JTextField txtExitQueue;
	private Simulator simulator;

	/**
	 * Constructor for TextOverview
	 */	
	public QueueView(Simulator model) {
		super(model);
		this.simulator = model;
		
		/**
		 * Create the panel
		 */	
		this.setLayout(new GridLayout(0,1));
		JPanel queue = new JPanel();
		queue.setBackground(Color.LIGHT_GRAY);
		
		/*
		 * Entrance Queue JTextField and JLabel
		 */
		JLabel lblEntranceQueue = new JLabel("Entrance Queue:                                       ");
		txtEntranceQueue = new JTextField("        0");
		txtEntranceQueue.setColumns(5);
		txtEntranceQueue.setEditable(false);
		txtEntranceQueue.setBackground(Color.LIGHT_GRAY);
		txtEntranceQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
		queue.add(lblEntranceQueue);
		queue.add(txtEntranceQueue);
		
		/*
		 * Entrance Pass Queue JTextField and JLabel
		 */
		
		JLabel lblEntrancePassQueue = new JLabel("Entrance Pass Queue:                            ");
		txtEntrancePassQueue = new JTextField("        0");
		txtEntrancePassQueue.setColumns(5);
		txtEntrancePassQueue.setEditable(false);
		txtEntrancePassQueue.setBackground(Color.LIGHT_GRAY);
		txtEntrancePassQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
		queue.add(lblEntrancePassQueue);
		queue.add(txtEntrancePassQueue);
		
		/*
		 * Exit Queue JTextField and JLabel
		 */
		JLabel lblExitQueue = new JLabel("Exit Queue:                                                 ");
		txtExitQueue = new JTextField("        0");
		txtExitQueue.setColumns(5);
		txtExitQueue.setEditable(false);
		txtExitQueue.setBackground(Color.LIGHT_GRAY);
		txtExitQueue.setBorder(BorderFactory.createLineBorder(Color.black,1));
		queue.add(lblExitQueue);
		queue.add(txtExitQueue);
		
		/*
		 * Add everything to the JPanel
		 */
		this.add(queue);
		
		/*
		 * Using Entrance and Exit Car Queue		
		 */
		
	}
	
	public void updateView(){
		entranceQueue();
		entrancePassQueue();
		exitQueue();
	}
	
	/*
	 * Fill Entrance Queue text field
	 */
	
	public void entranceQueue() {
		int entranceQueue = simulator.getEntranceCarQueue();
		txtEntranceQueue.setText("        "+entranceQueue);
	}
	
	/*
	 * Fill Entrance Pass Queue text field
	 */
	
	public void entrancePassQueue() {
	int entrancePassQueue = simulator.getPassCarQueue();
	txtEntrancePassQueue.setText("        "+entrancePassQueue);
	}
	
	/*
	 * Fill Exit Queue text field
	 */
	public void exitQueue() {
		int exitQueue = simulator.getExitCarQueue();
		txtExitQueue.setText("        "+exitQueue);
	}
}
