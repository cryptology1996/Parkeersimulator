package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.*;
/**
 * Class for the Text overview
 * @author Martijn Bakker, Albert van der Berg, Antonie Groenveld, Arneld van der Veen and Daniel Bouius
 *
 */

public class TextOverview extends AbstractView {
	private JTextField txtRevenue;
	private JTextField txtExpRevenue;
	private Simulator simulator;

	double ticketPrice = 7.50;
	
	
	
	/**
	 * Constructor for TextOverview
	 */
	
	public TextOverview(Simulator model) {
		super(model);
		
		this.simulator = model;
		//setBounds(100, 100, 450, 339);
		
		/**
		 * Create the panel
		 */
		
		JPanel revenue = new JPanel();
		revenue.setLayout(new FlowLayout());
		revenue.setBackground(Color.LIGHT_GRAY);
		JLabel lblRevenue = new JLabel("Total revenue");
		txtRevenue = new JTextField();
		txtRevenue.setEditable(false);
		txtRevenue.setColumns(10);
		txtRevenue.setBackground(Color.LIGHT_GRAY);
		txtRevenue.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		revenue.add(lblRevenue);
		revenue.add(txtRevenue);
		this.add(revenue);
	
		
		JPanel expectedRevenue = new JPanel();
		expectedRevenue.setLayout(new FlowLayout());
		expectedRevenue.setBackground(Color.LIGHT_GRAY);
		JLabel expRevL = new JLabel("Expected Revenue");
		txtExpRevenue = new JTextField();
		txtExpRevenue.setEditable(false);
		txtExpRevenue.setColumns(10);
		txtExpRevenue.setBackground(Color.LIGHT_GRAY);
		txtExpRevenue.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));
		expectedRevenue.add(expRevL);
		expectedRevenue.add(txtExpRevenue);
		this.add(expectedRevenue);
		

		// using the calc function to calc the revenue
		calcRevenue();
		// calcExpRevenue();

	}
	
	/**
	 * updates the values inside the textFields
	 */
	
	public void updateView(){
		calcRevenue();
	//	calcExpRevenue();

	}	
	
	/**
	 * calculates the revenue
	 */
	public void calcRevenue()
	{
		
		int totalCars = simulator.getPayingCars();	
		double totalRevenue = totalCars * ticketPrice;
		txtRevenue.setText(" "+totalRevenue+"$");
	}
	
	/**
	 * Calculates the expected Revenue of cars which still have to pay.
	 */
	// public void calcExpRevenue(){
		
	// int totalCarsLeft =  simulator.getAdHoc()+simulator.getSubCar();
	
//	double totalExpRevenue = totalCarsLeft * ticketPrice;
	
	//	txtExpRevenue.setText(" "+totalExpRevenue+"$");	
	//}
	

	
}